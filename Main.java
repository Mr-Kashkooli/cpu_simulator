import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Storage storage = new Storage();
        ControlUnit controlUnit = new ControlUnit();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write file name: ");
        String file_name = scanner.next();
        String file_path = System.getProperty("user.dir") + "\\src\\" + file_name + ".txt";

        storage.load(file_path);

        controlUnit.aVoid(storage, controlUnit);

    }
}
