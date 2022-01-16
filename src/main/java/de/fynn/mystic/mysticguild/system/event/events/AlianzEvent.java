package de.fynn.mystic.mysticguild.system.event.events;

import de.fynn.mystic.mysticguild.community.alianz.Alianz;
import de.fynn.mystic.mysticguild.community.guild.Guild;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AlianzEvent {

    public static class CREATE extends Event {
        private final HandlerList handlerList = new HandlerList();
        private final Alianz alianz;

        public CREATE(Alianz alianz){
            this.alianz = alianz;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Alianz getAlianz() {
            return alianz;
        }
    }

    public static class CLOSE extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Alianz alianz;

        public CLOSE(Alianz alianz){
            this.alianz = alianz;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Alianz getAlianz(){
            return alianz;
        }
    }

}
