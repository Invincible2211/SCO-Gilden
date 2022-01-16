package de.fynn.mystic.mysticguild.community.permission;

public enum AlianzPermission implements Permission{

    ALIANZ(0),MEMBERS(1);

    private int position;

    AlianzPermission(int pos){
        position = pos;
    }

    @Override
    public int getPosition() {
        return position;
    }

    public static enum MANAGE_ALIANZ implements Permission{
        ROLE(2),MONEY(3),WAR(4),ATTRIBUTE(5);

        private int position;

        MANAGE_ALIANZ(int pos){
            position = pos;
        }

        @Override
        public int getPosition() {
            return 0;
        }
    }

    public static enum MANAGE_MEMBERS implements Permission{
        KICK(6),INVITE(7),ROLE(8),ACCEPT(9),BAN(10);

        private int position;

        MANAGE_MEMBERS(int pos){
            position = pos;
        }

        @Override
        public int getPosition() {
            return 0;
        }
    }

}
