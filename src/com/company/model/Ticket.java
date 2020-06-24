package com.company.model;

import java.util.List;

public class Ticket {

    private final String user;
    private final List<Bet> bets;

    public Ticket(final String user, final List<Bet> bets) {
        this.user = user;
        this.bets = bets;
    }

    public String getUser() {
        return user;
    }

    public List<Bet> getBets() {
        return bets;
    }
}
