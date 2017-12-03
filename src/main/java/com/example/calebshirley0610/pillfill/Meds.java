package com.example.calebshirley0610.pillfill;

/**
 * Created by TJ on 11/27/2017.
 */

public class Meds {
    private int id;
    private String time;
    private String med;
    private String day;

    public Meds(int _id, String time, String med, String day) {
        this.id = id;
        this.time = time;
        this.med = med;
        this.day = day;
    }
    public Meds(String time, String med, String day) {
        this.time = time;
        this.med = med;
        this.day = day;
    }

    public Meds() {

    }
    public void setId(int id){this.id = id;}

    public int getId(){return id;}

    public void setTime(String time){this.time = time;}

    public String getTime(){return time;}

    public String getMed(){return med;}

    public void setMed(String med){this.med = med;}

    public String getDay(){return day;}

    public void setDay(String day){this.day = day;}


}
