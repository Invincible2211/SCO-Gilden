package de.fynn.sco.guild.system.event.listener;

import de.fynn.sco.guild.community.alianz.AlianzManager;
import de.fynn.sco.guild.community.guild.GuildManager;
import de.fynn.sco.guild.community.permission.PermissionData;
import de.fynn.sco.guild.community.role.Role;
import de.fynn.sco.guild.system.utils.InputValidate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

public class ChatListener implements Listener {

    private static ChatListener instance;

    private static final HashMap<Player,ChatAction> observedPlayers = new HashMap<>();
    private final GuildManager guildManager = GuildManager.getInstance();
    private final AlianzManager alianzManager = AlianzManager.getInstance();

    {
        instance = this;
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        if(observedPlayers.containsKey(p)){
            if(event.getMessage().equals("cancel")){
                observedPlayers.remove(p);
            }else {
                observedPlayers.remove(p).performAction(p, event.getMessage());
            }
            event.setCancelled(true);
        }
    }

    public <T> void addPlayer(Player player,ActionType action, T... data){
        switch (action){
            case CREATE_GUILD:
                observedPlayers.put(player, new CreateGuild());
                break;
            case RENAME_GUILD:
                observedPlayers.put(player, new RenameGuild());
                break;
            case CREATE_ALIANZ:
                observedPlayers.put(player, new CreateAlianz());
                break;
            case RENAME_ALIANZ:
                observedPlayers.put(player, new RenameAlianz());
                break;
            case CREATE_GUILD_ROLE:
                observedPlayers.put(player, new CreateGuildRole((Integer) data[0],(PermissionData) data[1]));
                break;
            case RENAME_GUILD_ROLE:
                observedPlayers.put(player, new RenameGuildRole((String)data[0]));
                break;
            case CREATE_ALIANZ_ROLE:
                observedPlayers.put(player, new CreateAlianzRole((Integer) data[0],(PermissionData) data[1]));
                break;
            case RENAME_ALIANZ_ROLE:
                observedPlayers.put(player, new RenameAlianzRole((String)data[0]));
                break;
            case RENAME_GUILD_PREFIX:
                observedPlayers.put(player, new RenameGuildPrefix());
                break;
            case RENAME_ALIANZ_PREFIX:
                observedPlayers.put(player, new RenameAlianzPrefix());
                break;
        }
    }

    private interface ChatAction{
        public void performAction(Player player,String msg);
    }

    private class CreateGuild implements ChatAction{

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.defaultValidation(msg)){
                guildManager.createGuild(player.getUniqueId(),msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class RenameGuild implements ChatAction{

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.defaultValidation(msg)){
                guildManager.renameGuild(guildManager.getPlayerGuildAsString(player.getUniqueId()),msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class CreateAlianz implements ChatAction{

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.defaultValidation(msg)){
                alianzManager.createAlianz(player.getUniqueId(),msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class RenameAlianz implements ChatAction{

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.defaultValidation(msg)){
                alianzManager.renameAlianz(alianzManager.getPlayerAlianzAsString(player.getUniqueId()),msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class CreateGuildRole implements ChatAction{

        private int priority;
        private PermissionData permData;

        public CreateGuildRole(int priority, PermissionData permData){
            this.priority = priority;
            this.permData = permData;
        }

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.validateRoleNameGuild(msg,guildManager.getPlayerGuildAsString(player.getUniqueId()))){
                guildManager.getPlayerGuild(player.getUniqueId()).getRoleManager().addRole(new Role(msg,priority,permData));
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class RenameGuildRole implements ChatAction{

        private String role;

        public RenameGuildRole(String role){
            this.role = role;
        }

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.validateRoleNameGuild(msg,guildManager.getPlayerGuildAsString(player.getUniqueId()))){
                guildManager.getPlayerGuild(player.getUniqueId()).getRoleManager().renameRole(role, msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class CreateAlianzRole implements ChatAction{

        private int priority;
        private PermissionData permData;

        public CreateAlianzRole(int priority, PermissionData permData){
            this.priority = priority;
            this.permData = permData;
        }

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.validateRoleNameGuild(msg,guildManager.getPlayerGuildAsString(player.getUniqueId()))){
                alianzManager.getPlayerAlianz(player.getUniqueId()).getRoleManager().addRole(new Role(msg,priority,permData));
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class RenameAlianzRole implements ChatAction{

        private String role;

        public RenameAlianzRole(String role){
            this.role = role;
        }

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.validateRoleNameGuild(msg,guildManager.getPlayerGuildAsString(player.getUniqueId()))){
                alianzManager.getPlayerAlianz(player.getUniqueId()).getRoleManager().renameRole(role, msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class RenameGuildPrefix implements ChatAction{

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.validatePrefix(msg)){
                guildManager.getPlayerGuild(player.getUniqueId()).setPrefix(msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    private class RenameAlianzPrefix implements ChatAction{

        @Override
        public void performAction(Player player, String msg) {
            if(InputValidate.validatePrefix(msg)){
                alianzManager.getPlayerAlianz(player.getUniqueId()).setPrefix(msg);
            }else {
                observedPlayers.put(player,this);
            }
        }
    }

    public enum ActionType{
        CREATE_GUILD,RENAME_GUILD,CREATE_ALIANZ,RENAME_ALIANZ,CREATE_GUILD_ROLE,RENAME_GUILD_ROLE,CREATE_ALIANZ_ROLE,RENAME_ALIANZ_ROLE,RENAME_GUILD_PREFIX,RENAME_ALIANZ_PREFIX
    }

    public static ChatListener getInstance() {
        return instance;
    }

}
