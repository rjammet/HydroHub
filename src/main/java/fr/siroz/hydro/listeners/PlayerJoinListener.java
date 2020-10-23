package fr.siroz.hydro.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.siroz.hydro.HydroHub;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final HydroHub hydroHub;

    public PlayerJoinListener() {
        this.hydroHub = HydroHub.getInstance();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        final Player player = event.getPlayer();

        final ByteArrayDataOutput output = ByteStreams.newDataOutput();

        output.writeUTF("GetAccount");
        output.writeUTF(player.getUniqueId().toString());

        Bukkit.getScheduler().scheduleSyncDelayedTask(this.hydroHub, () -> player.sendPluginMessage(this.hydroHub, "HistoLand", output.toByteArray()), 5L);
    }
}
