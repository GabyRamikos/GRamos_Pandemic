package Pandemic;

import java.util.*;

public class provajoc {
   public static void main(String[] args) {
      // Crear un array con los nombres de las ciudades del juego
      String[] cities = {"Atlanta", "Chicago", "Essen", "London", "Madrid", "Milan", "Montreal", "New York", "Paris", "San Francisco"};

      // Crear una lista de enfermedades para el juego
      List<String> diseases = new ArrayList<>();
      diseases.add("Virus A");
      diseases.add("Virus B");
      diseases.add("Virus C");

      // Crear un array para llevar la cuenta de la cantidad de enfermedades en cada ciudad
      int[] diseaseCount = new int[cities.length];

      // Crear un array de booleanos para llevar la cuenta de si cada ciudad ha sido investigada
      boolean[] researched = new boolean[cities.length];

      // Colocar aleatoriamente enfermedades en algunas ciudades
      Random rand = new Random();
      for (int i = 0; i < diseaseCount.length; i++) {
         if (rand.nextInt(3) == 0) {
            diseaseCount[i] = rand.nextInt(4) + 1;
         }
      }

      // Jugar el juego
      Scanner input = new Scanner(System.in);
      int currentPlayer = 1;
      boolean gameOver = false;
      while (!gameOver) {
         // Imprimir el tablero del juego
         System.out.println("Ciudades:");
         for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i] + ": " + diseaseCount[i] + " enfermedades");
         }

         // Pedir al jugador que seleccione una ciudad para moverse
         System.out.print("Jugador " + currentPlayer + ", seleccione una ciudad para moverse: ");
         String selectedCity = input.nextLine();

         // Mover al jugador a la ciudad seleccionada
         System.out.println("Moviendo jugador " + currentPlayer + " a " + selectedCity);

         // Pedir al jugador que realice una acción (tratar enfermedades o investigar)
         System.out.print("Seleccione una acción (tratar enfermedades o investigar): ");
         String selectedAction = input.nextLine();
         if (selectedAction.equalsIgnoreCase("tratar enfermedades")) {
            // Tratar enfermedades en la ciudad seleccionada
            System.out.println("Tratando enfermedades en " + selectedCity);
            int diseaseToRemove = rand.nextInt(3) + 1;
            for (int i = 0; i < cities.length; i++) {
               if (cities[i].equalsIgnoreCase(selectedCity)) {
                  if (diseaseCount[i] > 0) {
                     if (diseaseCount[i] >= diseaseToRemove) {
                        diseaseCount[i] -= diseaseToRemove;
                        break;
                     } else {
                        diseaseToRemove -= diseaseCount[i];
                        diseaseCount[i] = 0;
                     }
                  }
               }
            }
         } else if (selectedAction.equalsIgnoreCase("investigar")) {
            // Investigar la ciudad seleccion
        	 System.out.println("Investigando " + selectedCity);
        	 for (int i = 0; i < cities.length; i++) {
        	 if (cities[i].equalsIgnoreCase(selectedCity)) {
        	 researched[i] = true;
        	 break;
        	 }
        	 }
        	 } else {
        	 // Acción no válida, pasar el turno
        	 System.out.println("Acción no válida, pasando turno");
        	 }
         // Comprobar si se ha ganado el juego (todas las enfermedades investigadas)
         boolean allResearched = true;
         for (int i = 0; i < researched.length; i++) {
            if (!researched[i]) {
               allResearched = false;
               break;
            }
         }
         if (allResearched) {
            System.out.println("¡Has ganado el juego!");
            gameOver = true;
         }

         // Comprobar si se ha perdido el juego (demasiadas enfermedades en una ciudad)
         for (int i = 0; i < cities.length; i++) {
            if (diseaseCount[i] >= 5) {
               System.out.println("¡Demasiadas enfermedades en " + cities[i] + ", has perdido el juego!");
               gameOver = true;
               break;
            }
         }

         // Pasar al siguiente jugador
         currentPlayer++;
         if (currentPlayer > 4) {
            currentPlayer = 1;
         }
      }
   }
}
