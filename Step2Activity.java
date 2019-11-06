package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Step2Activity extends AppCompatActivity {

    Spinner spinner;
    TextView textView;
    EditText textEdit;
    String[] chooseCalculate = {"Выберите, что нужно расчитать ", "Вес", "Длина"};
    Button btnNextAct3;
    int type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        spinner = findViewById(R.id.spinner2);
        textView = findViewById(R.id.twNameOfType);
        textEdit = findViewById(R.id.editText);
        btnNextAct3 = findViewById(R.id.btnNextAct3);

        btnNextAct3.setVisibility(View.INVISIBLE);
        textEdit.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterForSpinner2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chooseCalculate);
        adapterForSpinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterForSpinner2);

        btnNextAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step2Activity.this, Step3Activity.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selected = spinner.getSelectedItem().toString();
                if (position == 1) {
                    textView.setText("Введите длину, м");
                    textView.setVisibility(View.VISIBLE);
                    textEdit.setVisibility(View.VISIBLE);
                    textEdit.setBackgroundColor(Color.TRANSPARENT);
                    textEdit.setText(null);
                    type = 1;
                    Optional.flag = true;
                } else if (position == 2) {
                    textView.setText("Введите вес, кг");
                    textView.setVisibility(View.VISIBLE);
                    textEdit.setVisibility(View.VISIBLE);
                    textEdit.setBackgroundColor(Color.TRANSPARENT);
                    textEdit.setText(null);
                    Optional.flag = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        textEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //значение длины или веса, в зависимости от того, что выбрали + кнопка на след экран

                if (!textEdit.getText().toString().isEmpty()) {
                    textEdit.setBackgroundColor(Color.TRANSPARENT);
                    if (type == 1) {
                        Optional.length = Double.parseDouble(textEdit.getText().toString());
                    } else {
                        Optional.weight = Double.parseDouble(textEdit.getText().toString());
                    }
                    btnNextAct3.setEnabled(true);
                }

                else {
                    textEdit.setBackgroundColor(Color.RED);
                    btnNextAct3.setEnabled(false);
                }
                btnNextAct3.setVisibility(View.VISIBLE);
            }
        });
        onPause();
    }
    @Override
    public void onPause(){
        super.onPause();

    }
}
