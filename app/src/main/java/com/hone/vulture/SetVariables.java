package com.hone.vulture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class SetVariables extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup timeGroup, difficultyGroup, itemNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_variables);

        timeGroup = (RadioGroup) findViewById(R.id.time);
        difficultyGroup = (RadioGroup) findViewById(R.id.itemListDifficultyGroup);
        itemNumber = (RadioGroup) findViewById(R.id.itemNumber);

        //Set Listener for Play Button
        findViewById(R.id.playButton).setOnClickListener(this);

        /*timeGroup = (RadioGroup) findViewById(R.id.time);

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

        });*/


    }

    public void onClick(View view) {

        if(view.getId() == R.id.itemNumber) {
            int choice = radioChoice(itemNumber);
            System.out.print("Choice: " + choice);
        }

        if (view.getId() == R.id.playButton) {
            Intent intent = new Intent(this, GameLobbyActivity.class);           //Intent to Game Lobby
            //String game_type = "quick_game";                                   //Set game_type variable           //Save these in case they are necessary later
            //intent.putExtra(GAME_TYPE, game_type);                             //Set game_type as an extra
            startActivity(intent);                                               //Move to Set Variables
        }
    }

    public int radioChoice(RadioGroup selection) {

        int radioButtonID = selection.getCheckedRadioButtonId();
        View radioButton = selection.findViewById(radioButtonID);
        int idx = selection.indexOfChild(radioButton);

        System.out.print("ID: " + idx);
        System.out.print("Selection: " + selection);

        if(selection == timeGroup) {

            if(idx == 0) {          //User chose 5 minutes
                return 5;
            } else if(idx == 1) {   //User chose 10 minutes
                return 10;
            } else if(idx == 2) {   //User chose 20 minutes
                return 20;
            } else {                //User chose Unlimited
                return 0;
            }

        } else if(selection == itemNumber) {

            if(idx == 1) { //User chose 4 items
                return 4;
            } else if(idx == 1) {  //User chose 8 items
                return 8;
            } else { //User chose 12 items
                return 12;
            }
        } else {

            if(idx == 0) {
                return 0;
            } else if(idx == 1) {
                return 1;
            } else {
                return 2;
            }
        }


        

    }
}
