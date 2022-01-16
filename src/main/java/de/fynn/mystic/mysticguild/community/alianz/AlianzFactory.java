package de.fynn.mystic.mysticguild.community.alianz;

import java.util.UUID;

public class AlianzFactory {

    protected static Alianz createAlianz(UUID owner, String name){
        return new Alianz(UUID.randomUUID(),owner,name);
    }

}
