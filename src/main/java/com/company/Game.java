package com.company;

public class Game {

    // En boolean som holder øje med om spillet stadig er igang
    private boolean isPlaing = true;

    // En int som holder øje med hvis tur det er. 0 = player1 og 1 = player2
    private int turn = 0;

    // Opretter to instance af Die klassen, som skal fungere som vores to terninger
    Die dice1 = new Die(1,6);
    Die dice2 = new Die(1,6);

    // Field points
    private final int[] fieldPoints = {250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};



}
