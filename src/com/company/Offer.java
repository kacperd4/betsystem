package com.company;

public class Offer {

    private final long id;
    private final String teamA;
    private final String teamB;
    private final float setdown;

    public Offer(long id, String teamA, String teamB, float setdown) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.setdown = setdown;
    }

    public long getId() {
        return id;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public float getSetdown() {
        return setdown;
    }
}
