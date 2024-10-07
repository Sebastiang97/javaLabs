import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String [] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader (System.in);
        BufferedReader reader = new BufferedReader (inputStreamReader);
        System.out.println("Type name: ");
        String name = reader.readLine();
        System.out.println("Hello "+ this.crearNumero());

    }

    int crearNumero(){
        return 2;
    }
}
