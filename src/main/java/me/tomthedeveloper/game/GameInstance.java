package me.tomthedeveloper.game;

import me.TomTheDeveloper.Bungee.Bungee;
import me.TomTheDeveloper.GameAPI;
import me.TomTheDeveloper.Handlers.ChatManager;
import me.TomTheDeveloper.Handlers.ConfigurationManager;
import me.TomTheDeveloper.Handlers.UserManager;
import me.TomTheDeveloper.User;
import me.tomthedeveloper.SaveTheQueen;
import me.tomthedeveloper.chat.MessageHandler;
import org.bukkit.*;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.*;

//import me.confuser.barapi.BarAPI;

/**
 * Created by Tom on 27/07/2014.
 */
public abstract class GameInstance extends BukkitRunnable {


    private GameState gameState;
    private int MIN_PLAYERS = 2;
    private int MAX_PLAYERS = 10;
    private String mapname = "";
    private int timer;
    public static SaveTheQueen plugin;
    private String ID = null;
    private MessageHandler messageHandler;


    private HashSet<UUID> players;


    protected GameInstance(String ID) {
        gameState = GameState.WAITING_FOR_PLAYERS;
        this.messageHandler = new MessageHandler(this);
        this.ID = ID;
        players = new HashSet<UUID>();
    }


    public static SaveTheQueen getPlugin() {
        return plugin;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public int getMIN_PLAYERS() {
        return MIN_PLAYERS;
    }

    public String getMapName() {
        return mapname;
    }

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
    }

    public void removePlayer(Player player) {
        if (player == null)
            return;
        if (player.getUniqueId() == null)
            return;
        if (players.contains(player.getUniqueId()))
            players.remove(player.getUniqueId());
    }

    public void clearPlayers() {
        players.clear();
    }


    public void setMapName(String mapname) {
        this.mapname = mapname;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }


    public abstract boolean needsPlayers();

    public void setMIN_PLAYERS(int MIN_PLAYERS) {
        this.MIN_PLAYERS = MIN_PLAYERS;
    }

    public int getMAX_PLAYERS() {
        return MAX_PLAYERS;
    }

    public void setMAX_PLAYERS(int MAX_PLAYERS) {
        this.MAX_PLAYERS = MAX_PLAYERS;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void updateSign(Sign sign) {

    }


    public void joinAttempt(Player p) {
        //TODO: THIS
    }

    public void showPlayers() {
        for (Player player : getPlayers()) {
            for (Player p : getPlayers()) {
                player.showPlayer(p);
                p.showPlayer(player);
            }
        }
    }

    public HashSet<Player> getPlayers() {
        HashSet<Player> list = new HashSet<Player>();
        for (UUID uuid : players) {
            list.add((Player) Bukkit.getPlayer(uuid));
        }

        return list;
    }

    public List<Player> getPlayersLeft() {
        List<Player> players = new ArrayList<Player>();
        for (User user : UserManager.getUsers(this)) {
            if (!user.isFakeDead())
                players.add(user.toPlayer());
        }
        return players;
    }

    public void leaveAttempt(Player p) {

        //TODO: THIS


    }

    public void hidePlayer(Player p) {
        for (Player player : getPlayers()) {
            player.hidePlayer(p);
        }
    }

    public void showPlayer(Player p) {
        for (Player player : getPlayers()) {
            player.showPlayer(p);
        }
    }


    public void removeAllPlayers() {
        players.clear();
    }



}



