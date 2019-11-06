package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.calculator.Calculator.Armature;
import com.example.calculator.Calculator.Corner;
import com.example.calculator.Calculator.Hexahedron;
import com.example.calculator.Calculator.MetalList;
import com.example.calculator.Calculator.Pipe;
import com.example.calculator.Calculator.ProfilePipe;
import com.example.calculator.Calculator.RoundPipe;


public class Step3Activity extends AppCompatActivity {

    Spinner spinner;
    String[] listOfPipe = {"Выберите сортамент", "Арматура", "Труба круглая", "Труба профильная", "Уголок", "Лист", "Шестигранник"};
    EditText editTextForDiametr;
    EditText editTextForTol;
    EditText editTextForHeight;
    TextView textView;
    TextView textViewTol;
    TextView textViewForHeight;
    TextView textViewRes;
    Button res;
    int type = 0;
    double parametr1;
    double parametr2;
    double parametr3;
    Pipe pipe = null;
    TextView resField;
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        spinner = findViewById(R.id.spinner3);
        editTextForDiametr = findViewById(R.id.editTextForDiametr);
        editTextForTol = findViewById(R.id.editTextForTol);
        editTextForHeight = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView2);
        res = findViewById(R.id.button2);
        resField = findViewById(R.id.resField);
        textViewTol = findViewById(R.id.textView3);
        textViewForHeight = findViewById(R.id.textView4);
        textViewRes=findViewById(R.id.textViewRes);

        resField.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textViewTol.setVisibility(View.INVISIBLE);
        textViewForHeight.setVisibility(View.INVISIBLE);
        textViewRes.setVisibility(View.INVISIBLE);
        editTextForDiametr.setVisibility(View.INVISIBLE);
        editTextForTol.setVisibility(View.INVISIBLE);
        editTextForHeight.setVisibility(View.INVISIBLE);
        res.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterForSpinner3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOfPipe);
        adapterForSpinner3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterForSpinner3);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Log.v("tag","pos "+position);
                if (position == 1) {
                    textView.setVisibility(View.VISIBLE);
                    editTextForDiametr.setVisibility(View.VISIBLE);
                    editTextForDiametr.setText(null);
                    textViewTol.setVisibility(View.INVISIBLE);
                    textViewForHeight.setVisibility(View.INVISIBLE);
                    editTextForTol.setVisibility(View.INVISIBLE);
                    editTextForHeight.setVisibility(View.INVISIBLE);
                    textViewRes.setVisibility(View.INVISIBLE);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;

                    textView.setText("Введите диаметр, мм ");
                    type = 1;
                }

                if (position == 2) {
                    textView.setVisibility(View.VISIBLE);
                    textViewTol.setVisibility(View.VISIBLE);
                    editTextForDiametr.setVisibility(View.VISIBLE);
                    editTextForDiametr.setText(null);
                    editTextForTol.setVisibility(View.VISIBLE);
                    textViewRes.setVisibility(View.INVISIBLE);
                    editTextForTol.setText(null);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;

                    textView.setText("Введите диаметр, мм ");
                    textViewTol.setText("Введите толщину стенки, мм: ");
                    type = 2;
                }

                if (position == 3) {
                    textView.setVisibility(View.VISIBLE);
                    textViewTol.setVisibility(View.VISIBLE);
                    textViewForHeight.setVisibility(View.VISIBLE);
                    editTextForHeight.setText(null);
                    editTextForDiametr.setVisibility(View.VISIBLE);
                    editTextForDiametr.setText(null);
                    editTextForTol.setVisibility(View.VISIBLE);
                    editTextForTol.setText(null);
                    editTextForHeight.setVisibility(View.VISIBLE);
                    textViewRes.setVisibility(View.INVISIBLE);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;

                    textView.setText("Введите ширину, мм ");
                    textViewTol.setText("Введите толщину стенки, мм: ");
                    textViewForHeight.setText("Введите высоту трубы, мм: ");
                    type = 3;
                }

                if (position == 4) {
                    textView.setVisibility(View.VISIBLE);
                    textViewTol.setVisibility(View.VISIBLE);
                    textViewForHeight.setVisibility(View.VISIBLE);
                    editTextForDiametr.setVisibility(View.VISIBLE);
                    editTextForDiametr.setText(null);
                    editTextForTol.setVisibility(View.VISIBLE);
                    editTextForTol.setText(null);
                    editTextForHeight.setVisibility(View.VISIBLE);
                    editTextForHeight.setText(null);
                    textViewRes.setVisibility(View.INVISIBLE);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;

                    textView.setText("Введите ширину уголка, мм: ");
                    textViewTol.setText("Введите толщину стенки, мм: ");
                    textViewForHeight.setText("Введите высоту уголка, мм: ");
                    type = 4;
                }

                if (position == 5) {
                    textView.setVisibility(View.VISIBLE);
                    textViewTol.setVisibility(View.VISIBLE);
                    textViewForHeight.setVisibility(View.VISIBLE);
                    editTextForDiametr.setVisibility(View.VISIBLE);
                    editTextForDiametr.setText(null);
                    editTextForTol.setVisibility(View.VISIBLE);
                    editTextForTol.setText(null);
                    textViewForHeight.setText(null);
                    editTextForHeight.setVisibility(View.VISIBLE);
                    textViewRes.setVisibility(View.INVISIBLE);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;

                    textView.setText("Введите ширину листа, мм:  ");
                    textViewTol.setText("Введите толщину листа, мм: ");
                    textViewForHeight.setText("Количество листов: ");
                    type = 5;
                }

                if (position == 6) {
                    textView.setVisibility(View.VISIBLE);
                    textViewTol.setVisibility(View.INVISIBLE);
                    textViewForHeight.setVisibility(View.INVISIBLE);
                    editTextForDiametr.setVisibility(View.VISIBLE);
                    editTextForDiametr.setText(null);
                    editTextForTol.setVisibility(View.INVISIBLE);
                    editTextForHeight.setVisibility(View.INVISIBLE);
                    textViewRes.setVisibility(View.INVISIBLE);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;

                    textView.setText("Введите номер шестигранника, мм:  ");
                    type = 6;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        editTextForDiametr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!editTextForDiametr.getText().toString().isEmpty()) {
                    editTextForDiametr.setBackgroundColor(Color.TRANSPARENT);
                    parametr1 = 0;
                    parametr1 = Double.parseDouble(editTextForDiametr.getText().toString());
                    flag1 = true;
                    if ((type == 1) || (type == 6) || ((type == 2) && flag2) ||
                            ((type == 3 || type == 4 || type == 5) && (flag3 && flag2 && flag1))) {
                        res.setEnabled(true);
                    }

                } else {
                    editTextForDiametr.setBackgroundColor(Color.RED);
                    res.setEnabled(false);
                }

                res.setVisibility(View.VISIBLE);

            }
        });
        editTextForTol.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (type == 2 || type == 5 || type == 3 || type == 4) {
                    if (!editTextForTol.getText().toString().isEmpty()) {
                        editTextForTol.setBackgroundColor(Color.TRANSPARENT);
                        parametr2 = 0;
                        parametr2 = Double.parseDouble(editTextForTol.getText().toString());
                        flag2 = true;
                        if ((type == 2 && flag1) || ((type == 3 || type == 4 || type == 5) && (flag3 && flag2 && flag1))) {
                            res.setEnabled(true);
                        }
                    } else {
                        editTextForTol.setBackgroundColor(Color.RED);
                        flag2 = false;
                        res.setEnabled(false);
                    }
                    res.setVisibility(View.VISIBLE);
                }
            }
        });
        editTextForHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (type == 3 || type == 4 || type == 5) {
                    if (!editTextForHeight.getText().toString().isEmpty()) {
                        editTextForHeight.setBackgroundColor(Color.TRANSPARENT);
                        parametr3 = 0;
                        parametr3 = Double.parseDouble(editTextForHeight.getText().toString());
                        flag3 = true;
                    } else {
                        editTextForHeight.setBackgroundColor(Color.RED);
                        flag3 = false;
                        res.setEnabled(false);
                    }
                    if (flag1 && flag2 && flag3) {
                        res.setEnabled(true);
                    }
                    res.setVisibility(View.VISIBLE);
                }
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type == 1) {
                    pipe = new Armature(Optional.density, Optional.length, Optional.weight, parametr1);
                }

                if (type == 2) {
                    pipe = new RoundPipe(Optional.density, Optional.length, Optional.weight, parametr1, parametr2);
                }
                if (type == 3) {
                    pipe = new ProfilePipe(Optional.density, Optional.length, Optional.weight, parametr3, parametr2, parametr1);
                }
                else if (type == 4) {
                    pipe = new Corner(Optional.density, Optional.length, Optional.weight, parametr3, parametr2, parametr1);
                }
                else if (type == 5) {
                    pipe = new MetalList(Optional.density, Optional.length, Optional.weight, parametr1, parametr2, (int) parametr3);
                }
               else  if (type == 6) {
                    pipe = new Hexahedron(Optional.density, Optional.length, Optional.weight, parametr1);
                }
                resField.setVisibility(View.VISIBLE);
                if (Optional.flag) {
                    textViewRes.setVisibility(View.VISIBLE);
                    textViewRes.setText("Вес: ");
                    resField.setText(String.valueOf(pipe.calculationWeight()));
                } else if (!Optional.flag) {
                    textViewRes.setVisibility(View.VISIBLE);
                    textViewRes.setText("Длина: ");
                    resField.setText(String.valueOf(pipe.calculationLength()));
                }
            }
        });
    }
}
