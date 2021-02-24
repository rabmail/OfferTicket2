package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class OfferTicket implements Comparable<OfferTicket> {
    private int id;
    private int price;
    private int time;
    private String from;
    private String to;

    @Override
    public int compareTo(OfferTicket o) {
        return price - o.price;
    }
}
