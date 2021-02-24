package ru.netology.repository;

import ru.netology.domain.OfferTicket;


public class OfferTicketRepository {
    private OfferTicket[] items = new OfferTicket[0];

    public void save(OfferTicket item) {
        int length = items.length + 1;
        OfferTicket[] tmp = new OfferTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public OfferTicket[] findAll() {
        return items;
    }
}