package ru.netelogy.ticket;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    public Ticket(int id, int price, String airportFrom, String airportTo, int travelTime) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public int getTravelTime() {
        return travelTime;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Ticket ticket = (Ticket) o;
//        return id == ticket.id && price == ticket.price && time == ticket.time && Objects.equals(airportFrom, ticket.airportFrom) && Objects.equals(airportTo, ticket.airportTo);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, price, airportFrom, airportTo, time);
//    }
//
    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.getPrice()) {
            return -1;
        } else if (this.price > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
