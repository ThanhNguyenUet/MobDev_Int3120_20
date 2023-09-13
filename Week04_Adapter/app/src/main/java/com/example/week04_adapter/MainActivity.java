package com.example.week04_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.week04_adapter.Adapter.CustomAdapter;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    Spinner spinner;

    GridView gridView;
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter arrayAdapter;
    String countryList[] = {"India", "China", "Australia", "Portugal", "America", "Newzeland"};

    String userName[] = {"Jack", "Jack", "Jack", "Jack", "Jack", "Jack"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        gridView = findViewById(R.id.gridview);
        autoCompleteTextView = findViewById(R.id.autocomplete);

        // Non customed adapter - will only render a text for textview
//        arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_item,R.id.textView2, countryList);
//        listView.setAdapter(arrayAdapter);

        // Custom adapter this // getapplicationcontext
//        CustomAdapter customAdapter = new CustomAdapter(this, countryList, userName);
//        listView.setAdapter(customAdapter);

        // Spinner non customed adapter
//        arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_item, R.id.textView2, countryList);
//        spinner.setAdapter(arrayAdapter);

        // Custom adapter for spinner
//        CustomAdapter customAdapter = new CustomAdapter(this, countryList, userName);
//        spinner.setAdapter(customAdapter);

        // GridView non customed adapter
//        arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_item, R.id.textView2, countryList);
//        gridView.setAdapter(arrayAdapter);

        // GridView customed adapter
        CustomAdapter customAdapter = new CustomAdapter(this, countryList, userName);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i = vi tri cua grid view & l = ten id cua moi dong cell grid view
                CharSequence text = "You click position :" + i + ", value :" + countryList[i] ;
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(getApplicationContext(), text, duration).show();
            }
        });

        // autocomplete no customed adapter
        arrayAdapter = new ArrayAdapter(this, R.layout.listview_item, R.id.textView2, countryList);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}