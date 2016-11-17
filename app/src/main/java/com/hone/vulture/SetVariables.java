package com.hone.vulture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class SetVariables extends AppCompatActivity {

    private RadioGroup timeGroup, difficultyGroup;
    private RadioButton abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_variables);

        timeGroup = (RadioGroup) findViewById(R.id.time);

        timeGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.time5) {
                    Toast.makeText(getApplicationContext(), "choice: Time 5 Minutes",
                            Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.time10) {
                    Toast.makeText(getApplicationContext(), "choice: Time 5 Minutes",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "choice: Vibration",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private void setVariables() {





    }

}
