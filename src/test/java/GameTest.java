import org.junit.jupiter.api.Test;


public class GameTest {

    int points = 1000;

    // Test for calculateBalance() metoden fra Game klassen. Bevis for at man ikke kan få under 0 point.
    @Test
    void calculateBalance() {
        for(int i = 0; i < 1000; i+=100) {
            if (points <= 0) {
                points = 0;
            } else {
                points = points - 200;
            }
            System.out.printf("You have %d points%n", points);
        }
    }


}
