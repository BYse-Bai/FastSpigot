package me.kg.fast.inject.mysql2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReleasableConnection {

	private me.kg.fast.inject.mysql2_2.SimpleMysqlPool thePool;
	private Connection theConnection;

	public void release() {
		thePool.returnConnection(this);
	}

	private ReleasableConnection(me.kg.fast.inject.mysql2_2.SimpleMysqlPool pool, Connection connection) {
		this.thePool = pool;
		this.theConnection = connection;
	}

	public static ReleasableConnection link(me.kg.fast.inject.mysql2_2.SimpleMysqlPool pool, Connection connection) {
		return new ReleasableConnection(pool, connection);
	}

	public void close() {
		try {
			theConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement prepareStatement(String mysql) {
		try {
			return theConnection.prepareStatement(mysql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
