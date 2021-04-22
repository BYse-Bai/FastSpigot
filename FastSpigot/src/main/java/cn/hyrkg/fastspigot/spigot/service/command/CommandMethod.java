package cn.hyrkg.fastspigot.spigot.service.command;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

@RequiredArgsConstructor
public class CommandMethod {
    public final FastCommand commandInfo;
    private Method loadedMethod;

    private Class senderClazz;
    private ArrayList<Class> parameters = new ArrayList<>();
    private Class endClazz;

    @SneakyThrows
    public CommandMethod readMethod(Method method) {
        this.loadedMethod = method;

        if (method.getParameterCount() == 0)
            return null;

        if (!isValidSenderClass(method.getParameterTypes()[0]))
            return null;

        senderClazz = method.getParameterTypes()[0];

        for (int i = 0; i < (method.getParameterCount()); i++) {
            Parameter parameter = method.getParameters()[1 + i];
            parameters.add(parameter.getType());
            endClazz = parameter.getType();
        }
        return this;
    }

    public boolean isAppropriate(CommandSender commandSender, String[] args) {
        Preconditions.checkNotNull(commandSender);
        Preconditions.checkNotNull(args);

        if (!commandSender.getClass().equals(senderClazz))
            return false;

        if (endClazz.equals(String[].class))
            return args.length >= parameters.size();
        else
            return args.length == parameters.size();
    }


    public void handleCommandMethod(Object instance, CommandSender commandSender, String[] args) {
        ArrayList<Object> argObjList = new ArrayList<>();

        int index = 0;
        for (Class clazz : parameters) {
            if (clazz.equals(String[].class)) {
                String[] strings = new String[args.length - index];
                for (int i = 0; i < strings.length; i++)
                    strings[i] = args[index + i];
                argObjList.add(strings);
                break;
            }

            String value = args[index];

            if (int.class.equals(clazz) || Integer.class.equals(clazz)) {
                argObjList.add(Integer.parseInt(value));
            } else if (double.class.equals(clazz) || Double.class.equals(clazz)) {
                argObjList.add(Double.parseDouble(value));
            } else if (String.class.equals(clazz)) {
                argObjList.add(value);
            }


            index += 1;
        }
    }

    private boolean isValidSenderClass(Class clazz) {
        return clazz.equals(CommandSender.class) || clazz.equals(Player.class);
    }
}
