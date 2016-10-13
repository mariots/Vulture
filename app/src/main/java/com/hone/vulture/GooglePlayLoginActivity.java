package com.hone.vulture;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;


public class GooglePlayLoginActivity extends Activity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleApiClient;

    private boolean mSignInClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();
        setContentView(R.layout.activity_google_play_login);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        ((TextView)findViewById(R.id.status_text)).setText("Connection succeeded!");
        findViewById(R.id.sign_in_button).setVisibility(View.GONE);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        ((TextView)findViewById(R.id.status_text)).setText("Connection failed: " + connectionResult.getErrorMessage());
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sign_in_button) {
            TextView text = (TextView)findViewById(R.id.status_text);
            text.setText("Signing into Google Play...");
            mSignInClicked = true;
            mGoogleApiClient.connect();
        }
    }
}
