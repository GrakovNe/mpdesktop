package org.grakovne.mpdesktop.interfaces;

import org.grakovne.mpdesktop.entity.Track;

public interface Player {
    void play();
    void pause();
    void stop();

    int getVolume();
    void setVolume(int volume);

    void mute();
    void unMute();
}
