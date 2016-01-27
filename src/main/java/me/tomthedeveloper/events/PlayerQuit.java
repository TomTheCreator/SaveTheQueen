package me.tomthedeveloper.events;

import me.tomthedeveloper.SaveTheQueen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Tom on 27/01/2016.
 */
public class PlayerQuit implements Listener {


    private SaveTheQueen plugin;

    public PlayerQuit(SaveTheQueen plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onLeave(PlayerQuitEvent event){

    }
}
