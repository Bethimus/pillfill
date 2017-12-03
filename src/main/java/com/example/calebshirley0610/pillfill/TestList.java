package com.example.calebshirley0610.pillfill;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TJ on 11/29/2017.
 */

public class TestList extends ArrayAdapter<Meds> {
    private Context mContext;
    int mresource;
    String message;
    private OnAddListner onAddListner;
    Button editBtn;
    Button deleteNtn;

    public TestList(Context context, @LayoutRes int resource, @NonNull ArrayList<Meds> objects) {
        super(context, resource, objects);
        mContext = context;
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list, parent, false);
        }

        String medName = getItem(position).getMed();
        String medDay = getItem(position).getDay();
        String medTime = getItem(position).getTime();

        Meds med = new Meds(medTime, medName, medDay);
        LayoutInflater inflate = LayoutInflater.from(mContext);
        convertView = inflate.inflate(mresource,parent, false);

        final TextView name = (TextView) convertView.findViewById(R.id.textView2);
        TextView time = (TextView) convertView.findViewById(R.id.textView);
        TextView day = (TextView) convertView.findViewById(R.id.textView3);
        editBtn = (Button) convertView.findViewById(R.id.button);
        deleteNtn = (Button) convertView.findViewById(R.id.button2);
        name.setText(medName);
        time.setText(medTime);
        day.setText(medDay);
        editBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

            message = name.getText().toString();
            Toast.makeText(mContext, message,Toast.LENGTH_LONG).show();;
            }
        });



        return convertView;


         }
           public interface OnAddListner{
                public void onAdd(int position, String text);
            }



    }

