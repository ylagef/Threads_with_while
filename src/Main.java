import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int numThreads = 32;

        List<Thread> threadList = new ArrayList<>(numThreads);

        for (int i = 0; i < numThreads; ++i) {
            threadList.add(i, new Thread(new OneThread(), Integer.toString(i)));
            threadList.get(i).start();
        }
        //Random print of the threads.

        //For each thread, wait until is ended.
        //Then, this foreach ends when every thread is ended.
        for (Thread t : threadList) {
            while (t.isAlive()) {
              //Wait until t is ended. Empty while?
            }
        }

        /*
        1b. SIN WHILE.
            El resultado es que se imprimen los hilos aleatoriamente así como el mensaje final.
            El mensaje final se imprime tras crear los hilos e iniciarlos, no cuando realmente se finaliza la ejecución.

        1c. CON WHILE.
            Al usar el bucle while, el foreach recorre el ArrayList y por cada uno de los hilos que hemos creado se
            mantiene esperando a que este deje de estar "alive". Esto es, no comprueba el siguiente hasta que el anterior
            se haya "muerto".
            Por lo tanto, cuando se acaba este bucle es por que todos los hilos hayan acabado.
         */

        System.out.println("Program of exercise 4 has terminated."); //Now is printed as final message.
    }
}
