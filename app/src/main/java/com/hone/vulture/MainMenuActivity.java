package com.hone.vulture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity implements  View.OnClickListener {

    private static final String GAME_TYPE = "Placeholder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        TextView text = (TextView)findViewById(R.id.connection_identifier);
        text.setText(message);


        //Added Listeners for buttons halephil
        findViewById(R.id.quick_button).setOnClickListener(this);
        findViewById(R.id.host_button).setOnClickListener(this);
        findViewById(R.id.check_invites_button).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.quick_button) {
        /*    Intent intent = new Intent(this, SetGameVariableActivity.class);   //Intent to Set Game Variables
            String game_type = "quick_game";                                   //Set game_type variable
            intent.putExtra(GAME_TYPE, game_type);                             //Set game_type as an extra
            startActivity(intent);*/
        }
        if (view.getId() == R.id.host_button) {
            /*Intent intent = new Intent(this, SetGameVariableActivity.class);   //Intent to Set Game Variables
            String game_type = "private_game";                                 //Set game_type variable
            intent.putExtra(GAME_TYPE, game_type);                             //Set game_type as an extra
            startActivity(intent);*/
        }
        if (view.getId() == R.id.check_invites_button) {
            //Go to CheckInvitesActivity
            Intent intent = new Intent(this, CheckInvitesActivity.class);       //Intent to Check Invites
            startActivity(intent);
        }

    }
}
