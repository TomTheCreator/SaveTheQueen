package me.tomthedeveloper.chat;

import me.tomthedeveloper.game.GameInstance;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tom on 27/01/2016.
 */
public class MessageHandler {

    private GameInstance gameInstance;


    public MessageHandler(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }


    public void sendAnnouncement(String[] message, HashSet<Player> players) {
        for (Player player : players) {
            TextComponent textComponent = new TextComponent("--------------------------------------------");
            textComponent.setBold(true);
            textComponent.setColor(net.md_5.bungee.api.ChatColor.GREEN);

            player.spigot().sendMessage(textComponent);
            player.sendMessage("");
            for (String s : message) {
                for (String msg : formatInMiddle(s, 60)) {
                    player.sendMessage(msg);
                }
            }
            player.sendMessage("");
            player.spigot().sendMessage(textComponent);
        }
    }

    public void sendAnnouncement(String[] message) {
        sendAnnouncement(message, gameInstance.getPlayers());
    }


    public List<String> formatInMiddle(String string, int maxlength) {
        List<String> centered = new LinkedList<String>();
        if (string.length() >= maxlength) {
            List<String> strings = splitString(string, maxlength);

            for (String s : strings) {
                int length = s.length();
                int spaces = (int) Math.floor((maxlength - length) / 2);
                StringBuilder sb = new StringBuilder();
                for (int i = spaces; i > 0; i--) {
                    sb.append(" ");

                }
                centered.add(sb.append(s).toString());
            }
        } else {
            int length = string.length();
            if (length < maxlength) {
                int spaces = (int) Math.floor((maxlength - length) / 2);
                StringBuilder sb = new StringBuilder();
                for (int i = spaces; i > 0; i--) {
                    sb.append(" ");
                }
                centered.add(sb.append(string).toString());
            }
        }
        return centered;
    }


    public static List<String> splitString(String string, int max) {
        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile(".{1," + max + "}(?:\\s|$)", Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(string);
        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }
        return matchList;
    }
}
