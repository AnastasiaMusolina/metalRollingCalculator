package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String[] listOfMetal={"Выберите металл","Углеродистая сталь", "Медь","Титан","Латунь","Свинец","Золото"};
    TextView textView;
    Button btnNextAct2;
    HashMap<String,Double> densityOfMethrial=new HashMap<>();
    {
        densityOfMethrial.put(listOfMetal[1],7850.0);
        densityOfMethrial.put(listOfMetal[2],8960.0);
        densityOfMethrial.put(listOfMetal[3],4540.0);
        densityOfMethrial.put(listOfMetal[4],8600.0);
        densityOfMethrial.put(listOfMetal[5],11340.0);
        densityOfMethrial.put(listOfMetal[6],19300.0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        btnNextAct2= findViewById(R.id.button);
        btnNextAct2.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);


        btnNextAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         Intent intent=new Intent(MainActivity.this, Step2Activity.class);
         startActivity(intent);
            }
        });

        ArrayAdapter<String> adapterForSpinner=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listOfMetal);
        adapterForSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterForSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    Optional.matherial=parent.getItemAtPosition(position).toString();
                    Optional.density=densityOfMethrial.get(Optional.matherial);
                    btnNextAct2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
