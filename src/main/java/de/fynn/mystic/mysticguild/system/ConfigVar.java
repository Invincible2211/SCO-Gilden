package de.fynn.mystic.mysticguild.system;

/**
 * @author Freddyblitz
 */

public enum ConfigVar {

    ;

    public static enum DATABASE {
        SCHEMA,
        IP,
        PORT,
        USER,
        PASSWORD
    }

    public static enum GUILD {
        FOUNDING_PRIZE,
        MAX_SIZE_ON_FOUND,
        GUILD_SIZE_PER_LEVEL,
        XP_PER_LEVEL,
        LEVEL_MODIFIER_PER_LEVEL,
        MAX_LEVEL,
        XP_FROM_KILLS,
        INVENTORY_DEFAULT_SIZE,
        INVENTORY_SLOT_PRIZE
    }

    public static enum PERMISSION {
        OPEN_GUILD_GUI
    }

    public static enum PREFIX {
        PLUGIN,PREFIX_BEFORE_CHAT_MESSAGE
    }

}
