package de.fynn.sco.guild.system.file;

import com.google.common.io.Files;
import de.fynn.sco.guild.Guild;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfigHandler {

    private static FileConfiguration cfg;
    private static FileConfiguration guildCFG;
    private static FileConfiguration alianzCFG;

    static {
        init();
    }

    private static void init(){
        cfg = Guild.getInstance().getConfig();
        cfg.options().copyDefaults(true);
        Guild.getInstance().saveConfig();
        validateConfigs();
    }

    public static void validateConfigs(){
        ClassLoader classLoader = ConfigHandler.class.getClassLoader();
        File guildFile = new File(Guild.getInstance().getDataFolder()+"/guild/guild.yml");
        if(!guildFile.exists()){
            try{
                Files.createParentDirs(guildFile);
                guildCFG = YamlConfiguration.loadConfiguration(new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("guild.yml"))));
                guildCFG.save(guildFile);
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
        guildCFG = YamlConfiguration.loadConfiguration(guildFile);

        File alianzFile = new File(Guild.getInstance().getDataFolder()+"/alianz/alianz.yml");
        if(!alianzFile.exists()){
            try{
                Files.createParentDirs(alianzFile);
                alianzCFG = YamlConfiguration.loadConfiguration(new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("alianz.yml"))));
                alianzCFG.save(alianzFile);
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
        alianzCFG = YamlConfiguration.loadConfiguration(alianzFile);
    }

    public static String getCustomPrefix(){
        return cfg.getString("prefix.customPluginPrefix");
    }

    public static boolean isPrefixBeforeChatMessage(){
        return cfg.getBoolean("prefix.prefixBeforeChatMessages");
    }

    public static String[] getPermissions(){
        return new String[]{
                cfg.getString("permission.openGuildGUI"),
                cfg.getString("permission.openAlianzGUI"),
                cfg.getString("permission.createWarInstance")
        };
    }

    public static String[] getDBData(){
        return new String[]{
                cfg.getString("database.ip"),
                cfg.getString("database.port"),
                cfg.getString("database.user"),
                cfg.getString("database.password")
        };
    }

    public static String getDBSchema(){
        return cfg.getString("database.schema");
    }


    public static String getDefaultLangauge(){
        return cfg.getString("language.default");
    }

    public static double getGuildFoundingPrize(){
        return guildCFG.getDouble("FoundingPrize");
    }

    public static int getGuildMaxSizeOnFound(){
        return guildCFG.getInt("MaxSizeOnFound");
    }

    public static int getGuildSizePerLevel(){
        return guildCFG.getInt("SizePerLevel");
    }

    public static int getGuildXPPerLevel(){
        return guildCFG.getInt("XPPerLevel");
    }

    public static double getGuildLevelModifierPerLevel(){
        return guildCFG.getDouble("LevelModifierPerLevel");
    }

    public static int getMaxGuildLevel(){
        return guildCFG.getInt("MaxLevel");
    }

    public static double getGuildXPFromKill(){
        return guildCFG.getDouble("XPFromKill");
    }

    public static int getGuildInventoryDefaultSize(){
        return guildCFG.getInt("InventoryDefaultSize");
    }

    public static double getGuildInventorySlotPrize(){
        return guildCFG.getDouble("InventorySlotPrize");
    }

    public static double getAlianzFoundingPrize(){
        return alianzCFG.getDouble("FoundingPrize");
    }

    public static int getAlianzMaxSizeOnFound(){
        return alianzCFG.getInt("MaxSizeOnFound");
    }

    public static int getAlianzSizePerLevel(){
        return alianzCFG.getInt("SizePerLevel");
    }

    public static int getAlianzXPPerLevel(){
        return alianzCFG.getInt("XPPerLevel");
    }

    public static double getAlianzLevelModifierPerLevel(){
        return alianzCFG.getDouble("LevelModifierPerLevel");
    }

    public static int getMaxAlianzLevel(){
        return alianzCFG.getInt("MaxLevel");
    }

    public static double getAlianzXPFromKill(){
        return alianzCFG.getDouble("XPFromKill");
    }

    public static long getSyncTime(){
        return (cfg.getInt("system.sync_with_db")* 20L);
    }

}
