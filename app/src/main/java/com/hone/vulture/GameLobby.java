package com.hone.vulture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameLobby extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);

        findViewById(R.id.AddFriendButton).setOnClickListener(this);
        findViewById(R.id.ReadyButton).setOnClickListener(this);
        findViewById(R.id.QuitButton).setOnClickListener(this);
    }

    public void onClick(View view) {

        if (view.getId() == R.id.AddFriendButton) {

        }
        if (view.getId() == R.id.ReadyButton) {
            Intent intent = new Intent(this, InGameActivity.class);          //Intent to In Game Screen
            startActivity(intent);                                           //Move to In Game Screen
        }
        if (view.getId() == R.id.QuitButton) {
                    /*Intent intent = new Intent(GameLobby.this, MainMenuActivity.class);//Intent to Go back to Main Menu
                    startActivity(intent);*/
        }
    }
}