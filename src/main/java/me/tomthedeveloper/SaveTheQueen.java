package me.tomthedeveloper;

import me.tomthedeveloper.events.PlayerJoin;
import me.tomthedeveloper.events.PlayerQuit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Tom on 27/01/2016.
 */
public class SaveTheQueen extends JavaPlugin {




    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoin(this),this);
        pluginManager.registerEvents(new PlayerQuit(this), this);
    }
}
