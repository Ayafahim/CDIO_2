package com.company;

public class Main {

    public static Player player1;
    public static Player player2;
    public static Game game = new Game();



    public static void main(String[] args) {
        Gui.createGUI();


        player1 = new Player();
        player2 = new Player();

        player1.addPlayer();
        player2.addPlayer();


        Gui.fields[0].setCar(player1.guiPlayer, true);
        Gui.fields[0].setCar(player2.guiPlayer, true);

        game.game();
    }
}
