import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseRegExp {


    public static void main(String[] args) throws IOException {


        File new_filename = new File(args[2]);
        Pattern pattern = Pattern.compile(args[0]);
        String files;
        File folder = new File(args[1]);
        File[] listofFiles  = folder.listFiles();

        BufferedWriter writter;

        if (new_filename.exists()) {

            writter = new BufferedWriter(new FileWriter(new_filename,  true));

        } else {
            writter = new BufferedWriter(new FileWriter(new_filename));
        }

        for (int i = 0; i < listofFiles.length; i++) {
            if (listofFiles[i].isFile()) {
                files = listofFiles[i].getName();

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(folder.getPath() + "\\" + files), "UTF-8"));

                    String line;

                    while ((line = reader.readLine()) != null) {
                        Matcher m = pattern.matcher(line);
                        int count = 0;
                        while (m.find()) {
                            count++;

                        }

                        if (count > 0) {
                          
                            writter.write(line + "\n");
                        }
                    }

                    reader.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        writter.close();

        System.out.println("Done");

    }

}
