package org.grakovne.mpdesktop.mpd;

import org.bff.javampd.server.MPD;
import org.grakovne.mpdesktop.exceptions.ConnectionErrorException;
import org.grakovne.mpdesktop.interfaces.Connection;
import org.grakovne.mpdesktop.interfaces.Player;

public class MpdPlayer implements Player {

    private MPD mpd;

    public MpdPlayer(MPD mpd) {
        this.mpd = mpd;
    }

    @Override
    public void play() {
        checkConnection();
        mpd.getPlayer().play();
    }

    @Override
    public void pause() {
        checkConnection();
        mpd.getPlayer().pause();
    }

    @Override
    public void stop() {
        checkConnection();
        mpd.getPlayer().stop();
    }

    @Override
    public int getVolume() {
        checkConnection();
        return mpd.getPlayer().getVolume();
    }

    @Override
    public void setVolume(int volume) {
        checkConnection();
        mpd.getPlayer().setVolume(volume);
    }

    @Override
    public void mute() {
        mpd.getPlayer().mute();
    }

    @Override
    public void unMute() {
        mpd.getPlayer().unMute();
    }

    private void checkConnection(){
        if (null == mpd || !mpd.isConnected()){
            throw new ConnectionErrorException();
        }
    }
}
