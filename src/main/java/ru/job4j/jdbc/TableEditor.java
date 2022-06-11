package ru.job4j.jdbc;

import java.io.FileReader;
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


            connection = DriverManager.getConnection(url, login, password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void executeSQL(String sql) {

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        final String sql = String.format("create table if not exists %s() ;", tableName);
        executeSQL(sql);
    }

    public void dropTable(String tableName) {
        final String sql = String.format("drop table if exists %s;", tableName);
        executeSQL(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        final String sql = String.format("alter table if exists %s add column if not exists %s %s ;", tableName, columnName, type);
        executeSQL(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        final String sql = String.format("alter table if exists %s drop column if exists %s ;", tableName, columnName);
        executeSQL(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        final String sql = String.format("alter table if exists %s rename column %s to %s ;", tableName, columnName, newColumnName);
        executeSQL(sql);
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
        final String table_name = "example_table";

        try (FileReader fileReader = new FileReader("app.properties")) {
            properties.load(fileReader);
            TableEditor tableEditor = new TableEditor(properties);

            System.out.println("--Create--");
            tableEditor.createTable(table_name);
            System.out.println(TableEditor.getTableScheme(tableEditor.connection, table_name));
            System.out.println();

            System.out.println("--Add column--");
            tableEditor.addColumn(table_name, "column1", "integer");
            tableEditor.addColumn(table_name, "column2", "varchar(255)");
            System.out.println(TableEditor.getTableScheme(tableEditor.connection, table_name));
            System.out.println();

            System.out.println("--Rename column--");
            tableEditor.renameColumn(table_name, "column1", "co3");
            System.out.println(TableEditor.getTableScheme(tableEditor.connection, table_name));
            System.out.println();


            System.out.println("--Drop column--");
            tableEditor.dropColumn(table_name, "column2");
            System.out.println(TableEditor.getTableScheme(tableEditor.connection, table_name));
            System.out.println();

            System.out.println("--Drop table--");
            tableEditor.dropTable(table_name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}