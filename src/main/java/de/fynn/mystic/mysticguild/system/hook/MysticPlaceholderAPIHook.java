package de.fynn.mystic.mysticguild.system.hook;

import de.fynn.mystic.mysticguild.community.guild.GuildManager;
import de.fynn.mystic.mysticguild.community.role.Role;
import de.fynn.mystic.mysticplaceholderapi.placeholder.Placeholder;
import de.fynn.mystic.mysticplaceholderapi.placeholder.PlaceholderManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MysticPlaceholderAPIHook {

    private final PlaceholderManager placeholderManager;

    private final GuildManager guildManager = GuildManager.getInstance();

    private static MysticPlaceholderAPIHook instance;

    public MysticPlaceholderAPIHook(Plugin parent){
        instance = this;
        placeholderManager = new PlaceholderManager(parent);
        registerPlaceholders();
    }

    private void registerPlaceholders(){
        placeholderManager.registerPlaceholder("%guild_name%", new Placeholder() {
            @Override
            public <T> String getPlaceholder(T... values) {
                return guildManager.getPlayerGuildAsString(((Player) values[0]).getUniqueId());
            }
        });
        placeholderManager.registerPlaceholder("%role_name%", new Placeholder() {
            @Override
            public <T> String getPlaceholder(T... values) {
                return ((Role)values[0]).getName();
            }
        });
    }

    public <T> String getPlaceholder(String msg, T... values){
        return placeholderManager.getPlaceholder(msg,values);
    }

    public <T> String getPlaceholder(String plugin,String msg, T... values){
        return placeholderManager.getPlaceholder(plugin,msg,values);
    }

    public static MysticPlaceholderAPIHook getInstance() {
        return instance;
    }
}
