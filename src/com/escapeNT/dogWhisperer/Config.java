
package com.escapeNT.dogWhisperer;

import org.bukkit.util.config.Configuration;

/**
 *
 * @author escapeNT
 */
public class Config {
    
    private static Configuration c = Util.getPlugin().getConfiguration();
    
    private static int maxWolves;
    private static String tameFailMessage;
    
    public static void load() {
        maxWolves = c.getInt("Max wolves per player", 1);
        tameFailMessage = c.getString("Too many wolves message", "Your pack is too large for another member.");
        c.save();
    }

    /**
     * @return the maxWolves
     */
    public static int getMaxWolves() {
        return maxWolves;
    }

    /**
     * @return the tameFailMessage
     */
    public static String getTameFailMessage() {
        return tameFailMessage;
    }
}