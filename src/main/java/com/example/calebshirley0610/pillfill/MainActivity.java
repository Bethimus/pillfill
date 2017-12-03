package com.example.calebshirley0610.pillfill;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.name;

public class MainActivity extends Activity {
    ArrayList<Meds> meds = new ArrayList<>();
    TestList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
       // ListView     list = findViewById(R.id.medList);
        DBHandler db = new DBHandler(this);
        //make 3 alarm objects with spaced out id numbers, add them to database; call make arraylist, push toast listing the ids
        Alarm  a1 = new Alarm(1,"morning","3", "30","advil", true,true,true,true,true,true,true);
        Alarm  a2 = new Alarm(4,"noon","3", "30","advil", true,true,true,true,true,true,true);
        Alarm  a3 = new Alarm(18,"night","3", "30","advil", true,true,true,true,true,true,true);
        db.createAlarm(a1);
        db.createAlarm(a2);
        db.createAlarm(a3);
        ArrayList<Alarm> alist = db.createAlarmArray();
        Toast.makeText(this, String.valueOf(alist.get(0).getKey() + " " +alist.get(1).getKey() + " " + alist.get(2).getKey()),Toast.LENGTH_SHORT);
        // Alarm(int k, String n, String timeH, String timeM, String m, boolean mo, boolean tu, boolean we, boolean th, boolean fr, boolean sa, boolean su)
        /*
        create alarm objects from database
        Meds first = new Meds("1130","stuff1", "today1");
        Meds second = new Meds("1230","stuff2", "today2");
        Meds third = new Meds("130","stuff3", "today3");*/


        /*add alarms to arraylist
        ArrayList<Meds> medlist = new ArrayList<>();
        meds.add(first);
        meds.add(second);
        meds.add(third);*/

        //  make new adapter with arraylist of alarms
        //  adapter = new TestList(this, R.layout.list, meds);
        //list.setAdapter(adapter);


    }
public void newMed(View view){
    DBHandler db = new DBHandler(this);
    TestList test = new TestList(this, R.layout.list, meds);

   // db.addContact(med);
}

}
