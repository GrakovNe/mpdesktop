package org.grakovne.mpdesktop.mpd;

import org.bff.javampd.server.MPD;
import org.grakovne.mpdesktop.entity.Server;
import org.grakovne.mpdesktop.exceptions.ConnectionErrorException;
import org.grakovne.mpdesktop.interfaces.Connection;
import org.grakovne.mpdesktop.interfaces.Player;
import org.grakovne.mpdesktop.interfaces.TrackManager;

import java.net.UnknownHostException;

public class MpdConnection implements Connection {
    private MPD mpd;

    @Override
    public void connect(Server server) {
        try {
            mpd = new MPD.Builder()
                    .server(server.getHost())
                    .port(server.getPort())
                    .password(server.getPassword())
                    .build();
        } catch (UnknownHostException e) {
            throw new ConnectionErrorException();
        }
    }

    @Override
    public void disconnect() {
        mpd.close();
    }

    @Override
    public Player getPlayer() {
        return new MpdPlayer(mpd);
    }

    @Override
    public TrackManager getTrackManager() {
        return null;
    }

    @Override
    public boolean isConnected() {
        return mpd.isConnected();
    }
}
