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
   
   ![image](https://user-images.githubusercontent.com/98113396/222854918-6be4450a-caf7-4896-988a-7f7319e58ade.png)
   
   ## originalScore
   
   ![image](https://user-images.githubusercontent.com/98113396/222854991-2eb8c441-503e-48ed-9509-6ab609783d31.png)
   
   ## Bonus
   ![image](https://user-images.githubusercontent.com/98113396/222855084-4c5ac7bb-8d2c-4562-a11b-d577777df64b.png)

 ## implementación clase 
 ![image](https://user-images.githubusercontent.com/98113396/222855165-a3cbb222-663f-4b70-92f2-8a1ffc687af3.png)
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


4. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "especificación métodos"
	```

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
9. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.

10. Al finalizar haga un nuevo commit:

	```bash		
	git add .			
	git commit -m "implementación del modelo"
	```

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
