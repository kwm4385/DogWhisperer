/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.escapeNT.dogWhisperer;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.entity.Player;

/**
 *
 * @author escapeNT
 */
public class Util {
    
    private static final Logger log = Logger.getLogger("Minecraft");
    private static DogWhisperer plugin;
    private static HashMap<Player, Integer> playerWolves = new HashMap<Player, Integer>();
    
    /**
     * Logs an info message from the plugin to the console.
     * @param message The message to send.
     */
    public static void log(String message) {
        StringBuilder s = new StringBuilder();
        s.append("[");
        s.append(DogWhisperer.PLUGIN_NAME);
        s.append("] ");
        s.append(message);
        log.log(Level.INFO, s.toString());
    }

    /**
     * Logs a message from the plugin to the console with the specified level..
     * @param level The log level.
     * @param message The message to send.
     */
    public static void log(Level level, String message) {
        StringBuilder s = new StringBuilder();
        s.append("[");
        s.append(DogWhisperer.PLUGIN_NAME);
        s.append("] ");
        s.append(message);
        log.log(level, s.toString());
    }

    /**
     * @return the plugin
     */
    public static DogWhisperer getPlugin() {
        return plugin;
    }

    /**
     * @param aPlugin the plugin to set
     */
    public static void setPlugin(DogWhisperer aPlugin) {
        plugin = aPlugin;
    }

    /**
     * @return the playerWolves
     */
    public static HashMap<Player, Integer> getPlayerWolves() {
        return playerWolves;
    }
}
