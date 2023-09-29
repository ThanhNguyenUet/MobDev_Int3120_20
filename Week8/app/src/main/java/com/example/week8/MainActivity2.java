package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

        private PeopleDataSource datasource;

        ListView listView;

        Button button;

        Button toact3;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            listView = findViewById(R.id.list);
            button = findViewById(R.id.buttonadd);
            toact3 = findViewById(R.id.toact3);
            datasource = new PeopleDataSource(this);
            datasource.open();

            List<Person> values = datasource.getAllPeople();

            // use the SimpleCursorAdapter to show the
            // elements in a ListView
            ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this,
                    android.R.layout.simple_list_item_1, values);
            listView.setAdapter(adapter);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    @SuppressWarnings("unchecked")
                    ArrayAdapter<Person> adapter = (ArrayAdapter<Person>) listView.getAdapter();
                    Person person = null;
                    if (view.getId() == R.id.buttonadd) {
                        String[] people = new String[]{"Alice", "Bob", "Mallory"};
                        int nextInt = new Random().nextInt(3);
                        person = datasource.createPerson(people[nextInt]);
                        adapter.add(person);
                    }
                    adapter.notifyDataSetChanged();
                }
            });

            toact3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);
                }
            });
        }
        @Override
        protected void onResume() {
            datasource.open();
            super.onResume();
        }

        @Override
        protected void onPause() {
            datasource.close();
            super.onPause();
        }
}