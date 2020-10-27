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

    // Field msg's
    private final String towerMsg = "Du har fundet værdi fulde genstande i et tårn og har solgt det for 250 point!";
    private final String craterMsg = "Du faldt ned i en krater og mistede 100 point!";
    private final String palaceGatesMsg = "I din rejse besøgte du et palads, hvor kongen gav dig 100 point!";
    private final String coldDesertMsg = "Du er faret vild om natten i en kold ørken og tabte 20 point...";
    private final String walledCityMsg = "Du fandt en indlukket by og som præmie for at finde dem, modtager du 180 point!";
    private final String monasteryMsg = "Du har fundet et kloster! Men der er dsv tomt, så du rejser videre...";
    private final String blackCaveMsg = "Du er oppe i bjergene, hvor du er inde i en mørk grotte. Fordi du intet kan se" +
            ", så taber du 70 point..";
    private final String hutsInTheMountainMsg = "Oppe ved bjergene finder du en masse hytter, som tilhører troldemænd!" +
            " De giver dig 60 point til din rejse.";
    private final String theWereWallMsg = "Åh nej! Du finder en varulv på din væg! Den stjæler 80 point fra dig!" +
            " Men du vinder en ekstra tur!";
    private final String thePitMsg = "Damn it! Du er faldet ned i et hul og har tabt 50 point...";
    private final String goldMineMsg = "JUBI!!! Du har fundet en guld mine oppe på bjergene og har solgt guldet for " +
            "650 point!";



}
