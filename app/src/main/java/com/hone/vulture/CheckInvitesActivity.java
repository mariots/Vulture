package com.hone.vulture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckInvitesActivity extends AppCompatActivity {

    private List<Invitation> myInvitations = new ArrayList<Invitation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_invites);

        populateInvitationList();
        populateListView();
        //registerListViewClck();


    }




    private void populateInvitationList(){
        myInvitations.add(new Invitation("Halen", 1, R.mipmap.ic_launcher, "QuickGame", 0001));
        myInvitations.add(new Invitation("Andrew", 1, R.mipmap.ic_launcher, "Multiplayer", 0002));
        myInvitations.add(new Invitation("Alex", 1, R.mipmap.ic_launcher, "Single Player", 0003));
        myInvitations.add(new Invitation("Dian", 1, R.mipmap.ic_launcher, "QuickGame", 0004));
        myInvitations.add(new Invitation("Mario", 1, R.mipmap.ic_launcher, "Legendary", 0005));
        myInvitations.add(new Invitation("Halen", 1, R.mipmap.ic_launcher, "QuickGame", 0001));

    }

    private void populateListView() {
        ArrayAdapter<Invitation> adapter = new MyAdapter();
        ListView list = (ListView)findViewById(R.id.invitationsListView);
        list.setAdapter(adapter);
    }




    private class MyAdapter extends ArrayAdapter<Invitation> {
        public MyAdapter(){
            super(CheckInvitesActivity.this, R.layout.item_view, myInvitations);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            Invitation currentInvitation = myInvitations.get(position);

            ImageView imageView =(ImageView)itemView.findViewById((R.id.item_icon));
            imageView.setImageResource(currentInvitation.getIconID());

            TextView textGameType = (TextView)itemView.findViewById((R.id.item_gameType));
            textGameType.setText(currentInvitation.getGameType());

            TextView textSenderName = (TextView)itemView.findViewById((R.id.item_senderName));
            textSenderName.setText(currentInvitation.getSenderName());





            return itemView;
        }






    }
}
