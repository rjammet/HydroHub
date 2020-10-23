package fr.siroz.hydro.server.pubsub;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class HydroMessageListener implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if(channel.equals("HistoLand")){
            final ByteArrayDataInput input = ByteStreams.newDataInput(bytes);
            final String subChannel = input.readUTF();

            if(subChannel.equals("GetAccount")){

                // TODO
                final int id = input.readInt();

                player.sendMessage("");
            }
        }
    }
}
