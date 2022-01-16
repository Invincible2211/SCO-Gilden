package de.fynn.sco.guild.system.messages;

import de.fynn.sco.guild.Guild;
import de.fynn.sco.guild.system.hook.MysticLanguageAPIHook;
import de.fynn.sco.guild.system.hook.MysticPlaceholderAPIHook;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Freddyblitz
 */

public class MessageManager {

    private static MysticPlaceholderAPIHook placeholderAPIHook;
    private static MysticLanguageAPIHook languageAPIHook;
    private static final MessageAction messageAction;
    private static final HashMap<MSG,String> messages = new HashMap<>();

    /**
     * Static initializer, create MessageAction depending on active soft dependencies
     */
    static {
        boolean placeholder = Guild.isMysticPlaceholderAPI();
        if(placeholder) placeholderAPIHook = MysticPlaceholderAPIHook.getInstance();
        boolean language = Guild.isMysticLanguageAPI();
        if(language) languageAPIHook = MysticLanguageAPIHook.getInstance();
        if(placeholder && language){
            messageAction = new MessageAction() {
                @Override
                public <T> String performAction(UUID uuid, MSG type, T... values) {
                    return placeholderAPIHook.getPlaceholder(languageAPIHook.getMessage(uuid,type.getPath()),values);
                }
            };
        }else if(placeholder){
            loadMessages();
            messageAction = new MessageAction() {
                @Override
                public <T> String performAction(UUID uuid, MSG type, T... values) {
                    return placeholderAPIHook.getPlaceholder(getMessageFromPath(type),values);
                }
            };
        }else if(language){
            messageAction = new MessageAction() {
                @Override
                public <T> String performAction(UUID uuid, MSG type, T... values) {
                    return languageAPIHook.getMessage(uuid,type.getPath());
                }
            };
        }else {
            loadMessages();
            messageAction = new MessageAction() {
                @Override
                public <T> String performAction(UUID uuid, MSG type, T... values) {
                    return getMessageFromPath(type);
                }
            };
        }
    }

    /**
     * returns the requested message
     * @param uuid the uuid of player that need the message (relevant for different languages)
     * @param type a enum value that represents the specific message
     * @param args if more objects are required for the message
     * @param <T>
     * @return the required message that is customized to the given player
     */
    public static <T> String getMessage(UUID uuid, MSG type,T... args){
        return messageAction.performAction(uuid, type,args);
    }

    /**
     * returns the requested message with a given prefix
     * @param uuid the uuid of player that need the message (relevant for different languages)
     * @param type a enum value that represents the specific message
     * @param prefix the prefix that should be used
     * @param args if more objects are required for the message
     * @param <T>
     * @return the required message that is customized to the given player
     */
    public static <T> String getMessage(UUID uuid, MSG type,Prefix prefix,T... args){
        return prefix.getValue()+messageAction.performAction(uuid, type,args);
    }

    private static String getMessageFromPath(MSG type){
        return messages.get(type);
    }

    /**
     * loads the default messages as a fallback
     */
    private static void loadMessages(){
        FileConfiguration messageFile = YamlConfiguration.loadConfiguration(
                new InputStreamReader(MessageManager.class.getResourceAsStream("defaultMessages.yml")));
        //Command
        for (MSG msgType:
             MessageType.COMMAND.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        //Info
        for (MSG msgType:
                MessageType.INFO.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        //Error
        for (MSG msgType:
                MessageType.ERROR.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        //Questions
        for (MSG msgType:
                MessageType.QUESTION.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        //Inventorys
        for (MSG msgType:
                MessageType.INVENTORY.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        //Items
        for (MSG msgType:
                MessageType.ITEM.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        //Permissions
        for (MSG msgType:
                MessageType.PERMISSION.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        for (MSG msgType:
                MessageType.PERMISSION.GUILD_MEMBER.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        for (MSG msgType:
                MessageType.PERMISSION.GUILD.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }
        for (MSG msgType:
                MessageType.PERMISSION.ALIANZ_MEMBER.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }for (MSG msgType:
                MessageType.PERMISSION.ALIANZ.values()) {
            messages.put(msgType,messageFile.getString(msgType.getPath()));
        }

    }

    private interface MessageAction{
        public <T> String performAction(UUID uuid, MSG type, T... values);
    }

}
