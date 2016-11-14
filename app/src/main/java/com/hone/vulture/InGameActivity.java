package com.hone.vulture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InGameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        findViewById(R.id.camera_button).setOnClickListener(this);

        String ItemOne = "One";         //Placeholders
        String ItemTwo = "Two";         //In real case use getExtra to retrieve the items for the list
        String ItemThree = "Three";
        String ItemFour = "Four";
        String ItemFive = "Five";
        String ItemSix = "Six";
        String ItemSeven = "Seven";
        String ItemEight = "Eight";

        String PlayerOne = "Andrew";         //Placeholders
        String PlayerTwo = "Alex";         //In real case use getExtra to retrieve the items for the list
        String PlayerThree = "Dian";
        String PlayerFour = "Halen";
        String PlayerFive = "Mario";
        String PlayerSix = "Bob";
        String PlayerSeven = "James";
        String PlayerEight = "John";

        String[] myItemList = {ItemOne, ItemTwo, ItemThree, ItemFour, ItemFive, ItemSix, ItemSeven, ItemEight};

        ArrayAdapter<String> itemAdapter = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myItemList);

        ListView myList = (ListView)
                findViewById(R.id.ItemList);
                myList.setAdapter(itemAdapter);

        String[] myPlayerList = {PlayerOne, PlayerTwo, PlayerThree, PlayerFour, PlayerFive, PlayerSix, PlayerSeven, PlayerEight};

        ArrayAdapter<String> playerAdapter = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myPlayerList);

        ListView playerList = (ListView)
                findViewById(R.id.PlayerList);
                playerList.setAdapter(playerAdapter);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.camera_button) {
            Intent intent = new Intent(this, CameraActivity.class);   //Intent to Camera Screen
            startActivity(intent);
        }

        if (view.getId() == R.id.exit_button) {
            //Intent intent = new Intent(this, ExitGame)
        }
    }
}
