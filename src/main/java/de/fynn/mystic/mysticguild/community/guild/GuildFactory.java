package de.fynn.mystic.mysticguild.community.guild;

import java.util.UUID;

public class GuildFactory {

    protected static Guild createGuild(UUID owner, String name){
        return new Guild(UUID.randomUUID(),owner,name);
    }

}
