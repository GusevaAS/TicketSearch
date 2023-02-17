package ru.netelogy.ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1789, "KUF", "SIP", 125);
    Ticket ticket2 = new Ticket(2, 1556, "KUF", "SIP", 120);
    Ticket ticket3 = new Ticket(85, 20002, "LED", "EGO", 70);
    Ticket ticket4 = new Ticket(1987, 580, "CEK", "DKS", 350);
    Ticket ticket5 = new Ticket(66, 2808, "KUF", "SIP", 45);
    Ticket ticket6 = new Ticket(125, 1000100, "GBI", "TJM", 756);
    Ticket ticket7 = new Ticket(54, 9458, "KUF", "SIP", 72);
    Ticket ticket8 = new Ticket(54, 9457, "KUF", "SIP", 72);
    Ticket ticket9 = new Ticket(2587, 54684, "DKS", "SIP", 74);
    Ticket ticket10 = new Ticket(10, 42594, "KUF", "SIP", 100);

    @Test
    public void mustShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mustAdd() {
        manager.add(ticket2);
        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mustAddFewTicket() {
        manager.add(ticket4);
        manager.add(ticket10);
        Ticket[] expected = new Ticket[]{ticket4, ticket10};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

}