### Escuela Colombiana de Ingeniería

### Presentado por
## Gabriel Alejandro Silva Lozada 
## Santiago Naranjo Melo 




### Parte I

1. Clone el proyecto (no lo descargue!).

![image](https://user-images.githubusercontent.com/98113396/222854840-a402df86-94ca-481c-b0ab-a0bdf9587d9e.png)

   
2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.
   
   ## powerScore
   ```
   
   public class PowerScore implements  GameScore{

    /**
     * @pre Inicia con 0 puntos, puntaje minimo 0
     * @pos Se bonifica con 10 puntos cada letra correcta, se penaliza con -5 puntos letra incorrecta
     * @param CorrectCount numero de filas
     * @param IncorrectCount numero de columnas
     * @return Score
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException{
        if(CorrectCount < 0 || IncorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 0;
        if(CorrectCount > 0){
            for(int x = 0; x < CorrectCount; x++){
                score += Math.pow(5,x+1);
            }
        }
        if(IncorrectCount > 0 ){
            score -= 8 * IncorrectCount;
        }
        if (score >= 500){ score = 500;}
        if (score < 0){score = 0;}
        return score;
    }

   ## originalScore
   ```
   public class OriginalScore implements  GameScore {
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
		
```
## Bonus
   
   ```
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
```
   

 ## implementación clase 
 
 ```
 
 public interface GameScore {

    /**
     * @param CorrectCount numero de letras correctas
     * @param IncorrectCount numero de letras incorrectas
     * @return score
     */
    int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException;
}
	
```

##parte labo

4. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "especificación métodos"
	```
	![image](https://user-images.githubusercontent.com/98113396/222856347-75499ad9-ce0b-4066-9a33-b13d179b64e4.png)

5. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8 .
   

6. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera. 

7. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.

8. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "implementación pruebas"
	```
	
	![image](https://user-images.githubusercontent.com/98113396/222856402-d30a804a-8d72-40fd-8f4b-5bcf3450d8ef.png)

	
	
9. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.
   
   ![image](https://user-images.githubusercontent.com/98113396/222856448-5b14c119-81bf-44db-9184-49286093b19d.png)


10. Al finalizar haga un nuevo commit:

	```bash		
	git add .			
	git commit -m "implementación del modelo"
	```
	
	![image](https://user-images.githubusercontent.com/98113396/222856347-75499ad9-ce0b-4066-9a33-b13d179b64e4.png)


11. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

```bash	
	git push <URL Repositorio>	
```


### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar createGUIUsingFactoryMethod en SwingProject, el
constructor de la clase GUI y HangmanFactoryMethod).

En este taller se va a utilizar un contenedor liviano ([GoogleGuice](https://github.com/google/guice)) el cual soporta la inyección de las dependencias.

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

Incorpore el Contenedor Liviano Guice dentro del proyecto:

* Revise las dependencias necesarias en el pom.xml.
* Modifique la inyección de dependencias utilizando guice en lugar del
  método fábrica..
* Configure la aplicación de manera que desde el programa SwingProject
  NO SE CONSTRUYA el Score directamente, sino a través de Guice, asi
  mismo como las otras dependencias que se están inyectando mediante
  la fabrica.
* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
	* Utilizar el esquema OriginalScore.
	* Utilizar el esquema BonusScore.
	* Utilizar el idioma francés.
    * Utilizar el diccionario francés.
	* etc...
* Para lo anterior, [puede basarse en el ejemplo dado como
  referencia](https://github.com/PDSW-ECI/LightweighContainers_DepenendecyInjectionIntro-WordProcessor).
