package com.hone.vulture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class InGameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        findViewById(R.id.camera_button).setOnClickListener(this);

        Intent previousIntent = getIntent();                                                        //get intent
        ArrayList<String> myItemList = previousIntent.getStringArrayListExtra("ITEM_LIST");         //get item list from game lobby activity
        Integer VerifiedItem = previousIntent.getIntExtra("VerifiedItem", 0);                       //check verified flag from camera activity

        ArrayAdapter<String> itemAdapter = new                                                      //adapter for item list
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myItemList);

        ListView myList = (ListView)                                                                //Set ListView contents for item list
                findViewById(R.id.ItemList);
                myList.setAdapter(itemAdapter);

        List<String> myPlayerList = new ArrayList<String>();                                        //Create player list

        ArrayAdapter<String> playerAdapter = new                                                    //adapter for player list
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myPlayerList);

        ListView playerList = (ListView)                                                            //Set ListView contents for player list
                findViewById(R.id.PlayerList);
                playerList.setAdapter(playerAdapter);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.camera_button) {
            Intent intent = new Intent(this, CameraActivity.class);                                 //Intent to Camera Screen
            startActivity(intent);
        }

        if (view.getId() == R.id.exit_button) {
            Intent intent = new Intent(this, MainMenuActivity.class);                               //Intent to Camera Screen
            startActivity(intent);
        }
    }
}
