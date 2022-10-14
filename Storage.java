import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Storage {

    int number_of_line = 0;

    // array that holds strings of a file
    String[] data = new String[10000];

    // Load text int matrix
    void load(String file_path) throws IOException {

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader(file_path));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        int i =0 ;
        while (line!=null){
            data[i] = line;
            line = bf.readLine();
            number_of_line++;
            i++;
        }
        for (int j = i ; j <10000 ; j++){
            data[j] = "+0000000000";
        }

        // closing BufferedReader object
        bf.close();

    }
}
