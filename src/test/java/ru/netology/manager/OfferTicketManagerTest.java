package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.OfferTicket;
import ru.netology.repository.OfferTicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferTicketManagerTest {
    private OfferTicketRepository repository = new OfferTicketRepository();
    private OfferTicket ot1 = new OfferTicket(1, 5000, 100, "EGO", "DME");
    private OfferTicket ot2 = new OfferTicket(1, 2000, 300, "DME", "EGO");
    private OfferTicket ot3 = new OfferTicket(1, 1000, 250, "EGO", "DME");
    private OfferTicket ot4 = new OfferTicket(1, 2500, 400, "LED", "DME");
    private OfferTicket ot5 = new OfferTicket(1, 3000, 600, "GOJ", "RVH");


    //поиск всех совпадений сортировка по цене
    @Test
    void searchBySortAllOferrTocket() {
        repository.save(ot1);
        repository.save(ot2);
        repository.save(ot3);
        repository.save(ot4);
        repository.save(ot5);

        OfferTicketManager managers = new OfferTicketManager(repository);
        OfferTicket[] actual = managers.searchBy("EGO", "DME");
        OfferTicket[] expected = new OfferTicket[]{ot3, ot1};
        assertArrayEquals(actual, expected);

    }

    /// билет отсутствует
    @Test
    void searchBySortNoOferrTocket() {
        repository.save(ot1);
        repository.save(ot2);
        repository.save(ot3);
        repository.save(ot4);
        repository.save(ot5);

        OfferTicketManager managers = new OfferTicketManager(repository);
        OfferTicket[] actual = managers.searchBy("EGO", "RVN");
        OfferTicket[] expected = new OfferTicket[]{};
        assertArrayEquals(actual, expected);
    }

    // поиск одного билета
    @Test
    void searchBySortOneOferrTocket() {
        repository.save(ot1);

        OfferTicketManager managers = new OfferTicketManager(repository);
        OfferTicket[] actual = managers.searchBy("EGO", "DME");
        OfferTicket[] expected = new OfferTicket[]{ot1};
        assertArrayEquals(actual, expected);
    }
}