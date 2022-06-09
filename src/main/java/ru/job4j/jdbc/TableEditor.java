package ru.job4j.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {

        try {
            Class.forName(properties.getProperty("hibernate.connection.driver_class"));
            String url = properties.getProperty("hibernate.connection.url");
            String login = properties.getProperty("hibernate.connection.username");
            String password = properties.getProperty("hibernate.connection.password");
            try (Connection con = DriverManager.getConnection(url, login, password)) {
                DatabaseMetaData metaData = con.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
                connection = con;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        final String sql = String.format("create table if not exists %s() ;", tableName);
        System.out.println(sql);

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
    }

    public void addColumn(String tableName, String columnName, String type) {
    }

    public void dropColumn(String tableName, String columnName) {
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String... args) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader("app.properties")) {
            properties.load(fileReader);
            TableEditor tableEditor = new TableEditor(properties);

            tableEditor.createTable("ExampleTable");
            TableEditor.getTableScheme(tableEditor.connection, "ExampleTable");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}