package com.hone.vulture;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameUtils;


public class GameLobbyActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInFlow = true;
    private boolean mSignInClicked = false;

    private static int RC_SIGN_IN = 9001;

    @Override
    public void onConnected(Bundle connectionHint) {
        ((TextView)findViewById(R.id.status_text)).setText("Connection succeeded!");
        findViewById(R.id.sign_in_button).setVisibility(View.GONE);
        Intent intent = new Intent(this, MainMenuActivity.class);
        String extraMessage = "";
        intent.putExtra("EXTRA_MESSAGE", extraMessage);
        startActivity(intent);
    }



    @Override
    public void onConnectionSuspended(int i) {
        client.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (mResolvingConnectionFailure) {
            // already resolving
            return;
        }

        // if the sign-in button was clicked or if auto sign-in is enabled,
        // launch the sign-in flow
        if (mSignInClicked || mAutoStartSignInFlow) {
            mAutoStartSignInFlow = false;
            mSignInClicked = false;
            mResolvingConnectionFailure = true;

            // Attempt to resolve the connection failure using BaseGameUtils.
            // The R.string.signin_other_error value should reference a generic
            // error string in your strings.xml file, such as "There was
            // an issue with sign-in, please try again later."
            if (!BaseGameUtils.resolveConnectionFailure(this,
                    client, connectionResult,
                    RC_SIGN_IN, "Sign-in error")) {
                mResolvingConnectionFailure = false;
            }
        }

    }

    // request code for the "select players" UI
// can be any number as long as it's unique
    final static int RC_SELECT_PLAYERS = 10000;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);
        // Create a GoogleApiClient instance

        client = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */,
                        this /* OnConnectionFailedListener */)
                .addApi(Drive.API)
                .addScope(Drive.SCOPE_FILE)
                .build();

        View.OnClickListener lister = new View.OnClickListener() {

            public void onClick(View view) {
                if (view.getId() == R.id.AddFriendButton) {
                    // launch the player selection screen
                    // minimum: 1 other player; maximum: 3 other players
                    Intent intent = Games.RealTimeMultiplayer.getSelectOpponentsIntent(client, 1, 3);
                    startActivityForResult(intent, RC_SELECT_PLAYERS);

                }
                if (view.getId() == R.id.ReadyButton) {
                    Intent intent = new Intent(GameLobbyActivity.this, InGameActivity.class);//Intent to Start a Game
                    startActivity(intent);
                    ;
                }
                if (view.getId() == R.id.QuitButton) {
                    /*Intent intent = new Intent(GameLobby.this, MainMenuActivity.class);//Intent to Go back to Main Menu
                    startActivity(intent);*/
                }
            }
        };
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("GameLobby Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}