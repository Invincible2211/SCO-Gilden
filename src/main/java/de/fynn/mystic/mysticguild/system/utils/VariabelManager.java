package de.fynn.mystic.mysticguild.system.utils;

import de.fynn.mystic.mysticguild.MysticGuild;
import de.fynn.mystic.mysticguild.system.file.ConfigHandler;

/**
 * @author Freddyblitz
 */

public class VariabelManager {

    /**
     * Static initializer, load all variable values from the specific config files using the ConfigHandler class
     * @see ConfigHandler
     */
    static {
        GUILD_FOUNDING_PRIZE = ConfigHandler.getGuildFoundingPrize();
        GUILD_MAX_SIZE_ON_FOUND = ConfigHandler.getGuildMaxSizeOnFound();
        GUILD_SIZE_PER_LEVEL = ConfigHandler.getGuildSizePerLevel();
        GUILD_XP_PER_LEVEL = ConfigHandler.getGuildXPPerLevel();
        GUILD_LEVEL_MODIFIER_PER_LEVEL = ConfigHandler.getGuildLevelModifierPerLevel();
        GUILD_MAX_LEVEL = ConfigHandler.getMaxGuildLevel();
        GUILD_XP_FROM_KILL = ConfigHandler.getGuildXPFromKill();
        GUILD_INVENTORY_DEFAULT_SIZE = ConfigHandler.getGuildInventoryDefaultSize();
        GUILD_INVENTORY_SLOT_PRIZE = ConfigHandler.getGuildInventorySlotPrize();

        ALIANZ_FOUNDING_PRIZE = ConfigHandler.getAlianzFoundingPrize();
        ALIANZ_MAX_SIZE_ON_FOUND = ConfigHandler.getAlianzMaxSizeOnFound();
        ALIANZ_SIZE_PER_LEVEL = ConfigHandler.getAlianzSizePerLevel();
        ALIANZ_XP_PER_LEVEL = ConfigHandler.getAlianzXPPerLevel();
        ALIANZ_LEVEL_MODIFIER_PER_LEVEL = ConfigHandler.getAlianzLevelModifierPerLevel();
        ALIANZ_MAX_LEVEL = ConfigHandler.getMaxAlianzLevel();
        ALIANZ_XP_FROM_KILL = ConfigHandler.getAlianzXPFromKill();

        String[] perm = ConfigHandler.getPermissions();
        PERMISSION_OPEN_GUILD_GUI = perm[0];
        PERMISSION_OPEN_ALINAZ_GUI = perm[1];
        PERMISSION_CREATE_BATTLE_INSTANCE = perm[2];

        PREFIX = ConfigHandler.getCustomPrefix().equals("") ? MysticGuild.getInstance().getDescription().getPrefix():ConfigHandler.getCustomPrefix();
        PREFIX_BEFORE_CHAT_MESSAGES = ConfigHandler.isPrefixBeforeChatMessage();

        SYNC_WITH_DB = ConfigHandler.getSyncTime();
    }

    public static double GUILD_FOUNDING_PRIZE;
    public static int GUILD_MAX_SIZE_ON_FOUND;
    public static int GUILD_SIZE_PER_LEVEL;
    public static int GUILD_XP_PER_LEVEL;
    public static double GUILD_LEVEL_MODIFIER_PER_LEVEL;
    public static int GUILD_MAX_LEVEL;
    public static double GUILD_XP_FROM_KILL;
    public static int GUILD_INVENTORY_DEFAULT_SIZE;
    public static double GUILD_INVENTORY_SLOT_PRIZE;

    public static double ALIANZ_FOUNDING_PRIZE;
    public static int ALIANZ_MAX_SIZE_ON_FOUND;
    public static int ALIANZ_SIZE_PER_LEVEL;
    public static int ALIANZ_XP_PER_LEVEL;
    public static double ALIANZ_LEVEL_MODIFIER_PER_LEVEL;
    public static int ALIANZ_MAX_LEVEL;
    public static double ALIANZ_XP_FROM_KILL;

    public static String PERMISSION_OPEN_GUILD_GUI;
    public static String PERMISSION_OPEN_ALINAZ_GUI;
    public static String PERMISSION_CREATE_BATTLE_INSTANCE;

    public static final String PREFIX;
    public static final boolean PREFIX_BEFORE_CHAT_MESSAGES;

    public static final long SYNC_WITH_DB;

}
