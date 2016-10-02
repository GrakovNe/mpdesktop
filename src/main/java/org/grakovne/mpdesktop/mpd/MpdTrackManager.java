package org.grakovne.mpdesktop.mpd;

import org.bff.javampd.server.MPD;
import org.bff.javampd.song.MPDSong;
import org.grakovne.mpdesktop.entity.Track;
import org.grakovne.mpdesktop.interfaces.TrackManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MpdTrackManager implements TrackManager {
    private MPD mpd;

    public MpdTrackManager(MPD mpd) {
        this.mpd = mpd;
    }

    @Override
    public void nextTrack() {
        mpd.getPlayer().playNext();
    }

    @Override
    public void prevTrack() {
        mpd.getPlayer().playPrevious();
    }

    @Override
    public Track getTrack() {
        return convertMpdSongToTrack(mpd.getPlaylist().getCurrentSong());
    }

    @Override
    public void setTrack(Track track) {
        mpd.getPlayer().playSong(convertTrackToMpdSong(track));

    }

    @Override
    public List<Track> getPlayList() {
        List<Track> tracks = new ArrayList<>();
        List<MPDSong> songs = mpd.getPlaylist().getSongList();

        for (MPDSong song: songs){
            tracks.add(convertMpdSongToTrack(song));
        }

        return tracks;
    }

    @Override
    public void setPlayList(List<Track> tracks) {
        List<MPDSong> songs = new ArrayList<>(tracks.size());
        songs.addAll(tracks.stream().map(this::convertTrackToMpdSong).collect(Collectors.toList()));

        mpd.getPlayer().stop();
        mpd.getPlaylist().clearPlaylist();
        mpd.getPlaylist().addSongs(songs);
        mpd.getPlayer().play();
    }

    private Track convertMpdSongToTrack(MPDSong mpdSong){
        Track track = new Track();
        track.setAlbum(mpdSong.getAlbumName());
        track.setAuthor(mpdSong.getArtistName());
        track.setFileName(mpdSong.getFile());
        track.setTitle(mpdSong.getTitle());

        return track;
    }

    private MPDSong convertTrackToMpdSong(Track track){
        return new MPDSong(track.getFileName(), track.getTitle());
    }
}
