package com.company;

import gui_fields.*;
import gui_main.GUI;
import java.awt.*;


public class Gui {

    public static GUI gui;
    public static GUI_Field[] fields;


    public static void createGUI() {
        fields = new GUI_Field[12];
        fields[0] = new GUI_Start();
        fields[0].setTitle("Start");

        fields[1] = new GUI_Shipping();
        fields[1].setBackGroundColor(Color.GRAY);
        fields[1].setTitle("Tower");

        fields[2] = new GUI_Chance();
        fields[2].setBackGroundColor(Color.GREEN);
        fields[2].setTitle("Krater");

        fields[3] = new GUI_Chance();
        fields[3].setBackGroundColor(Color.YELLOW);
        fields[3].setTitle("Gold Palace");

        fields[4] = new GUI_Brewery();
        fields[4].setBackGroundColor(Color.YELLOW);
        fields[4].setTitle("Gold Palace");

        fields[5] = new GUI_Refuge();
        fields[5].setBackGroundColor(Color.DARK_GRAY);
        fields[5].setTitle("Cold Desert");

        fields[6] = new GUI_Street();
        fields[6].setBackGroundColor(Color.YELLOW);
        fields[6].setTitle("Walled City");

        fields[7] = new GUI_Chance();
        fields[7].setBackGroundColor(Color.DARK_GRAY);
        fields[7].setTitle("Monastery");

        fields[8] = new GUI_Chance();
        fields[8].setBackGroundColor(Color.PINK);
        fields[8].setTitle("Black Cave");

        fields[9] = new GUI_Chance();
        fields[9].setBackGroundColor(Color.WHITE);
        fields[9].setTitle("Huts in the mountain");

        fields[10] = new GUI_Chance();
        fields[10].setBackGroundColor(Color.LIGHT_GRAY);
        fields[10].setTitle("The Pit");

        fields[11] = new GUI_Chance();
        fields[11].setBackGroundColor(Color.YELLOW);
        fields[11].setTitle("Goldmine");




        gui = new GUI(fields);
    }

}
