package com.worldmightpay.wordsofnumbers;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

/**
 * Created by gdibella on 07/10/15.
 */
public class TestCalendar {


    @Test
    public void addHour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);
        System.out.println(cal.toString());
    }

    @Test
    public void swapVars() throws Exception {
        String a = "a";
        String b = "b";
        String tmp = "";

        tmp = a;
        a = b;
        b = tmp;

        assertTrue(a.equals("b"));
        assertTrue(b.equals("a"));


    }



}
