package hangman.model;

public class BonusScore implements  GameScore{

    /**
     * @pre Inicia con 0 puntos, puntaje minimo 0
     * @pos Se bonifica con 5^numeroLetra, Se penaliza con -8 puntos cada letra incorrecta
     * @param CorrectCount numero de letras correctas
     * @param IncorrectCount numero de letras incorrectas
     * @return Score,  si el score supera 500 puntos, el jugador obtiene como puntaje final 500.
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException{
        if(CorrectCount < 0 || IncorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 0;
        if(CorrectCount > 0){ score += 10 * CorrectCount;}
        if(IncorrectCount > 0){score -= 5 * IncorrectCount;}
        if(score < 0){ score = 0;}
        return score;
    }
}
