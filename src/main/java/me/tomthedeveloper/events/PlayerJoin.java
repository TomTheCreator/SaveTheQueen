package me.tomthedeveloper.events;

import me.tomthedeveloper.SaveTheQueen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Tom on 27/01/2016.
 */
public class PlayerJoin implements Listener {

    private SaveTheQueen plugin;

    public PlayerJoin(SaveTheQueen plugin){
        this.plugin = plugin;
    }



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

    }
}
