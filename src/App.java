import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String comando;

        do {
            comando = in.nextLine();

            if (comando.equals("limpa")) {
                limpa();
            }
            else {
                System.out.println("Teste");
                System.out.println(comando);
            }

        } while(!comando.equals("exit"));

    }

    public static void limpa() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
