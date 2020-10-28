package com.company;

import gui_fields.GUI_Player;

import static com.company.Gui.gui;

public class Game {

    // En boolean som holder øje med om spillet stadig er igang
    private boolean isPlaying = true;

    // En int som holder øje med hvis tur det er. 0 = player1 og 1 = player2
    private int turn = 0;

    // Opretter to instance af Die klassen, som skal fungere som vores to terninger
    Die dice1 = new Die(1, 6);
    Die dice2 = new Die(1, 6);

    // Field points
    private final int[] fieldPoints = {250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};

    // Field msg's
    private final String towerMsg = "Du har fundet værdifulde genstande i et tårn og har solgt det for 250 point!";
    private final String craterMsg = "Du faldt ned i et krater og mistede 100 point!";
    private final String palaceGatesMsg = "I din rejse besøgte du et palads, hvor kongen gav dig 100 point!";
    private final String coldDesertMsg = "Du er faret vild om natten i en kold ørken og tabte 20 point...";
    private final String walledCityMsg = "Du fandt en indlukket by og som præmie for at finde den, modtager du 180 point!";
    private final String monasteryMsg = "Du har fundet et kloster! Men der er dsv tomt, så du rejser videre...";
    private final String blackCaveMsg = "Du er oppe i bjergene, hvor du er inde i en mørk grotte. Fordi du intet kan se" +
            ", så taber du 70 point..";
    private final String hutsInTheMountainMsg = "Oppe ved bjergene finder du en masse hytter, som tilhører troldemænd!" +
            " De giver dig 60 point til din rejse.";
    private final String theWereWallMsg = "Åh nej! Du finder en varulv! Den stjæler 80 point fra dig!" +
            " Men du vinder en ekstra tur!";
    private final String thePitMsg = "Damn it! Du er faldet ned i et hul og har tabt 50 point...";
    private final String goldMineMsg = "JUBI!!! Du har fundet en guld mine oppe på bjergene og har solgt guldet for " +
            "650 point!";


    // Metode der bruger 2 instance af Die klassen, som ruller ruller med terninger via rollDice() metoden fra Die klassen
    private int diceTurn(Die dice1, Die dice2) {

        dice1.rollDice();
        dice2.rollDice();

        return Die.getSum(dice1.diceNumber, dice2.diceNumber);
    }

    // Metode der udregner spillerens balance alt efter hvilket felt de er landet ved. Spillerns balance kan ikke komme under 0.
    private void calculateBalance(int fieldPoint, String fieldMsg, int playerBalance, GUI_Player player) {
        if (!(player.getBalance() < 0)) {
            playerBalance = fieldPoint + playerBalance;
            if (playerBalance < 0) {
                player.setBalance(0);
            } else {
                player.setBalance(playerBalance);
            }
        } else {
            player.setBalance(0);
        }
        gui.showMessage(fieldMsg);
    }

    // Metode der tjekker hvilket felt spilleren er landet på alt efter hvad summen af terningerne er og kalder calculateBalance() metoden efter hvert case
    private void setPlayerBalance(int sum, int playerBalance, GUI_Player player) {


        switch (sum) {
            // tower
            case 2:
//                fields[1].setCar(player, true);
//                fields[0].removeAllCars();
                calculateBalance(fieldPoints[0], towerMsg, playerBalance, player);
                break;
            // crater
            case 3:
//                fields[2].setCar(player, true);
//                fields[1].removeAllCars();
                calculateBalance(fieldPoints[1], craterMsg, playerBalance, player);
                break;

            // palace gates
            case 4:
                calculateBalance(fieldPoints[2], palaceGatesMsg, playerBalance, player);
                break;

            // cold desert
            case 5:
                calculateBalance(fieldPoints[3], coldDesertMsg, playerBalance, player);
                break;


            // walled city
            case 6:
                calculateBalance(fieldPoints[4], walledCityMsg, playerBalance, player);
                break;


            // monastery
            case 7:
                calculateBalance(fieldPoints[5], monasteryMsg, playerBalance, player);
                break;


            // black cave
            case 8:
                calculateBalance(fieldPoints[6], blackCaveMsg, playerBalance, player);
                break;


            // huts in the mountain
            case 9:
                calculateBalance(fieldPoints[7], hutsInTheMountainMsg, playerBalance, player);
                break;


            // the were wll
            case 10:
                calculateBalance(fieldPoints[8], theWereWallMsg, playerBalance, player);
                if (turn == 0) {
                    turn = 1;
                } else {
                    turn = 0;
                }
                break;


            // the pitt
            case 11:
                calculateBalance(fieldPoints[9], thePitMsg, playerBalance, player);
                break;


            // gold mine
            case 12:
                calculateBalance(fieldPoints[10], goldMineMsg, playerBalance, player);
                break;
        }


    }

    // Metode der bliver kaldt, når en det er en spillers tur
    private void userTurn(Player player) {
        gui.showMessage(player.spillerNavn + "'s tur");
        String knap = gui.getUserSelection("Slå med terningen", "Slå!");
        if (knap.equals("Slå!")) {
            int sum = diceTurn(dice1, dice2);
            gui.setDice(dice1.diceNumber, dice2.diceNumber);
//            int sum = 3;
            System.out.printf("sum is %d. dice1 is %d and dice2 is %d%n", sum, dice1.diceNumber, dice2.diceNumber);
            setPlayerBalance(sum, player.guiPlayer.getBalance(), player.guiPlayer);
        }
    }

    // Metode der beregner hvis tur det er
    private void calculateUserTurn(Player player1, Player player2) {
        if (turn == 0) {
            turn = 1;
            userTurn(player1);
        } else if (turn == 1) {
            turn = 0;
            userTurn(player2);
        }
    }

    // Metode der holder øje med om nogle af brugerne der har vundet
    public void game() {
        do {
            calculateUserTurn(Main.player1, Main.player2);
            // Tjekker om nogle af brugerne har 3000 eller over point. Hvis ikke, kaldes calculateUserTurn() metoden.
            if (Main.player1.guiPlayer.getBalance() >= 3000 || Main.player2.guiPlayer.getBalance() >= 3000) {
                if (turn == 0) {
                    gui.showMessage(Main.player2.spillerNavn + " har vundet!");
                } else {
                    gui.showMessage(Main.player1.spillerNavn + " har vundet!");
                }
                boolean playAgain = gui.getUserLeftButtonPressed("Vil du spille igen?", "Ja", "Nej");
                isPlaying = false;
                Main.player1 = null;
                Main.player2 = null;
                if (playAgain) {
                    isPlaying = true;
                    gui.close();
                    Main.main(null);
                } else {
                    gui.close();
                }
            }


        } while (isPlaying);
    }

}
