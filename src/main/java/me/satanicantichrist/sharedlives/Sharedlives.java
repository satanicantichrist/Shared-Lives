package me.satanicantichrist.sharedlives;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.satanicantichrist.sharedlives.events.PlayerEvents;

public final class Sharedlives extends JavaPlugin {

  public static Plugin plugin;

  @Override
  public void onEnable() {
    saveResource("config.yml", false);
    plugin = this;
    this.getServer().getPluginManager().registerEvents(new PlayerEvents(), this);

    getLogger().info("Options: ");
    getLogger().info("Share heal: " + getConfig().getBoolean("share-heal"));
  }
}
