package de.fynn.sco.guild.system.event.events;

import de.fynn.sco.guild.community.alianz.Alianz;
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
