package com.example.week04_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RadioGroup radioGroup1;
    RadioButton cheese;
    RadioButton xcheese;
    RadioButton none;
    RadioGroup radioGroup2;

    RadioButton square;
    RadioButton round;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;

    TextView textView;

    Button button;

    Button button1;

    ArrayList<RadioButton> radioButtons;

    ArrayList<CheckBox> checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        radioButtons = new ArrayList<>();
        checkBoxes = new ArrayList<>();

        radioGroup1 = findViewById(R.id.radio1);
        cheese = findViewById(R.id.radioButton);
        xcheese = findViewById(R.id.radioButton2);
        none = findViewById(R.id.radioButton3);
        radioButtons.add(cheese);
        radioButtons.add(xcheese);
        radioButtons.add(none);


        radioGroup2 = findViewById(R.id.radio2);
        square = findViewById(R.id.radioButton4);
        round = findViewById(R.id.radioButton5);
        radioButtons.add(square);
        radioButtons.add(round);

        checkBox1 = findViewById(R.id.check1);
        checkBox2 = findViewById(R.id.check2);
        checkBox3 = findViewById(R.id.check3);
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);

        textView = findViewById(R.id.textView6);

        button = findViewById(R.id.button2);

        button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            String cheesetext = "Your choice is : ";
            String shape = "";
            @Override
            public void onClick(View view) {
                for (int i = 0; i < radioButtons.size(); i++) {
                    if (radioButtons.get(i).isChecked()) {
                        cheesetext = cheesetext + " " + radioButtons.get(i).getText().toString();
                    }
                }

                for (int j = 0; j < checkBoxes.size(); j++) {
                    if (checkBoxes.get(j).isChecked()) {
                        shape = shape + " " +  checkBoxes.get(j).getText().toString();
                    }
                }

                textView.setText(cheesetext + "Shape is" + shape);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}