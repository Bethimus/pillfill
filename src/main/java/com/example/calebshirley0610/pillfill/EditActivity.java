package com.example.calebshirley0610.pillfill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    private TimePicker pick;
    private EditText ETname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        DBHandler db = new DBHandler(this);
        //make 3 alarm objects with spaced out id numbers, add them to database; call make arraylist, push toast listing the ids
        Alarm  a1 = new Alarm(1,"morning","3", "30","advil", true,true,true,true,true,true,true);
        //Alarm  a2 = new Alarm(4,"noon","3", "30","advil", true,true,true,true,true,true,true);
        //Alarm  a3 = new Alarm(18,"night","3", "30","advil", true,true,true,true,true,true,true);
        db.createAlarm(a1);
        //db.createAlarm(a2);
        //db.createAlarm(a3);
     //   ArrayList<Alarm> alist = db.createAlarmArray();
       // Toast.makeText(this, String.valueOf(alist.get(0).getKey() + " " +alist.get(1).getKey() + " " + alist.get(2).getKey()),Toast.LENGTH_SHORT);

    }
}
