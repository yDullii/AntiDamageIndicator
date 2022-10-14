package de.yDulli.methods;

import net.labymod.serverapi.bukkit.utils.PacketUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Task extends BukkitRunnable {
  private Player player;
  
  private PacketUtils packetUtils;
  
  final byte[] pluginMessage = new byte[1];
  
  public Task(Player p, PacketUtils packetUtils) {
    this.player = p;
    this.packetUtils = packetUtils;
  }
  
  public void run() {
    this.packetUtils.sendPacket(this.player, this.packetUtils.getPluginMessagePacket("DAMAGEINDICATOR", this.pluginMessage));
  }
}
