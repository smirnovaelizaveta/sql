package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Repository<K, E> {

    void create(E e) throws SQLException;
    E read(K k) throws SQLException;
    void update(E e) throws SQLException;
    void delete(K k) throws SQLException;

}
