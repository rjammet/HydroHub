package fr.siroz.hydro;

import fr.siroz.hydro.server.pubsub.HydroMessageListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HydroHub extends JavaPlugin {

    private static HydroHub instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "HistoLand", new HydroMessageListener());
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "HistoLand");
    }

    @Override
    public void onDisable() {

    }

    /**
     * Get root plugin of HydroHub
     * @return - Instance HydroHub
     */
    public static HydroHub getInstance() {
        return instance;
    }
}
