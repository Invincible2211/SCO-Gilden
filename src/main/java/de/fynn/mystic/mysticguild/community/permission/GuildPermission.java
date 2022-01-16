package de.fynn.mystic.mysticguild.community.permission;

public enum GuildPermission implements Permission{

    GUILD(0),MEMBERS(1);

    private int position;

    GuildPermission(int pos){
        position = pos;
    }

    @Override
    public int getPosition() {
        return position;
    }

    public enum MANAGE_GUILD implements Permission{
        ROLE(2),MONEY(3),WAR(4),ATTRIBUTE(5),INVENTORY(6);;

        private int position;

        MANAGE_GUILD(int pos){
            position = pos;
        }

        @Override
        public int getPosition() {
            return position;
        }
    }

    public enum MANAGE_MEMBERS implements Permission{
        KICK(7),INVITE(8),ROLE(9),ACCEPT(10),BAN(11);

        MANAGE_MEMBERS(int pos){
            position = pos;
        }

        private int position;

        @Override
        public int getPosition() {
            return position;
        }
    }

}
