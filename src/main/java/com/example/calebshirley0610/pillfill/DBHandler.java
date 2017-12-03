package com.example.calebshirley0610.pillfill;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by liz on 11/29/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PillFill";
    private static final String DATABASE_TABLE = "Alarm_Table";

    //Attribute names go here
    private static final String KEY_ALARM_ID = "_id";
    private static final String KEY_ALARM_NAME = "alarmName";
    private static final String KEY_ALARM_HOUR = "alarmHour";
    private static final String KEY_ALARM_MIN = "alarmMin";
    private static final String KEY_MEDICINE_NAME = "medicineName";
    private static final String KEY_IS_MONDAY = "isMon";
    private static final String KEY_IS_TUESDAY = "isTues";
    private static final String KEY_IS_WEDNESDAY = "isWed";
    private static final String KEY_IS_THURSDAY = "isThurs";
    private static final String KEY_IS_FRIDAY = "isFri";
    private static final String KEY_IS_SATURDAY = "isSat";
    private static final String KEY_IS_SUNDAY = "isSun";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        String sqlCreate = "CREATE TABLE " + DATABASE_TABLE + "( " + KEY_ALARM_ID + " INTEGER PRIMARY KEY, " + KEY_ALARM_NAME + " TEXT, " +
                KEY_ALARM_HOUR + " TEXT, " + KEY_ALARM_MIN + " TEXT, " + KEY_MEDICINE_NAME + " TEXT, " + KEY_IS_MONDAY + " INTEGER, " + KEY_IS_TUESDAY + " INTEGER, " +
                KEY_IS_WEDNESDAY + " INTEGER, " + KEY_IS_THURSDAY + " INTEGER, " + KEY_IS_FRIDAY + " INTEGER, " + KEY_IS_SATURDAY + " INTEGER, " +
                KEY_IS_SUNDAY + " INTEGER";
        database.execSQL(sqlCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE); //If this creates proble, take it out...
        onCreate(database);
    }
    public void createAlarm(Alarm alarm) {
        SQLiteDatabase database = this.getWritableDatabase();

        String insertStm = "INSERT INTO " + DATABASE_TABLE + " VALUES(" + alarm.getKey() + ", '" + alarm.getName() + "', '" + alarm.getTimeH() + "', '" + alarm.getTimeM() + "', '" +
                alarm.getMedicine() + "', " + alarm.getDay(0) + ", " + alarm.getDay(1) + ", " + alarm.getDay(2) + ", " + alarm.getDay(3) + ", " +
                alarm.getDay(4) + ", " + alarm.getDay(5) + ", " + alarm.getDay(6) + ")";
            System.out.println(insertStm);

        database.execSQL(insertStm);

        database.close();

    }
    public void updateAlarm(Alarm alarm) {
        SQLiteDatabase database = this.getWritableDatabase();
        String insertStm = "UPDATE " + DATABASE_TABLE + " VALUES(" + alarm.getKey() + ", '" + alarm.getName() + ", '" + alarm.getTimeH() + ", '" + alarm.getTimeM() + ", '" +
                alarm.getMedicine() + ", '" + alarm.getDay(0) + ", '" + alarm.getDay(1) + ", '" + alarm.getDay(2) + ", '" + alarm.getDay(3) + ", '" +
                alarm.getDay(4) + ", '" + alarm.getDay(5) + ", '" + alarm.getDay(6) + "')";
        database.execSQL(insertStm);

        database.close();
    }

    public boolean con(int t){
        if(t == 1)return true;
        else return false;
    }
    public ArrayList<Alarm> createAlarmArray() {
        SQLiteDatabase database = this.getReadableDatabase();

        ArrayList<Alarm> aList = new ArrayList<>();

        String queryStm = "SELECT * FROM " + DATABASE_TABLE;

        Cursor c = database.rawQuery(queryStm, null);

        c.moveToFirst();

        while(c!=null) {
            Alarm alarm = new Alarm(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4),
                    con(c.getInt(5)), con(c.getInt(6)), con(c.getInt(7)),
                    con(c.getInt(8)), con(c.getInt(9)), con(c.getInt(10)),
                    con(c.getInt(11)));
            aList.add(alarm);
            c.moveToNext();
        }

        database.close();
        return aList;
    }
    public Alarm getAlarm(int id) {
        SQLiteDatabase database = this.getReadableDatabase();

        String queryStm = "SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_ALARM_ID + " = " + id;

        Cursor c = database.rawQuery(queryStm, null);

        if(c != null) {
            c.moveToFirst();
        }
        Alarm alarm = new Alarm(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4),
                con(c.getInt(5)), con(c.getInt(6)), con(c.getInt(7)),
                con(c.getInt(8)), con(c.getInt(9)), con(c.getInt(10)),
                con(c.getInt(11)));

        database.close();
        return alarm;
    }



    public void deleteAlarm(Alarm alarm) {
        SQLiteDatabase database = this.getWritableDatabase();

        String deleteStm = "DELETE FROM " + DATABASE_TABLE + " WHERE " + KEY_ALARM_ID + " = " + alarm.getKey();

        database.execSQL(deleteStm);

        database.close();
    }
}
