package com.hone.vulture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameLobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);
        View.OnClickListener lister = new View.OnClickListener() {

            public void onClick(View view) {
                if (view.getId() == R.id.AddFriendButton) {

                }
                if (view.getId() == R.id.ReadyButton) {
                    /*Intent intent = new Intent(GameLobby.this, Game.class);//Intent to Start a Game
                    startActivity(intent);*/
                    ;
                }
                if (view.getId() == R.id.QuitButton) {
                    /*Intent intent = new Intent(GameLobby.this, MainMenuActivity.class);//Intent to Go back to Main Menu
                    startActivity(intent);*/
                }
            }
        };
    }}