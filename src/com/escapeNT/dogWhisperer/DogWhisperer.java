
package com.escapeNT.dogWhisperer;

import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author escapeNT
 */
public class DogWhisperer extends JavaPlugin {
    
    public static final String PLUGIN_NAME = "DogWhisperer";
    public static final String PLUGIN_VERSION = "1.0";

    @Override
    public void onEnable() {
        Util.setPlugin(this);
        Config.load();
        
        for(Player p : getServer().getOnlinePlayers()) {
            Util.getPlayerWolves().put(p, 0);
        }
        
        for(World w : getServer().getWorlds()) {
            for(LivingEntity e : w.getLivingEntities()) {
                if(e instanceof Wolf && ((Wolf)e).isTamed()) {
                    Player p = (Player)((Wolf)e).getOwner();
                    if(!Util.getPlayerWolves().containsKey(p)) {
                        Util.getPlayerWolves().put(p, 0);
                    }
                    Util.getPlayerWolves().put(p, Util.getPlayerWolves().get(p) + 1);
                }
            }
        }
        
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvent(Type.ENTITY_TAME, new DogWhispererEntityListener(), Priority.Normal, this);
        pm.registerEvent(Type.ENTITY_DEATH, new DogWhispererEntityListener(), Priority.Normal, this);
        
        Util.log("version " + PLUGIN_VERSION + " enabled.");
    }

    @Override
    public void onDisable() {
        Util.log("version " + PLUGIN_VERSION + " disabled.");
    }
}