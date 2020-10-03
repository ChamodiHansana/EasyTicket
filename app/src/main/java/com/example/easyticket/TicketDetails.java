package com.example.easyticket;

public class TicketDetails {

    private String movieName;
    private String date;
    private String time;
    private String theater;
    private Integer full;
    private Integer half;
    private Integer total;
    private Integer cost;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public TicketDetails() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public Integer getFull() {
        return full;
    }

    public void setFull(Integer full) {
        this.full = full;
    }

    public Integer getHalf() {
        return half;
    }

    public void setHalf(Integer half) {
        this.half = half;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
