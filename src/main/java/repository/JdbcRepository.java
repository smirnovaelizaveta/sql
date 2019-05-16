package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;

public abstract class JdbcRepository{
    static final String DB_URL = "jdbc:postgresql://msk1-cbox215.unix.nspk.ru:5432/smirnovaea";
    static final String USER = "smirnovaea";
    static final String PASS = "password";

    @Deprecated
    static final Connection connection = getConnection();

    @FunctionalInterface
    static interface ConnectionConsumer {
        void doAction( Connection conn ) throws SQLException;
    }

    @FunctionalInterface
    static interface ConnectionFunction<T> {
        T doAction( Connection conn ) throws SQLException;
    }

    @Deprecated
    static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    static void withConnection(ConnectionConsumer action) throws SQLException {
        try (Connection connection = getConnection()) {
            action.doAction(connection);
        }
    }

    static <T> T withConnection(ConnectionFunction<T> action) throws SQLException {
        try (Connection connection = getConnection()) {
            return action.doAction(connection);
        }
    }
}
