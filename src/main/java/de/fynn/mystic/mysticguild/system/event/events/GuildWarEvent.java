package de.fynn.mystic.mysticguild.system.event.events;

import de.fynn.mystic.mysticguild.community.guild.Guild;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GuildWarEvent {

    public static class START extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild1;
        private final Guild guild2;

        public START(Guild guild1, Guild guild2){
            this.guild1 = guild1;
            this.guild2 = guild2;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Guild getGuild1() {
            return guild1;
        }

        public Guild getGuild2() {
            return guild2;
        }
    }

    public static class END extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild1;
        private final Guild guild2;
        private final int winner;

        public END(Guild guild1, Guild guild2, int winner){
            this.guild1 = guild1;
            this.guild2 = guild2;
            this.winner = winner;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Guild getGuild1() {
            return guild1;
        }

        public Guild getGuild2() {
            return guild2;
        }

        public int getWinner() {
            return winner;
        }

    }

}
