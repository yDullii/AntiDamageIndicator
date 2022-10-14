package de.yDulli.main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.yDulli.methods.Task;
import net.labymod.serverapi.bukkit.utils.PacketUtils;

public class Main extends JavaPlugin implements Listener {
  private PacketUtils packetUtils;
  
  @EventHandler
  public void onPlayerLogin(PlayerJoinEvent event) {
    Bukkit.getScheduler().runTaskLater((Plugin)this, (BukkitRunnable)new Task(event.getPlayer(), this.packetUtils), 10L);
  }
  
  public void onEnable() {
    this.packetUtils = new PacketUtils();
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
    getServer().getMessenger().registerOutgoingPluginChannel((Plugin)this, "DAMAGEINDICATOR");
  }
}
