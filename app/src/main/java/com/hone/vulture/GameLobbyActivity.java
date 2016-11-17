package com.hone.vulture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameLobbyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);
        findViewById(R.id.AddFriendButton).setOnClickListener(this);
        findViewById(R.id.ReadyButton).setOnClickListener(this);
        findViewById(R.id.QuitButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ReadyButton) {
            Intent intent = new Intent(this, InGameActivity.class);//Intent to Start a Game
            startActivity(intent);
        }
        if (view.getId() == R.id.QuitButton) {
            Intent intent = new Intent(this, MainMenuActivity.class);//Intent to Start a Game
            startActivity(intent);
        }
        if (view.getId() == R.id.AddFriendButton) {
            //nothing yet
        }
    }
}