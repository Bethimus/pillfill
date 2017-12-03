package com.example.calebshirley0610.pillfill;

/**
 * Created by calebshirley0610 on 12/3/2017.
 */

public class Alarm {
    private String name;
    private String timeHour;
    private String timeMin;
    private String medicine;
    private int key;
    private int[] day;

    public int con(boolean t){
        if(t)return 1;
        else return 0;
    }

    public Alarm(int k, String n, String timeH, String timeM, String m, boolean mo, boolean tu, boolean we, boolean th, boolean fr, boolean sa, boolean su){
        name = n;
        timeHour = timeH;
        timeMin = timeM;
        medicine = m;
        key = k;
        day = new int[]{con(mo), con(tu), con(we), con(th), con(fr), con(sa), con(su)};
    }
    public String getName(){
        return name;
    }
    public String getTimeH(){
        return timeHour;
    }
    public String getTimeM(){
        return timeMin;
    }
    public String getMedicine(){
        return medicine;
    }
    public int getKey(){
        return key;
    }
    public void setName(String n){
        name = n;
    }
    public void setTimeHour(String t){
        timeHour = t;
    }
    public void setTimeMin(String t){
        timeMin = t;
    }
    public void setMedicine(String m){
        medicine = m;
    }
    public void setKey(int i){
        key = i;
    }
    public int getDay(int i){
        return day[i];
    }
    public void setDay(int i, int j){
        j=day[i];
    }


}
