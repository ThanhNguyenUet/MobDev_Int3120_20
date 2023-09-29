package com.example.week8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PeopleDataSource {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {SQLiteHelper.COLUMN_ID,
            SQLiteHelper.COLUMN_PERSON};

    public PeopleDataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Person createPerson(String pName) {
        // contentvalues -> nhu la mot hang trong database
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_PERSON, pName);
        long insertId = database.insert(SQLiteHelper.TABLE_PEOPLE, null,
                values);

        // thay vi tra ve mot ban copy tu database -> tra ve con tro den vi tri hang trong database
        Cursor cursor = database.query(SQLiteHelper.TABLE_PEOPLE,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Person newPerson = cursorToPerson(cursor);
        cursor.close();
        return newPerson;
    }
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<Person>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_PEOPLE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Person person = cursorToPerson(cursor);
            people.add(person);
            cursor.moveToNext();
        }
        // Nhớ đóng con trỏ lại nhé.
        cursor.close();
        return people;
    }

    private Person cursorToPerson(Cursor cursor) {
        Person person = new Person();
        person.setId(cursor.getLong(0));
        person.setName(cursor.getString(1));
        return person;
    }
}
