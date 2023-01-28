package p1xel.minecraft.bukkit.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import p1xel.minecraft.bukkit.Storage.Config;

public class AntiSpawn implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSpawn(CreatureSpawnEvent e) {

        Entity entity = e.getEntity();

        if (entity.getType() == EntityType.PHANTOM) {

            if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) {
                if (Config.getBool("spawn-egg.allow")) {
                    return;
                }
            }

            if (Config.getBool("blacklist-worlds.to-whitelist")) {

                String world = e.getLocation().getWorld().getName();

                if (Config.getStringList("blacklist-worlds.worlds").contains(world)) {
                    e.setCancelled(true);
                }

            } else {

                String world = e.getLocation().getWorld().getName();

                if (!Config.getStringList("blacklist-worlds.worlds").contains(world)) {
                    e.setCancelled(true);
                }

            }

        }

    }

}
