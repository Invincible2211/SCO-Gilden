package de.fynn.mystic.mysticguild.system.database.guild;

import de.fynn.mystic.mysticguild.community.guild.OfflineGuild;
import de.fynn.mystic.mysticguild.community.permission.PermissionDataFactory;
import de.fynn.mystic.mysticguild.community.role.Role;
import de.fynn.mystic.mysticguild.system.database.CommunityRoleDBManager;
import de.fynn.mystic.mysticguild.system.database.DBConnector;
import de.fynn.mystic.mysticguild.system.file.ConfigHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildRoleDBManager extends CommunityRoleDBManager {

    private String table;
    private String schema;
    private OfflineGuild parent;
    private final static DBConnector CONNECTOR = DBConnector.getInstance();

    public GuildRoleDBManager(OfflineGuild parent) {
        super(parent);
        this.parent = parent;
        schema = ConfigHandler.getDBSchema();
        table = schema+"."+parent.getUuid()+".role";
    }

    @Override
    public Role getDefaultRole() {
        ResultSet result = CONNECTOR.executeQuerry("SELECT defaultRole FROM "+schema+".guild WHERE uuid = '"+parent.getUuid().toString()+"';");
        try {
            result.next();
            String role = result.getString(1);
            result = CONNECTOR.executeQuerry("SELECT * FROM "+table+" WHERE role = '"+role+"';");
            result.next();
            return new Role(role,Integer.parseInt(result.getString(3)), new PermissionDataFactory().getGuildPermissionData(result.getString(2)));
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public void setDefaultRole(String role) {
        CONNECTOR.updateAsync("UPDATE "+schema+".guild SET defaultRole = '"+role+"' WHERE uuid = '"+parent.getUuid().toString()+"';");
    }

    @Override
    public void addRole(Role role) {
        CONNECTOR.executeSQLAsync("INSERT INTO "+table+" (role,data,priority) VALUES ('"+role.getName()+"','"+role.getData().toString()+"',"+role.getPriority()+");");
    }

    @Override
    public void removeRole(String role) {
        CONNECTOR.executeSQLAsync("DELETE FROM "+table+" WHERE role = '"+role+"';");
    }

    @Override
    public void setRole(UUID uuid, String role) {
        CONNECTOR.updateAsync("UPDATE "+schema+"."+parent.getUuid().toString()+" SET role = '"+role+"' WHERE uuid = '"+uuid+"';");
    }

    @Override
    public String getMemberRole(UUID uuid) {
        ResultSet result = CONNECTOR.executeQuerry("SELECT role FROM "+schema+"."+parent.getUuid().toString()+" WHERE uuid = '"+uuid.toString()+"';");
        try {
            result.next();
            return result.getString(1);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return "";
        }
    }

    @Override
    public Role getRole(String role) {
        try {
            ResultSet result = CONNECTOR.executeQuerry("SELECT * FROM "+table+" WHERE role = '"+role+"';");
            result.next();
            return new Role(role,Integer.parseInt(result.getString(3)), new PermissionDataFactory().getGuildPermissionData(result.getString(2)));
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getRoleList() {
        List<String> roles = new ArrayList<>();
        ResultSet result = CONNECTOR.executeQuerry("SELECT role FROM "+table+";");
        try {
            while (result.next()){
                roles.add(result.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void updateRole(String roleName, Role role) {
        CONNECTOR.updateAsync("UPDATE "+table+" SET data = '"+role.getData().toString()+"', priority = "+role.getPriority()+" WHERE role = '"+roleName+"';");
    }

}
