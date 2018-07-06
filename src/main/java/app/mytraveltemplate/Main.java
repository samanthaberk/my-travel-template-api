package app.mytraveltemplate;
import io.github.cdimascio.dotenv.Dotenv;


public class Main {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        System.out.println(dotenv.get("USERNAME"));
        System.out.println(dotenv.get("PASSWORD"));
    }
}
