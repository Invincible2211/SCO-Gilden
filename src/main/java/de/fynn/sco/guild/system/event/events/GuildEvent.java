package de.fynn.sco.guild.system.event.events;

import de.fynn.sco.guild.community.guild.Guild;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GuildEvent {

    public static class JOIN extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild;
        private final Player player;

        public JOIN(Player player, Guild guild){
            this.guild = guild;
            this.player = player;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Player getPlayer() {
            return player;
        }

        public Guild getGuild() {
            return guild;
        }
    }

    public static class LEAVE extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild;
        private final Player player;

        public LEAVE(Player player, Guild guild){
            this.guild = guild;
            this.player = player;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Player getPlayer() {
            return player;
        }

        public Guild getGuild() {
            return guild;
        }
    }

    public static class KICK extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild;
        private final Player player;

        public KICK(Player player, Guild guild){
            this.guild = guild;
            this.player = player;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }

        public Player getPlayer() {
            return player;
        }

        public Guild getGuild() {
            return guild;
        }
    }

    public static class CREATE extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild;

        public CREATE(Guild guild) {
            this.guild = guild;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }
    }

    public static class CLOSE extends Event{
        private final HandlerList handlerList = new HandlerList();
        private final Guild guild;

        public CLOSE(Guild guild) {
            this.guild = guild;
        }

        @Override
        public HandlerList getHandlers() {
            return handlerList;
        }
    }

}
