package ru.netelogy.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
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


    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void findAndSortTickets() {

        Ticket[] expected = {ticket2, ticket1, ticket5, ticket8, ticket7, ticket10};
        Ticket[] actual = manager.findAll("KUF", "SIP");
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void NotFindTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("AAA", "SIP");
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void FindOneTickets() {

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.findAll("LED", "EGO");
        Assertions.assertArrayEquals(actual, expected);
    }

}
