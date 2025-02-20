package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public EditText Height;
    public EditText Weight;
    public EditText Age;
    public TextView Passive;
    public TextView Low;
    public TextView Middle;
    public TextView Large;
    public TextView Max;
    public ImageButton Male;
    public ImageButton Female;
    public TextView defBMR;
    int tf= 10;
    double ageInt,weightInt,heightInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Height = (EditText)findViewById(R.id.editTextNumberHeight);
        Weight = (EditText)findViewById(R.id.editTextNumberWeight);
        Age = (EditText)findViewById(R.id.editTextNumberAge);
        Male = (ImageButton)findViewById(R.id.imageButtonMale);
        Female = (ImageButton)findViewById(R.id.imageButtonFemale);
        defBMR = (TextView)findViewById(R.id.textViewDefBMR);
        Low = (TextView)findViewById(R.id.textViewLow);
        Middle = (TextView)findViewById(R.id.textViewMiddle);
        Large = (TextView)findViewById(R.id.textViewLarge);
        Max = (TextView)findViewById(R.id.textViewMAx);
        Passive = (TextView)findViewById(R.id.textViewPassive);
    }
    public void cls(View v) {
        Height.setText("");
        Weight.setText("");
        Age.setText("");
        Female.setBackgroundColor(Color.WHITE);
        Male.setBackgroundColor(Color.WHITE);
        tf = 10;
    }
    public void math (View v) {
        double solve;
        Toast toast;
        switch (v.getId()) {
            case R.id.buttonMath:
                if(tf==10) {
                    toast = Toast.makeText(this, "Выберите пол", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                else if((Age.length()==0)||(Height.length()==0)||(Weight.length()==0)) {
                    toast = Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    ageInt = Double.parseDouble(Age.getText().toString());
                    weightInt = Double.parseDouble(Height.getText().toString());
                    heightInt = Double.parseDouble(Weight.getText().toString());
                    if (tf == 1) {
                        solve = (66 + (13.7 * weightInt) + (5 * heightInt) - (6.8 * ageInt));
                    }
                    else {
                        solve = (655 + (9.6 * weightInt) + (1.8 * heightInt) - (4.7 * ageInt));
                    }
                    output(v,solve);
                } break;
                default:
                    break;
        }
    }
    public void output(View v,double solve) {
        double count = 100;
        defBMR.setText(Double.toString(Math.round(solve*count)/count));
        Passive.setText(Passive.getText().toString()+Double.toString(Math.round(solve*1.2*count)/count));
        Low.setText(Low.getText().toString()+Double.toString(Math.round(solve*1.375*100)/count));
        Middle.setText(Middle.getText().toString()+Double.toString(Math.round(solve*1.55*count)/count));
        Large.setText(Large.getText().toString()+Double.toString(Math.round(solve*1.725*count)/count));
        Max.setText(Max.getText().toString()+Double.toString(Math.round(solve*1.9*count)/count));
    }
    public void select(View v) {
        switch (v.getId()) {
            case R.id.imageButtonMale:
                Male.setBackgroundColor(Color.GRAY);
                tf = 1;
                Female.setBackgroundColor(Color.WHITE);
                break;
                case R.id.imageButtonFemale:
                    Female.setBackgroundColor(Color.GRAY);
                    tf = 0;
                    Male.setBackgroundColor(Color.WHITE);
                    break;
                    default:
                        break;
        }
    }
    public void info(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
