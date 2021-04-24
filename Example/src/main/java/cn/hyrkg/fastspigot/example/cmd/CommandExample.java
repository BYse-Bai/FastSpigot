package cn.hyrkg.fastspigot.example.cmd;

import cn.hyrkg.fastspigot.spigot.service.command.FastCommand;
import cn.hyrkg.fastspigot.spigot.service.command.IFastCommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class CommandExample implements IFastCommandExecutor {

    @FastCommand(desc = "测试命令", index = "test")
    public void onTest(CommandSender sender) {
        sender.sendMessage("测试！");
    }

    @FastCommand(desc = "测试命令2", index = "test", paramsName = {"大小", "数组"})
    public void onTest2(CommandSender sender, int size, String... strings) {
        sender.sendMessage("测试！" + size);
        sender.sendMessage("" + Arrays.asList(strings));
    }

    public String getCommand() {
        return "example";
    }
}
