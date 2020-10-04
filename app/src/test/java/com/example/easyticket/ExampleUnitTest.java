package com.example.easyticket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private ticket ticket;

    @Before
    public void setUp(){
        ticket=new ticket();

    }

    @Test
    public void totalticket_isCorrect() {

        int total=ticket.calculateTotalTicket(5,2);
        assertEquals(7, 5+2);
    }

    @Test
    public void totalCost_isCorrect() {

        int cost=ticket.calculateTotalcost(2,1);
        assertEquals(1250, 2*500+1*250);
    }




}