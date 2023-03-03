package hangman.model;

public class OriginalScore {
    /**
     * @pre Se inicia con 100 puntos, puntaje minimo 0
     * @pos Se penaliza con 10 puntos por cada letra incorrecta
     * @param CorrectCount numero de letras correctas
     * @param IncorrectCount numero de letras incorrectas
     * @return score
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException{
        if(CorrectCount < 0 || IncorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 100;
        if(IncorrectCount > 0 ){
            score -= IncorrectCount * 10;
        }
        if(score < 0 ){ score = 0;}

        return score;
    }
}
