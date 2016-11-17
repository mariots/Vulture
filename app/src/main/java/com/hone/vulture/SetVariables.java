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

    private RadioGroup timeGroup, difficultyGroup;
    private RadioButton abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_variables);

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
        if (view.getId() == R.id.playButton) {
            Intent intent = new Intent(this, GameLobby.class);                 //Intent to Game Lobby
            //String game_type = "quick_game";                                   //Set game_type variable           //Save these in case they are necessary later
            //intent.putExtra(GAME_TYPE, game_type);                             //Set game_type as an extra
            startActivity(intent);                                             //Move to Set Variables

        }
    }
}
