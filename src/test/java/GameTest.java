import com.company.Die;
import com.company.Game;
import com.company.Player;
import gui_fields.GUI_Player;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class GameTest {

    // Test for calculateBalance() metoden fra Game klassen. Bevis for at man ikke kan få under 0 point.
    @Test
    void testCalculateNegativeBalance() {
        Game game = new Game();
        GUI_Player player1 = new GUI_Player("aya");
        game.calculateBalance(-2000, 1000, player1);
        Assert.assertEquals(0, player1.getBalance());
        System.out.println(player1.getBalance());
    }

    // Begge tests forneden tjekker at vi ikke kan slå over en sum af 12
    @Test
    void testDiceMax() {
        Die dice1 = new Die(1, 6);
        Die dice2 = new Die(1, 6);

        for (int i = 0; i < 100; i++) {
            int faceValue = Die.diceTurn(dice1, dice2);
            Assert.assertTrue(faceValue <= 12);
            System.out.println(faceValue);
        }
    }

    @Test
    void testFaceValuePastLimit() {
        Die dice1 = new Die(1, 6);
        Die dice2 = new Die(1, 6);

        for (int i = 0; i < 100; i++) {
            int faceValue = Die.diceTurn(dice1, dice2);
            Assert.assertFalse(faceValue > 12);
            System.out.println(faceValue);
        }
    }


}

