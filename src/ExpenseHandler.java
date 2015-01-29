import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseHandler {

    public static ArrayList<String> read(String fileName) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<String>();
    //    StringBuilder sb = new StringBuilder();
        exists(fileName);
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsolutePath()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    strings.add(s);
      //              sb.append(s);
      //              sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    //    return sb.toString();
        return strings;
    }

    private static void exists(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }


}