package hangman.model;

public interface GameScore {

    /**
     * @param CorrectCount numero de letras correctas
     * @param IncorrectCount numero de letras incorrectas
     * @return score
     */
    int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException;
}
