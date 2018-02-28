package idv.carl.scjp.io;

import java.util.Scanner;

/**
 * @author Carl Lu
 */
public class Exercise3 {

    public static void main(String[] args) {
        FileUtil.open(args[0], fileInputStream -> {
            Scanner file = new Scanner(fileInputStream);
            while (file.hasNextLine()) {
                System.out.println(file.nextLine());
            }
        });
    }

}
