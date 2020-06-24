package com.company;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private final String user;
    private final List<Bet> bets;

    public Ticket(String user ) {
        this.user = user;
        bets = new ArrayList<>();
    }

    public String getUser() {
        return user;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void addBet(Bet newBet) {
        bets.add(newBet);
    }
}
