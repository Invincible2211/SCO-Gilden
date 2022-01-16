package de.fynn.mystic.mysticguild;

import de.fynn.mystic.mysticguild.command.OpenGuildGUICMD;
import de.fynn.mystic.mysticguild.community.alianz.AlianzManager;
import de.fynn.mystic.mysticguild.community.guild.GuildManager;
import de.fynn.mystic.mysticguild.system.data.SignMenuFactory;
import de.fynn.mystic.mysticguild.system.database.DBConnector;
import de.fynn.mystic.mysticguild.system.database.DBManager;
import de.fynn.mystic.mysticguild.system.event.listener.ChatListener;
import de.fynn.mystic.mysticguild.system.event.listener.DisconnectListener;
import de.fynn.mystic.mysticguild.system.event.listener.InventoryClickListener;
import de.fynn.mystic.mysticguild.system.event.listener.JoinListener;
import de.fynn.mystic.mysticguild.system.file.ConfigHandler;
import de.fynn.mystic.mysticguild.system.hook.MysticLanguageAPIHook;
import de.fynn.mystic.mysticguild.system.hook.MysticPlaceholderAPIHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Freddyblitz
 */

public final class MysticGuild extends JavaPlugin {

    private static MysticGuild instance;

    private static boolean mysticPlaceholderAPI;
    private static boolean mysticLanguageAPI;

    /**
     * Default constructor,
     * Save current class instance in static variable instance
     */
    public MysticGuild(){
        instance = this;
    }

    /**
     * Plugin startup logic
     */
    @Override
    public void onEnable() {
        //create instance of SignMenuFactory
        new SignMenuFactory(this);

        //Initialize database and all community manager classes
        new DBConnector(ConfigHandler.getDBData());
        new DBManager();
        new GuildManager();
        new AlianzManager();

        //checking for soft dependencies
        checkForSoftDependencies();
        if (mysticPlaceholderAPI)hookMysticPlaceholderAPI();
        if(mysticLanguageAPI)hookMysticLanguageAPI();

        //get pluginmanager
        PluginManager pluginManager = Bukkit.getPluginManager();

        //register EventListener
        pluginManager.registerEvents(new JoinListener(),this);
        pluginManager.registerEvents(new DisconnectListener(),this);
        pluginManager.registerEvents(new ChatListener(),this);
        pluginManager.registerEvents(new InventoryClickListener(),this);

        //register Commands
        getCommand("guild").setExecutor(new OpenGuildGUICMD());
    }

    /**
     * Plugin shutdown logic
     */
    @Override
    public void onDisable() {

    }

    /**
     * Checks for all softdependencies
     */
    private void checkForSoftDependencies(){
        for (Plugin pl:
                Bukkit.getPluginManager().getPlugins()) {
            if(pl.getName().equals("MysticPlaceholderAPI"))mysticPlaceholderAPI = true;
            if(pl.getName().equals("MysticLanguageAPI"))mysticLanguageAPI = true;
        }
    }

    /**
     * hooks into MysticPlaceholderAPI
     */
    private void hookMysticPlaceholderAPI(){
        MysticPlaceholderAPIHook mysticPlaceholderAPIHook = new MysticPlaceholderAPIHook(this);
        this.getLogger().info("Hooked into MysticPlaceholderAPI");
    }

    /**
     * hooks into MysticLanguageAPI
     */
    private void hookMysticLanguageAPI(){
        MysticLanguageAPIHook mysticLanguageAPIHook = new MysticLanguageAPIHook(this);
        this.getLogger().info("Hooked into MysticLanguageAPI");
    }

    /**
     * returns the plugin instance
     * @return the current instance of the plugin
     */
    public static MysticGuild getInstance() {
        return instance;
    }

    /**
     * returns if the MysticLanguageAPI is used
     * @return true if the API is used otherwise false
     */
    public static boolean isMysticLanguageAPI() {
        return mysticLanguageAPI;
    }

    /**
     * returns if the MysticPlaceholderAPI is used
     * @return true if the API is used otherwise false
     */
    public static boolean isMysticPlaceholderAPI() {
        return mysticPlaceholderAPI;
    }

    /**
     *  WIP
     *  Clean plugin reload
     */
    public void reload(){

    }

}
