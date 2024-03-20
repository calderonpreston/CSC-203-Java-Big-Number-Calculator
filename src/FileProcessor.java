import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */

    public static void processFile(String filePath) {

        LinkedList final_result = new LinkedList();

        File infile = new File(filePath);

        String operation = "";

        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNextLine()) {

                String line = scan.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] integers = line.split("\\s*[\\*+\\-/%]\\s*");

                if (integers.length == 2) {
                    String first_integer= integers[0].trim().replaceAll("^0+(?!$)", "");
                    String second_integer = integers[1].trim().replaceAll("^0+(?!$)", "");
                    operation = line.replaceAll(".*([*+]).*", "$1");

                    LinkedList newlist_1 = new LinkedList();
                    LinkedList newlist_2 = new LinkedList();

                    for (char digit : first_integer.toCharArray()) {
                        if (digit >= '0' && digit <= '9') {
                            int converted_digit = digit - '0';
                            newlist_1.addReverseOrder(converted_digit);
                        }
                        else {
                            System.out.println("Invalid character detected.");
                        }
                    }
                    for (char digit : second_integer.toCharArray()) {
                        if (digit >= '0' && digit <= '9') {
                            int converted_digit = digit - '0';
                            newlist_2.addReverseOrder(converted_digit);
                        }
                        else{
                            System.out.println("Invalid character detected.");
                        }
                    }

                    if (operation.equals("+")) {
                        final_result = LinkedList.addition(newlist_1, newlist_2);
                    } else if (operation.equals("*")) {
                        final_result = LinkedList.multiplication(newlist_1, newlist_2);
                    } else {
                        System.out.println("Invalid operation: " + operation);
                        continue;
                    }
                    newlist_1.reverse();
                    newlist_2.reverse();
                    final_result.reverse();
                    System.out.println(newlist_1.toString() + ' ' + operation + ' ' + newlist_2.toString() + " = " + final_result.toString().replaceAll("^0+(?!$)", ""));
                } else {
                    System.out.println("Input format does not follow the structure: 'positive integer' '(+ or *)' 'positive integer'");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}