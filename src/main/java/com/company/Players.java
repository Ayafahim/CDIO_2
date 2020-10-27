package com.company;
import gui_fields.GUI_Player;
import static com.company.Gui.gui;
public class Players {

    // String der får bruger input om brugerens navn
    public String spillerNavn = gui.getUserString("Indtast et navn");
    public GUI_Player guiPlayer = new GUI_Player(spillerNavn);
    public int playerPosition =0;

    // metode der tilføjer spilleren

    public void addPlayer(){
        guiPlayer.getPrimaryColor();
        gui.addPlayer(guiPlayer);
    }




}
