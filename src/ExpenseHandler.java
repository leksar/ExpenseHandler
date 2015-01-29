import java.io.*;

public class ExpenseHandler {

    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsolutePath()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    private static void exists(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }


}
