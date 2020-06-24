package com.company;

import com.company.model.Bet;
import com.company.model.Offer;
import com.company.services.BetService;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Offer offer1 = new Offer(1L, "manchester united", "real madryt", 1.50f);
        Offer offer2 = new Offer(2L, "lech poznań", "legia warszawa", 2.54f);
        BetService betService = new BetService(List.of(offer1, offer2));

        String user = "mati";
        Bet bet = new Bet(1L, "TEAM_A", 3f);

        betService.bet(user, List.of(bet));

        Map<String, Double> results = betService.simulate();

        for (var u : results.keySet()) {
            Double result = results.get(user);
            System.out.println(u + " " + result);
        }
    }
}
