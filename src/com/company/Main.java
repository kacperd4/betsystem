package com.company;

import com.company.model.Bet;
import com.company.model.Offer;
import com.company.model.Winner;
import com.company.services.BetService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Offer offer1 = new Offer(1L, "manchester united", "real madryt", 1.50f);
        Offer offer2 = new Offer(2L, "lech poznań", "legia warszawa", 2.54f);
        BetService betService = new BetService(List.of(offer1, offer2));

        List<Bet> bets = new ArrayList<>();
        String user = JOptionPane.showInputDialog("first name");
        String offerId;
        do {

            offerId = JOptionPane.showInputDialog("offer");
            String winner = JOptionPane.showInputDialog("winner");
            String cost = JOptionPane.showInputDialog("cost");

            Bet bet = new Bet(Long.parseLong(offerId), winner, Float.parseFloat(cost));
            bets.add(bet);
        } while (!offerId.equals("0"));

        betService.bet(user, bets);

        Map<String, Double> results = betService.simulate();

        for (var u : results.keySet()) {
            Double result = results.get(user);
            System.out.println(u + " " + result);
        }
    }
}
