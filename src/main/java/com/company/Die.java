package com.company;

import java.util.Random;

public class Die {

    public int diceNumber;
    private final Random random = new Random();
    private final int MIN;
    private final int MAX;

    public Die(int MIN, int MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
    }

    // Metode der slår med en enkelt terning
    public void rollDice() {
        diceNumber = random.nextInt((MAX - MIN + 1)) + MIN;
    }

    // Metode der returner summen af to terninger
    public static int getSum(int dice1, int dice2) {
        return dice1 + dice2;
    }


}
