package com.hone.vulture;

/**
 * Created by halen on 10/17/2016.
 */

public class Invitation {
    private String senderName;
    private int senderID;
    private int iconID;
    //private String receiverName;
    //private String receiverID;
    private String gameType;
    private int lobbyID;

    //Sets the values for each varible when the object is intialized
    public Invitation(String senderName, int senderID, int iconID, String gameType, int lobbyID){
        super();
        this.senderName = senderName;
        this.senderID = senderID;
        this.iconID = iconID;
        this.gameType = gameType;
        this.lobbyID = lobbyID;
    }

    //Gets the Senders Name from the Invitation
    public String getSenderName() {
        return senderName;
    }

    //Gets the SendersID from the Invitation
    public int getSenderID() {
        return senderID;
    }
    //Gets the IconID
    public int getIconID() {
        return iconID;
    }

    public String getGameType() {
        return gameType;
    }
    //Gets the Lobby ID from the Invitation
    public int getLobbyID() {
        return lobbyID;
    }


}
