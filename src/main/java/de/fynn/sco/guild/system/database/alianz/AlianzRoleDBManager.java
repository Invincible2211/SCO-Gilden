package de.fynn.sco.guild.system.database.alianz;

import de.fynn.sco.guild.community.alianz.OfflineAlianz;
import de.fynn.sco.guild.community.permission.PermissionDataFactory;
import de.fynn.sco.guild.community.role.Role;
import de.fynn.sco.guild.system.database.CommunityRoleDBManager;
import de.fynn.sco.guild.system.database.DBConnector;
import de.fynn.sco.guild.system.file.ConfigHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlianzRoleDBManager extends CommunityRoleDBManager {

    private String table;
    private String schema;
    private final OfflineAlianz parent;
    private final static DBConnector CONNECTOR = DBConnector.getInstance();

    public AlianzRoleDBManager(OfflineAlianz parent) {
        super(parent);
        this.parent = parent;
        schema = ConfigHandler.getDBSchema();
        table = schema+"."+parent.getUuid()+".role";
    }

    @Override
    public Role getDefaultRole() {
        ResultSet result = CONNECTOR.executeQuerry("SELECT defaultRole FROM "+schema+".alianz WHERE uuid = '"+parent.getUuid().toString()+"';");
        try {
            result.next();
            String role = result.getString(1);
            result = CONNECTOR.executeQuerry("SELECT * FROM "+table+" WHERE role = '"+role+"';");
            result.next();
            return new Role(role,Integer.parseInt(result.getString(3)), new PermissionDataFactory().getAlianzPermissionData(result.getString(2)));
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public void setDefaultRole(String role) {
        CONNECTOR.updateAsync("UPDATE "+schema+".alianz SET defaultRole = '"+role+"' WHERE uuid = '"+parent.getUuid().toString()+"';");
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
            return new Role(role,Integer.parseInt(result.getString(3)), new PermissionDataFactory().getAlianzPermissionData(result.getString(2)));
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
