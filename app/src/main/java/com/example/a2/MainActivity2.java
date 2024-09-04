package com.example.a2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
    }
    public void back(View v) {
        switch (v.getId()) {
            case R.id.buttonBack:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
