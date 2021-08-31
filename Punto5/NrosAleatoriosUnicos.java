import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NrosAleatoriosUnicos {
    static int cantNros = 1000;
    public static void main(String[] args) {
        double tiempoInicial = System.nanoTime();
        ArrayList nros = crearLista(cantNros);
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter("./numerosUnicos.txt"));
            for(int i=1; i<=cantNros;i++) {
                int indice = getIndice(nros);
                int nuevoNro = getUnNumero(nros, indice);
                nros.remove(indice);
                buff.write(nuevoNro + "\n");
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }finally {
            double tiempoFinal = System.nanoTime();
            double tiempoTotal = tiempoFinal-tiempoInicial;
            System.out.println("Tiempo: "+tiempoTotal+"ns");
        }
    }

    public static ArrayList crearLista(int cantNros){
        ArrayList<Integer> nros = new ArrayList<Integer>();
        for(int i=1;i<=cantNros;i++){
            nros.add(i);
        }
        return nros;
    }

    public static int getUnNumero(ArrayList nros, int indice){
        int res = (int) nros.get(indice);
        return res;
    }

    public static int getIndice(ArrayList nros){
        //Random generador = new Random();
        int min=1;
        int tope = nros.size();
        //int indice = generador.nextInt(tope);
        int indice = (int) (Math.random()*tope);
        return indice;
    }
}