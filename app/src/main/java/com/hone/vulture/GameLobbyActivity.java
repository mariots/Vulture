package com.hone.vulture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameLobbyActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> myItemList = new ArrayList<String>();                                         //Create item list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);
        findViewById(R.id.AddFriendButton).setOnClickListener(this);
        findViewById(R.id.ReadyButton).setOnClickListener(this);
        findViewById(R.id.QuitButton).setOnClickListener(this);

        String ItemOne = "Backpack";                                                                     //Placeholders
        String ItemTwo = "Desk";                                                                     //In real case use getExtra to retrieve the items for the list
        String ItemThree = "Cell Phone";
        String ItemFour = "Shoe";
        String ItemFive = "Five";
        String ItemSix = "Six";
        String ItemSeven = "Seven";
        String ItemEight = "Eight";

        String PlayerOne = "Andrew";                                                                //Placeholders
        String PlayerTwo = "Alex";                                                                  //In real case use getExtra to retrieve the items for the list
        String PlayerThree = "Dian";
        String PlayerFour = "Halen";
        String PlayerFive = "Mario";
        String PlayerSix = "Bob";
        String PlayerSeven = "James";
        String PlayerEight = "John";

        String itemDatabase [] = {ItemOne, ItemTwo, ItemThree, ItemFour, ItemFive, ItemSix, ItemSeven, ItemEight};

        Intent previousIntent = getIntent();
        //Integer numberOfItems = previousIntent.getIntExtra("NUMBER_OF_ITEMS", 0);

        Integer numberOfItems = 4;

        for(int i = 0; i < numberOfItems; i++){
            myItemList.add(itemDatabase[i]);
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ReadyButton) {
            Intent intent = new Intent(this, InGameActivity.class);//Intent to Start a Game
            intent.putStringArrayListExtra("ITEM_LIST", myItemList);
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