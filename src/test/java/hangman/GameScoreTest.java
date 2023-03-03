package hangman;
import hangman.model.*;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest {
    /**
     * @author  Gabriel alejandro Silva Lozada
     * @author Santiago Naranja Melo
     * Original Score
     Numero  	              Clase de equivalencia 		                       Resultado
     # Letras correctas	     # Letras Incorrectas
     1	                   < 0		                                            Incorrecto
     2		                                        < 0	                        Incorrecto
     3	                LC >= 0	                      0	                           100
     4	                LC > 0	                 LI > 0  ^ LI < 11	           100 - (10 * LI)
     5	                LC > 0	                    LI > 11	                        0
     */

/**
 * Bonus Score
 Numero 	              Clase de equivalencia 		                        Resultado
 # Letras correctas	    # Letras Incorrectas
 1	                   < 0 		                                                Incorrecto
 2		                                      < 0 	                            Incorrecto
 3	                  LC >= 0 	                0	                             LC * 10
 4	                  LC > 0 	             LI < LC 	                    (LC * 10) - (LI * 5)
 5	                  LC > 0 	            LI >= LC * 2 	                        0
 */


    /**
     * Power Score
     * Numero 	              Clase de equivalencia 		                        Resultado
     * # Letras correctas	    # Letras Incorrectas
     * 1	                    < 0 		                                            Incorrecto
     * 2		                                        < 0	                            Incorrecto
     * 3	                  LC > 0 	                  0	                        La $i-ésima$ letra correcta se bonifica con $5^i$
     * 4	                    0	                    LI > 0 	                            0
     * 5	                LC >= 4 	                  0	                                500
     * 6	                LC > 1	                    LI > 0 	                    La $i-ésima$ letra correcta se bonifica con $5^i$ - (8*LI)
     */

    @Test
    public void calulateScore_debeLanzarExcepcionClaseOriginal() {
        //Arrange
        GameScore game = new OriginalScore();
        try {
            //Act
            game.CalculateScore(-2, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            //Assert
            Assert.assertTrue(true);
        }
    }

    @Test
    public void calulateScore_debeLanzarExcepcionClasepower() {
        //Arrange
        GameScore game = new PowerScore();
        try {
            //Act
            game.CalculateScore(-2, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            //Assert
            Assert.assertTrue(true);
        }
    }

    @Test
    public void calulateScore_debeLanzarExcepcionClaseScore() {
        //Arrange
        GameScore game = new BonusScore();
        try {
            // Act
            game.CalculateScore(-2, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            //Assert
            Assert.assertTrue(true);
        }
    }

    @Test
    public void calulateScore_deberiaSer100Score() throws GameScoreException {
        //Arrange
        GameScore game = new OriginalScore();
        //Act
        int score = game.CalculateScore(10,0);
        // Assert
        Assert.assertTrue(score == 100);
    }
    @Test
    public void calulateScore_deberiaSer500Score() throws GameScoreException {
        //Arrange
        GameScore game = new OriginalScore();
        //Act
        int score = game.CalculateScore(2,5);
        // Assert
        Assert.assertTrue(score == 50);
    }

    @Test
    public void calulateScore_deberiaSer0Score() throws GameScoreException {
        //Arrange
        GameScore game = new OriginalScore();
        //Act
        int score = game.CalculateScore(2,11);
        // Assert
        Assert.assertTrue(score == 0);
    }

    @Test
    public void calulateScore_deberiaSer100Bonificacion() throws GameScoreException {
        //Arrange
        GameScore game = new BonusScore();
        //Act
        int score = game.CalculateScore(10,0);
        // Assert
        Assert.assertTrue(score == 100);
    }

    @Test
    public void calulateScore_deberiaSerBonoMinimo() throws GameScoreException {
        //Arrange
        GameScore game = new BonusScore();
        //Act
        int score = game.CalculateScore(10,20);
        //Assert
        Assert.assertTrue(score ==0);
    }
    @Test
    public void calulateScore_deberiaSerCorrectasletrasypenalidad() throws GameScoreException {
        //Arrange
        GameScore game = new BonusScore();
        //Act
        int score = game.CalculateScore(10,8);
        //Assert
        Assert.assertTrue(score ==60);
    }

    @Test
    public void calulateScore_deberiaSerPuntuacionMaxPoder() throws GameScoreException {
        //Arrange
        GameScore game = new PowerScore();
        //Act
        int score = game.CalculateScore(4,1);
        //Assert
        Assert.assertTrue(score == 500);
    }

    @Test
    public void calulateScore_deberiaSerPuntuacionMinPoder() throws GameScoreException {
        //Arrange
        GameScore game = new BonusScore();
        // Act
        int score = game.CalculateScore(10,20);
        // Assert
        Assert.assertTrue(score == 0);
    }

    @Test
    public void calulateScore_deberiaSerNormalPuntuacionPoder() throws GameScoreException {
        // Arrange
        GameScore game = new PowerScore();
        // Act
        int score = game.CalculateScore(3,0);
        // Assert
        Assert.assertTrue(score == 155);
    }
}

