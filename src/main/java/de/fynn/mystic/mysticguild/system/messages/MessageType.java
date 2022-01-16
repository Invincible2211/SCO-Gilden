package de.fynn.mystic.mysticguild.system.messages;

/**
 * @author Freddyblitz
 */

public enum MessageType implements MSG{
    PLACEHOLDER;

    @Override
    public String getPath() {
        return "";
    }

    public enum COMMAND implements MSG{
        COMMAND_NOT_FOUND("COMMAND.COMMAND_NOT_FOUND"),
        ONLY_FOR_PLAYERS("COMMAND.ONLY_FOR_PLAYERS"),
        PLAYER_NOT_FOUND("COMMAND.PLAYER_NOT_FOUND"),
        NO_PERMISSION("COMMAND.NO_PERMISSION"),
        NO_GUILD("COMMAND.NO_GUILD"),
        LANGUAGE_DOES_NOT_EXIST("COMMAND.LANGUAGE_DOES_NOT_EXISTS");

        private final String path;

        COMMAND(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }
    }

    public enum INFO implements MSG{
        GUILD_CREATE("INFO.GUILD_CREATE"),
        GUILD_JOIN("INFO.GUILD_JOIN"),
        GUILD_KICK("INFO.GUILD_KICK"),
        GUILD_LEAVE("INFO.GUILD_LEAVE"),
        GUILD_INVITE("INFO.GUILD_INVITE"),
        GUILD_INVITE_ACCEPT("INFO.GUILD_INVITE_ACCEPT"),
        GUILD_INVITE_NO_INVITE("INFO.GUILD_INVITE_NO_INVITE"),
        ROLE_CREATE("INFO.ROLE_CREATE"),
        ROLE_DELETE("INFO.ROLE_DELETE"),
        ROLE_RENAME("INFO.ROLE_RENAME"),
        GUILD_RENAME("INFO.GUILD_RENAME");

        private final String path;

        INFO(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }
    }

    public enum ERROR implements MSG{
        DOUBLE_GUILD("ERROR.DOUBLE_GUILD"),
        GUILD_FOUNDING("ERROR.GUILD_FOUNDING"),
        PLAYER_INVALID("ERROR.PLAYER_INVALID"),
        GUILD_NAME_TO_SHORT("ERROR.GUILD_NAME_TO_SHORT"),
        INVALID_CHAR("ERROR.INVALID_CHAR");

        private final String path;

        ERROR(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }
    }

    public enum QUESTION implements MSG{
        GUILD_NAME("QUESTION.GUILD_NAME"),
        RENAME_GUILD_NAME("QUESTION.RENAME_GUILD_NAME"),
        ROLE_NAME("QUESTION.ROLE_NAME"),
        RENAME_ROLE_NAME("QUESTION.RENAME_ROLE_NAME"),
        RENAME_PREFIX("QUESTION.RENAME_PREFIX");

        private final String path;

        QUESTION(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }
    }

    public enum INVENTORY implements MSG{
        ACCEPT_DECLINE("INVENTORY.ACCEPT_DECLINE"),
        CREATE_ALIANZ_ROLE("INVENTORY.CREATE_ALIANZ_ROLE"),
        CREATE_GUILD_ROLE("INVENTORY.CREATE_GUILD_ROLE"),
        DIPLOMATIE("INVENTORY.DIPLOMATIE"),
        GUILD_INFO("INVENTORY.GUILD_INFO"),
        GUILD_INVENTORY("INVENTORY.GUILD_INVENTORY"),
        INVITE_PLAYER("INVENTORY.INVITE_PLAYER"),
        LIST_ALIANZ_MEMBERS("INVENTORY.LIST_ALIANZ_MEMBERS"),
        LIST_ALL_ALIANZ("INVENTORY.LIST_ALL_ALIANZ"),
        LIST_GUILD("INVENTORY.LIST_GUILD"),
        MANAGE_ALIANZ_MEMBER("INVENTORY.MANAGE_ALIANZ_MEMBER"),
        MANAGE_ALIANZ_ROLE("INVENTORY.MANAGE_ALIANZ_ROLE"),
        MANAGE_ATTRIBUTES("INVENTORY.MANAGE_ATTRIBUTES"),
        MANAGE_GUILD_ROLES("INVENTORY.MANAGE_GUILD_ROLES"),
        MANAGE_JOIN_REQUESTS("INVENTORY.MANAGE_JOIN_REQUESTS"),
        MANGE_MEMBER("INVENTORY.MANGE_MEMBER"),
        MANAGE_ROLE("INVENTORY.MANAGE_ROLE"),
        MEMBER_LIST("INVENTORY.MEMBER_LIST"),
        MY_ALIANZ("INVENTORY.MY_ALIANZ"),
        MY_GUILD("INVENTORY.MY_GUILD"),
        MY_INVITES("INVENTORY.MY_INVITES"),
        MY_JOIN_REQUESTS("INVENTORY.MY_JOIN_REQUESTS"),
        NO_ALIANZ("INVENTORY.NO_ALIANZ"),
        NO_GUILD("INVENTORY.NO_GUILD"),
        SEARCH_GUILD("INVENTORY.SEARCH_GUILD"),
        SELECT_ROLE("INVENTORY.SELECT_ROLE"),
        SET_STATUS("INVENTORY.SET_STATUS"),
        WAR_MODE("INVENTORY.WAR_MODE");

        private final String path;

        INVENTORY(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }
    }

    public enum ITEM implements MSG{
        GUILD_CREATE("ITEM.GUILD_CREATE"),
        GUILD_RENAME("ITEM.GUILD_RENAME"),
        GUILD_LEAVE("ITEM.GUILD_LEAVE"),
        GUILD_CLOSE("ITEM.GUILD_CLOSE"),
        GUILD_KICK("ITEM.GUILD_KICK"),
        GUILD_INVITE("ITEM.GUILD_INVITE"),
        GUILD_INVITE_PLAYER("ITEM.GUILD_INVITE_PLAYER"),
        GUILD_INVITE_SEND("ITEM.GUILD_INVITE_SEND"),
        GUILD_LIST_MEMBERS("ITEM.GUILD_LIST_MEMBERS"),
        GUILD_MANAGE("ITEM.GUILD_MANAGE"),
        GUILD_MANAGE_ATTRIBUTES("ITEM.GUILD_MANAGE_ATTRIBUTES"),
        GUILD_ROLE_MANAGE("ITEM.GUILD_ROLE_MANAGE"),
        GUILD_ROLE_INCREASE_PRIORITY("ITEM.GUILD_ROLE_INCREASE_PRIORITY"),
        GUILD_ROLE_DECREASE_PRIORITY("ITEM.GUILD_ROLE_DECREASE_PRIORITY"),
        GUILD_ROLE_CREATE("ITEM.GUILD_ROLE_CREATE"),
        GUILD_ROLE_SAVE("ITEM.GUILD_ROLE_SAVE"),
        GUILD_ROLE_DELETE("ITEM.GUILD_ROLE_DELETE"),
        GUILD_ROLE_RENAME("ITEM.GUILD_ROLE_RENAME"),
        GUILD_ROLES_MANAGE("ITEM.GUILD_ROLES_MANAGE"),

        GUI_PREVIOUS("ITEM.GUI_PREVIOUS"),
        GUI_NEXT("ITEM.GUI_NEXT"),
        GUI_BACK("ITEM.GUI_BACK"),
        GUI_CLOSE("ITEM.GUI_CLOSE"),
        GUI_ACCEPT("ITEM.GUI_ACCEPT"),
        GUI_DECLINE("ITEM.GUI_DECLINE"),

        MY_JOIN_REQUESTS("ITEM.MY_JOIN_REQUESTS"),
        SEARCH_GUILD("ITEM.SEARCH_GUILD"),
        MY_INVITES("ITEM.MY_INVITES"),

        ALIANZ_CREATE("ITEM.ALIANZ_CREATE"),
        ALIANZ_RENAME("ITEM.ALIANZ_RENAME"),
        ALIANZ_LEAVE("ITEM.ALIANZ_LEAVE"),
        ALIANZ_CLOSE("ITEM.ALIANZ_CLOSE"),
        ALIANZ_KICK("ITEM.ALIANZ_KICK"),
        ALIANZ_INVITE("ITEM.ALIANZ_INVITE"),
        ALIANZ_INVITE_GUILD("ITEM.ALIANZ_INVITE_GUILD"),
        ALIANZ_INVITE_SEND("ITEM.ALIANZ_INVITE_SEND"),
        ALIANZ_LIST_MEMBERS("ITEM.ALIANZ_LIST_MEMBERS"),
        ALIANZ_MANAGE("ITEM.ALIANZ_MANAGE"),
        ALIANZ_MANAGE_ATTRIBUTES("ITEM.ALIANZ_MANAGE_ATTRIBUTES"),
        ALIANZ_ROLE_MANAGE("ITEM.ALIANZ_ROLE_MANAGE"),
        ALIANZ_ROLE_INCREASE_PRIORITY("ITEM.ALIANZ_ROLE_INCREASE_PRIORITY"),
        ALIANZ_ROLE_DECREASE_PRIORITY("ITEM.ALIANZ_ROLE_DECREASE_PRIORITY"),
        ALIANZ_ROLE_CREATE("ITEM.ALIANZ_ROLE_CREATE"),
        ALIANZ_ROLE_SAVE("ITEM.ALIANZ_ROLE_SAVE"),
        ALIANZ_ROLE_DELETE("ITEM.ALIANZ_ROLE_DELETE"),
        ALIANZ_ROLE_RENAME("ITEM.ALIANZ_ROLE_RENAME"),
        ALIANZ_ROLES_MANAGE("ITEM.ALIANZ_ROLES_MANAGE");

        private final String path;

        ITEM(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }
    }

    public enum PERMISSION implements MSG{
        MANAGE_GUILD_MEMBER("PERMISSION.MANAGE_GUILD_MEMBER"),
        MANAGE_GUILD("PERMISSION.MANAGE_GUILD"),
        MANAGE_ALINAZ_MEMBER("PERMISSION.MANAGE_ALINAZ_MEMBER"),
        MANAGE_ALIANZ("PERMISSION.MANAGE_ALIANZ");

        private final String path;

        PERMISSION(String path){
            this.path = path;
        }

        @Override
        public String getPath() {
            return path;
        }

        public enum GUILD_MEMBER implements MSG{
            KICK("PERMISSION.GUILD_MEMBER.KICK"),
            INVITE("PERMISSION.GUILD_MEMBER.INVITE"),
            ROLE("PERMISSION.GUILD_MEMBER.ROLE"),
            ACCEPT("PERMISSION.GUILD_MEMBER.ACCEPT"),
            BAN("PERMISSION.GUILD_MEMBER.BAN");

            private final String path;

            GUILD_MEMBER(String path){
                this.path = path;
            }

            @Override
            public String getPath() {
                return path;
            }
        }
        public enum GUILD implements MSG{
            ROLE("PERMISSION.GUILD.ROLE"),
            MONEY("PERMISSION.GUILD.MONEY"),
            WAR("PERMISSION.GUILD.WAR"),
            INVENTORY("PERMISSION.GUILD.INVENTORY"),
            ATTRIBUTES("PERMISSION.GUILD.ATTRIBUTES");

            private final String path;

            GUILD(String path){
                this.path = path;
            }

            @Override
            public String getPath() {
                return path;
            }
        }
        public enum ALIANZ implements MSG{
            ROLE("PERMISSION.ALIANZ.ROLE"),
            WAR("PERMISSION.ALIANZ.WAR"),
            INVENTORY("PERMISSION.ALIANZ.INVENTORY"),
            ATTRIBUTES("PERMISSION.ALIANZ.ATTRIBUTES");

            private final String path;

            ALIANZ(String path){
                this.path = path;
            }

            @Override
            public String getPath() {
                return path;
            }
        }
        public enum ALIANZ_MEMBER implements MSG{
            KICK("PERMISSION.ALIANZ_MEMBER.KICK"),
            INVITE("PERMISSION.ALIANZ_MEMBER.INVITE"),
            ROLE("PERMISSION.ALIANZ_MEMBER.ROLE"),
            ACCEPT("PERMISSION.ALIANZ_MEMBER.ACCEPT"),
            BAN("PERMISSION.ALIANZ_MEMBER.BAN");

            private final String path;

            ALIANZ_MEMBER(String path){
                this.path = path;
            }

            @Override
            public String getPath() {
                return path;
            }
        }
    }

}
