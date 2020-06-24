package com.company.services;

import com.company.model.Bet;
import com.company.model.Offer;
import com.company.model.Ticket;
import com.company.model.Winner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BetService {

    private List<Offer> offers;
    private List<Ticket> tickets;

    public BetService(final List<Offer> offers) {
        this.offers = offers;
        this.tickets = new ArrayList<>();
    }

    public void bet(String userName, List<Bet> bets) {
        Ticket ticket = new Ticket(userName, bets);
        tickets.add(ticket);
    }

    public Map<String, Double> simulate() {
        Map<Long, Winner> results = new HashMap<>();

        for (int i = 0; i < offers.size(); i++) {
            Offer offer = offers.get(i);
            results.put(offer.getId(), getRandomResult());
        }

        Map<String, Double> value = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            List<Bet> bets = ticket.getBets();

            double result = 0;

            for (int j = 0; j < bets.size(); j++) {
                Bet bet = bets.get(j);

                if (results.get(bet.getOfferId()) == bet.getWinner()) {
                    Offer offer = getOfferById(bet.getOfferId());
                    result += offer.getSetdown() * bet.getCost();
                }
            }

            value.put(ticket.getUser(), result);
        }

        return value;
    }

    private Winner getRandomResult() {
        Random random = new Random();
        double randValue = random.nextDouble();

        if (randValue < 0.4) {
            return Winner.TEAM_A;
        } else if (randValue < 0.8) {
            return Winner.TEAM_B;
        } else {
            return Winner.DRAW;
        }
    }

    private Offer getOfferById(long id) {
        return offers
                .stream()
                .filter(offer -> offer.getId() == id)
                .findAny()
                .get();
    }
}
