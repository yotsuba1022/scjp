package idv.carl.scjp.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Carl Lu
 */
public class IODemo1 {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        String currentLine = null;

        try {
            /*
             * When using IntelliJ, the following line will show the main project's dir name instead of the name of current module,
             * so it's not a good idea to use the following code for retrieving dir name.
             * */
            String root = System.getProperty("user.dir");
            System.out.println(root);

            /*
             * To retrieve the file, we can use relative path, the following lines of code will try to find the
             * test.txt file under target/classes dir.
             *
             * Note: The path of test.txt is: scjp/src/main/resources/io/test.txt , however, after compilation,
             * the test.txt will be put into: scjp/target/classes/io/test.txt
             *
             * */
            System.out.println(IODemo1.class.getResource("/idv/carl/scjp/io").getFile());
            bufferedReader = new BufferedReader(new InputStreamReader(IOException.class.getResourceAsStream("/io/test.txt")));
            while (( currentLine = bufferedReader.readLine() ) != null) {
                System.out.println(currentLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
