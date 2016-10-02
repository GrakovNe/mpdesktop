package org.grakovne.mpdesktop;

import org.grakovne.mpdesktop.entity.Server;
import org.grakovne.mpdesktop.interfaces.Connection;
import org.grakovne.mpdesktop.interfaces.Player;
import org.grakovne.mpdesktop.mpd.MpdConnection;

public class Main {
    public static void main(String[] args) {
        Server server = new Server("home.grakovne.org", 6600, "media");
        Connection connection = new MpdConnection(server);
        Player player = connection.getPlayer();
    }
}
