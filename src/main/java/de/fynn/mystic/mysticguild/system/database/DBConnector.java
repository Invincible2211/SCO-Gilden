package de.fynn.mystic.mysticguild.system.database;

import de.fynn.mystic.mysticguild.MysticGuild;
import org.bukkit.Bukkit;

import java.sql.*;

public final class DBConnector {

    private static DBConnector instance;
    private Connection connection;
    private Statement statement;
    private final String[] data;

    public DBConnector(String[] data){
        instance = this;
        this.data = data;
        connect();
    }

    public void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://"+data[0]+":"+data[1]+"?useSSL=false",data[2], data[3]);
            statement = connection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void executeSQL(String sql){
        validateConnection();
        try {
            statement.execute(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void executeSQLAsync(String sql){
        validateConnection();
        Bukkit.getScheduler().runTaskAsynchronously(MysticGuild.getInstance(),()->{
            try {
                statement.execute(sql);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }

    public void update(String sql){
        validateConnection();
        try {
            statement.executeUpdate(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateAsync(String sql){
        validateConnection();
        Bukkit.getScheduler().runTaskAsynchronously(MysticGuild.getInstance(),()->{
            try {
                statement.executeUpdate(sql);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }

    public ResultSet executeQuerry(String sql){
        validateConnection();
        try {
            return statement.executeQuery(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void validateConnection(){
        try {
            if(connection==null||connection.isClosed()){
                connect();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static DBConnector getInstance() {
        return instance;
    }

}
