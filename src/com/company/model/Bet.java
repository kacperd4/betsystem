package com.company.model;

public class Bet {

    private final long offerId;
    private final Winner winner;
    private final float cost;

    public Bet(long offerId, String winner, float cost) {

        this.offerId = offerId;
        this.winner = Winner.valueOf(winner);
        this.cost = cost;
    }

    public long getOfferId() {
        return offerId;
    }

    public Winner getWinner() {
        return winner;
    }

    public float getCost() {
        return cost;
    }
}
