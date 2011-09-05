
package com.escapeNT.dogWhisperer;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

/**
 *
 * @author escapeNT
 */
public class DogWhispererPlayerListener extends PlayerListener {
    
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        Util.getPlugin().countPlayerWolves(event.getPlayer());
    }
}