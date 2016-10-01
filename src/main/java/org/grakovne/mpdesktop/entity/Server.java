package org.grakovne.mpdesktop.entity;

public class Server {
    private String host;
    private int port;
    private String username;
    private String password;

    public Server(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Server(String host, int port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
    }

    public Server() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
