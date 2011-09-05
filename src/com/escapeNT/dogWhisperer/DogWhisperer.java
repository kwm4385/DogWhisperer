
package com.escapeNT.dogWhisperer;

import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author escapeNT
 */
public class DogWhisperer extends JavaPlugin {
    
    public static final String PLUGIN_NAME = "DogWhisperer";
    public static final String PLUGIN_VERSION = "1.1";

    public static final String TAME_PERMISSION = "dog.tame";
    public static final String NOLIMIT_PERMISSION = "dog.nolimit";

    @Override
    public void onEnable() {
        Util.setPlugin(this);
        Config.load();
        
        for(Player p : getServer().getOnlinePlayers()) {
            countPlayerWolves(p);
        }
        
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvent(Type.ENTITY_TAME, new DogWhispererEntityListener(), Priority.Monitor, this);
        pm.registerEvent(Type.ENTITY_DEATH, new DogWhispererEntityListener(), Priority.Normal, this);
        pm.registerEvent(Type.PLAYER_JOIN, new DogWhispererPlayerListener(), Priority.Normal, this);

        pm.addPermission(new Permission(TAME_PERMISSION, PermissionDefault.TRUE));
        pm.addPermission(new Permission(NOLIMIT_PERMISSION, PermissionDefault.OP));
        
        Util.log("version " + PLUGIN_VERSION + " enabled.");
    }

    @Override
    public void onDisable() {
        Util.log("version " + PLUGIN_VERSION + " disabled.");
    }
    
    protected void countPlayerWolves(Player p) {
        Util.getPlayerWolves().put(p, 0);
        for(World w : p.getServer().getWorlds()) {
            for(LivingEntity e : w.getLivingEntities()) {
                if(e instanceof Wolf && ((Wolf)e).isTamed() && p.equals((Player)((Wolf)e).getOwner())) {
                    Util.getPlayerWolves().put(p, Util.getPlayerWolves().get(p) + 1);
                }
            }
        }
    }
}