package de.fynn.sco.guild.system.database;

import de.fynn.sco.guild.community.alianz.Alianz;
import de.fynn.sco.guild.community.alianz.OfflineAlianz;
import de.fynn.sco.guild.community.guild.Guild;
import de.fynn.sco.guild.community.guild.OfflineGuild;
import de.fynn.sco.guild.community.role.Role;
import de.fynn.sco.guild.system.file.ConfigHandler;
import org.bukkit.Bukkit;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBManager {

    private final DBConnector dbConnector = DBConnector.getInstance();
    private final String schema;
    private static DBManager instance;

    {
        schema = ConfigHandler.getDBSchema();
        init();
        instance = this;
    }

    private void init(){
        dbConnector.executeSQL("CREATE SCHEMA IF NOT EXISTS "+schema+";");
        dbConnector.executeSQL("CREATE TABLE IF NOT EXISTS "+schema+".guild (uuid VARCHAR(32), name VARCHAR(32), leader VARCHAR(32), level TINYINT, xp FLOAT, prefix VARCHAR(4), status TINYINT, invUpgrades TINYINT, defaultRole VARCHAR(32), description MEDIUMTEXT, PRIMARY KEY (uuid));");
        dbConnector.executeSQL("CREATE TABLE IF NOT EXISTS "+schema+".alianz (uuid VARCHAR(32), name VARCHAR(32), leader VARCHAR(32), level TINYINT, xp FLOAT, prefix VARCHAR(4), status TINYINT, defaultRole VARCHAR(32), description MEDIUMTEXT, PRIMARY KEY (uuid));");
        dbConnector.executeSQL("CREATE TABLE IF NOT EXISTS "+schema+".war (uuid_1 VARCHAR(32), uuid_2 VARCHAR(32), startTime DATETIME, PRIMARY KEY(uuid_1,uuid_2));");
    }

    public void addGuild(Guild guild){
        dbConnector.executeSQLAsync("INSERT INTO "+schema+".guild (uuid,name,leader,level,xp,prefix,status,invUpgrades,defaultRole,description) VALUES " +
                "('"+guild.getUuid().toString()+"'," +
                "'"+guild.getName()+"'," +
                "'"+guild.getOwner()+"'," +
                "0," +
                "0.0," +
                "'"+guild.getPrefix()+"'," +
                ""+guild.getStatus().value+"," +
                "0," +
                "'"+guild.getDefaultRole().getName()+"'," +
                "'"+guild.getDescription()+"');");
        //create tables
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+guild.getUuid().toString()+" (uuid VARCHAR(32), displayname VARCHAR(16), role VARCHAR(32), PRIMARY KEY (uuid));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+guild.getUuid().toString()+".role (role VARCHAR(32), data VARCHAR(32), priority TINYINT, PRIMARY KEY (role));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+guild.getUuid().toString()+".banned (uuid VARCHAR(32), displayname VARCHAR(32), PRIMARY KEY (uuid));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+guild.getUuid().toString()+".invited (uuid VARCHAR(32), displayname VARCHAR(32), PRIMARY KEY (uuid));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+guild.getUuid().toString()+".joinRequests (uuid VARCHAR(32), displayname VARCHAR(32), PRIMARY KEY (uuid));");
        //insert data
        dbConnector.executeSQLAsync("INSERT INTO "+schema+"."+guild.getUuid().toString()+" (uuid,displayname,role) VALUES ('"+guild.getOwner()+"','"+ Bukkit.getPlayer(guild.getOwner()) +"','owner');");
        dbConnector.executeSQLAsync("INSERT INTO "+schema+"."+guild.getUuid().toString()+".role (role,data) VALUES ('default','"+ Role.getGuildDefaultRole().toString() +"',0);");
        dbConnector.executeSQLAsync("INSERT INTO "+schema+"."+guild.getUuid().toString()+".role (role,data) VALUES ('owner','"+Role.getGuildSuperRole().toString() +"',255);");
    }

    public void addAlianz(Alianz alianz){
        dbConnector.executeSQLAsync("INSERT INTO "+schema+".alianz (uuid,name,leader,level,xp,prefix,status,defaultRole,description) VALUES " +
                "('"+alianz.getUuid().toString()+"'," +
                "'"+alianz.getName()+"'," +
                "'"+alianz.getOwner()+"'," +
                "0," +
                "0.0," +
                "'"+alianz.getPrefix()+"'," +
                ""+alianz.getStatus().value+"," +
                "'"+alianz.getDefaultRole().getName()+"'," +
                "'"+alianz.getDescription()+"');");
        //create tables
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+alianz.getUuid().toString()+" (uuid VARCHAR(32), role VARCHAR(32), PRIMARY KEY (uuid));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+alianz.getUuid().toString()+".role (role VARCHAR(32), data VARCHAR(32), priority TINYINT, PRIMARY KEY (role));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+alianz.getUuid().toString()+".banned (uuid VARCHAR(32), PRIMARY KEY (uuid));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+alianz.getUuid().toString()+".invited (uuid VARCHAR(32), PRIMARY KEY (uuid));");
        dbConnector.executeSQLAsync("CREATE TABLE "+schema+"."+alianz.getUuid().toString()+".joinRequests (uuid VARCHAR(32), PRIMARY KEY (uuid));");
        //insert data
        dbConnector.executeSQLAsync("INSERT INTO "+schema+"."+alianz.getUuid().toString()+" (uuid,role) VALUES ('"+alianz.getOwner()+"','owner');");
        dbConnector.executeSQLAsync("INSERT INTO "+schema+"."+alianz.getUuid().toString()+".role (role,data) VALUES ('default','"+Role.getAlianzDefaultRole().toString() +"',0);");
        dbConnector.executeSQLAsync("INSERT INTO "+schema+"."+alianz.getUuid().toString()+".role (role,data) VALUES ('owner','"+Role.getAlianzSuperRole().toString() +"',255);");
    }

    public void declareWar(UUID c1, UUID c2, Date startTime){
        dbConnector.executeSQLAsync("INSERT INTO "+schema+".war (uuid_1,uuid_2,startTime) VALUES ('"+c1.toString()+"','"+c2.toString()+"',"+startTime.toString()+");");
    }

    public void endWar(UUID c1, UUID c2){
        dbConnector.executeSQLAsync("DELETE FROM "+schema+".war WHERE uui1_1 = '"+c1.toString()+"' AND uuid_2 = '"+c2.toString()+"';");
    }

    public static DBManager getInstance() {
        return instance;
    }

    public List<OfflineGuild> getGuildList(){
        List<OfflineGuild> guilds = new ArrayList<>();
        try {
            ResultSet result = dbConnector.executeQuerry("SELECT uuid FROM "+schema+".guild");
            while (result.next()){
                guilds.add(new OfflineGuild(UUID.fromString(result.getString(1))));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return guilds;
    }

    public List<OfflineAlianz> getAlianzList(){
        List<OfflineAlianz> alianz = new ArrayList<>();
        try {
            ResultSet result = dbConnector.executeQuerry("SELECT uuid FROM "+schema+".alianz");
            while (result.next()){
                alianz.add(new OfflineAlianz(UUID.fromString(result.getString(1))));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return alianz;
    }

}
