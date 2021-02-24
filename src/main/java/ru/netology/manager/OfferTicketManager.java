package ru.netology.manager;

import ru.netology.domain.OfferTicket;
import ru.netology.repository.OfferTicketRepository;

import java.util.Arrays;

public class OfferTicketManager {
    private OfferTicketRepository repository;

    public OfferTicketManager(OfferTicketRepository repository) {
        this.repository = repository;
    }

    public OfferTicket[] searchBy(String from, String to) {
        OfferTicket[] result = new OfferTicket[0];
        for (OfferTicket offerTicket : repository.findAll()) {
            if (matches(offerTicket, from, to)) {
                OfferTicket[] tmp = new OfferTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offerTicket;
                result = tmp;
            }

        }

        Arrays.sort(result);
        return result;

    }

    public boolean matches(OfferTicket offerTicket, String from, String to) {
        if (offerTicket.getFrom().equalsIgnoreCase(from)
                & offerTicket.getTo().equalsIgnoreCase(to)) {
            return true;
        }
        return false;
    }
}

