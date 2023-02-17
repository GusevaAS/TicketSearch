package ru.netelogy.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerWhithComparatorTest {
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
    public void SortTicketByTimeWithComparator() {
        Comparator<Ticket> comparator = new TicketByTimeAscComparator();

        Ticket[] expected = {ticket5, ticket7, ticket8, ticket10, ticket2, ticket1};
        Ticket[] actual = manager.findAllByTime("KUF", "SIP", comparator);
        Assertions.assertArrayEquals(actual, expected);
    }

}

