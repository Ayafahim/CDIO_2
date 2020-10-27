package com.company;

import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_main.GUI;

import java.awt.*;

public class Gui {

    public static GUI gui;
    public static GUI_Field[] fields;


    public static void createGUI() {
        fields = new GUI_Field[3];
        fields[0] = new GUI_Start();
        fields[0].setTitle("Start");

        fields[1] = new GUI_Shipping();
        fields [1].setBackGroundColor(Color.GRAY);
        fields[1].setTitle("Tower");

        fields[2] = new GUI_Chance();
        fields[2].setBackGroundColor(Color.GREEN);
        fields[2].setTitle("Krater");

        gui = new GUI(fields);
    }

}
