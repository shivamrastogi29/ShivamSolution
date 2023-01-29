package org.example;

import java.util.ArrayList;

public class Team {

    String name;

    String location;

    public ArrayList<Players> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<Players> player) {
        this.player = player;
    }

    ArrayList<Players> player;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
