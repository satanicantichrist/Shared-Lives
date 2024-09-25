package me.satanicantichrist.sharedlives.events;

import me.satanicantichrist.sharedlives.Sharedlives;
import org.bukkit.NamespacedKey;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

import java.util.EventListener;

public class PlayerDamageEvents implements Listener {

    @EventHandler
    private void onHeal(EntityRegainHealthEvent event){
        if(!Sharedlives.plugin.getConfig().getBoolean("share-heal")) return;
        if(event.getRegainReason().equals(EntityRegainHealthEvent.RegainReason.CUSTOM)) return;
        if(event.getEntity().getType() != EntityType.PLAYER) return;
        for(Player player : Sharedlives.plugin.getServer().getOnlinePlayers()) {
            if(player.getUniqueId() == event.getEntity().getUniqueId()) continue;
            player.heal(event.getAmount(), EntityRegainHealthEvent.RegainReason.CUSTOM);
        }
    }

    @EventHandler
    private void onDamage(EntityDamageEvent event) {
        if(event.getDamageSource().getDamageType().getKey().getKey().equals("generic")) return;
        if(event.getEntity().getType() != EntityType.PLAYER) return;
        for(Player player : Sharedlives.plugin.getServer().getOnlinePlayers()) {
            if(player.getUniqueId() == event.getEntity().getUniqueId()) continue;
            player.damage(event.getFinalDamage());
    }}
}
