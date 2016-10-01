package org.grakovne.mpdesktop.interfaces;

import org.grakovne.mpdesktop.entity.Server;
import org.grakovne.mpdesktop.entity.Track;

public interface Connection {
    void connect(Server server);
    void disconnect();

    Player getPlayer();
    TrackManager getTrackManager();

    boolean isConnected();

}
