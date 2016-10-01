package org.grakovne.mpdesktop.entity;

import java.util.Arrays;

public class Track {
    private String title;
    private String album;
    private String author;
    private String fileName;
    private byte[] image;

    public Track() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (title != null ? !title.equals(track.title) : track.title != null) return false;
        if (album != null ? !album.equals(track.album) : track.album != null) return false;
        if (author != null ? !author.equals(track.author) : track.author != null) return false;
        if (fileName != null ? !fileName.equals(track.fileName) : track.fileName != null) return false;
        return Arrays.equals(image, track.image);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (album != null ? album.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", author='" + author + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
