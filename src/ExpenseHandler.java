import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseHandler {

    public static ArrayList<String> read(String fileName) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<String>();
    //    StringBuilder stringBuilder = new StringBuilder();
        exists(fileName);
        File file = new File(fileName);
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(file.getAbsolutePath()));
            try {
                String s;
                while ((s =inputFile.readLine()) != null) {
                    strings.add(s);
      //              stringBuilder.append(s);
      //              stringBuilder.append("\n");
                }
            } finally {
                inputFile.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    //    return stringBuilder.toString();
        return strings;
    }

    private static void exists(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }


}