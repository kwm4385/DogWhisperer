
package com.escapeNT.dogWhisperer;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTameEvent;

/**
 *
 * @author escapeNT
 */
public class DogWhispererEntityListener extends EntityListener {
    
    @Override
    public void onEntityTame(EntityTameEvent event) {
        Player p = (Player)event.getOwner();
        if(!Util.getPlayerWolves().containsKey(p)) {
            Util.getPlayerWolves().put(p, 0);
        }
        if((Util.getPlayerWolves().get(p) + 1) > Config.getMaxWolves()) {
            event.setCancelled(true);
            p.sendMessage(ChatColor.GRAY + Config.getTameFailMessage());
        }
        else {
            Util.getPlayerWolves().put(p, Util.getPlayerWolves().get(p) + 1);
        }  
    }
    
    @Override
    public void onEntityDeath(EntityDeathEvent event) {
        if(event.getEntity() instanceof Wolf && ((Wolf)event.getEntity()).isTamed()) {
            Wolf w = (Wolf)event.getEntity();
            Util.getPlayerWolves().put((Player)w.getOwner(), 
                    Util.getPlayerWolves().get((Player)w.getOwner()) - 1);
        }
    }
}