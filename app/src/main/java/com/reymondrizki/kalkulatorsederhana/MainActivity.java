package com.reymondrizki.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1;
    Button button;
    TextView textView;
    RadioGroup radio_operators;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setupListener();

    }

    private void setupView() {
        editText = findViewById(R.id.nilai1);
        editText1 = findViewById(R.id.nilai2);
        button = findViewById(R.id.buttonhitung);
        textView = findViewById(R.id.hasil);
        radio_operators = findViewById(R.id.radio_operator);
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void setupListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    int value1 = Integer.parseInt(editText.getText().toString());
                    int value2 = Integer.parseInt(editText1.getText().toString());
                    textView.setText(value(value1, value2)
                    );
                } else {
                    showMessage("Masukkan data dengan benar");
                }
            }
        });
        radio_operators.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(group.getCheckedRadioButtonId());
                operator = radioButton.getText().toString();
                textView.setText("Hasil");
            }
        });
    }
    private Boolean validate() {

        if (editText.getText().toString().equals("") || editText.getText() == null) {
            return false;
        } else if (editText1.getText().toString().equals("") || editText1.getText() == null) {
            return false;
        }else if(operator == null){
            return false;
        }
        return true;
    }

    private String value(int value1, int value2) {
        int value = 0;

        switch (operator) {
            case "+":
                value = value1 + value2;
            break;

            case "-":
                value = value1 - value2;
                break;

            case "x":
                value = value1 * value2;
                break;

            case "/":
                value = value1 / value2;
                break;
        }
        return String.valueOf(value);
    }

}
