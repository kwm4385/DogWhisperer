
package com.escapeNT.dogWhisperer;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 *
 * @author escapeNT
 */
public class DogWhispererPlayerListener extends PlayerListener {
    
    @Override
    public void onPlayerLogin(PlayerLoginEvent event) {
        if(!Util.getPlayerWolves().containsKey(event.getPlayer())) {
            Util.getPlayerWolves().put(event.getPlayer(), 0);
        }
    }
}