package org.grakovne.mpdesktop.interfaces;

import org.grakovne.mpdesktop.entity.Track;

import java.util.List;

public interface TrackManager {

    void nextTrack();
    void prevTrack();
    Track getTrack();
    void setTrack(Track track);

    List<Track> getPlayList();
    void setPlayList(List<Track> tracks);


}
