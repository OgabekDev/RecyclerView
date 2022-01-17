package dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.model;

import java.util.List;

public class PlayerDates {
    private String status;
    private String message;
    private List<Player> data;

    public String getStatus() {
        return status;
    }
    public List<Player> getPlayers() {
        return data;
    }
    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setPlayers(List<Player> players) {
        this.data = players;
    }

    @Override
    public String toString() {
        return "PlayerDates{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", players=" + data +
                '}';
    }
}
