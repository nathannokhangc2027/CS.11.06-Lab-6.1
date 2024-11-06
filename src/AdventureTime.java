import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));


    }
    public static int countLines(String nameOfFile) throws FileNotFoundException {

        File file = new File(nameOfFile);
        Scanner scanner = new Scanner(file);

        int lineCount = 0;

        while (scanner.hasNextLine()) {

            lineCount++;
            scanner.nextLine();

        }

        return lineCount;

    }

    public static int[] readFileIntoArray(String nameOfFile) throws FileNotFoundException {

        int linesInFile = countLines(nameOfFile);
        int[] array = new int[linesInFile];

        int index = 0;

        File file = new File(nameOfFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            array[index++] = scanner.nextInt();

        }

        return array;
    }
    public static String[] readFileIntoStringArray(String nameOfFile) throws FileNotFoundException {

        int linesInFile = countLines(nameOfFile);
        String[] array = new String[linesInFile];

        int index = 0;

        File file = new File(nameOfFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            array[index++] = scanner.nextLine();

        }

        return array;
    }


    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */


    public static int challengeOne(String fileName) throws IOException {
        int[] newArray = readFileIntoArray(fileName);
        int count = 0;
        for (int i = 0; i < newArray.length-2;i++){
            if (newArray[i]<newArray[i+1]){
                count++;
            }
        }
        return count;
    }



    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int count = 0;
        int[]newArray = readFileIntoArray(fileName);

        for (int i = 0; i < newArray.length-3;i++){
            int first = newArray[i] + newArray[i+1] + newArray [i+2];
            int second = newArray[i+1] + newArray[i+2] + newArray[i+3];
            if (first<second){
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
       String[] newArray = readFileIntoStringArray(fileName);
        int forward = 0;
        int depth = 0;
        int lll = 0;
        int ll = 0;
        for (int i = 0; i < newArray.length;i++){
            if (newArray[i].contains("forward")){
                 forward = forward + Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length()));;
            }
            if (newArray[i].contains("down")){
                depth = depth + Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length()));
            }
            if (newArray[i].contains("up")){
                depth = depth - Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length()));;
            }
            lll = (int)newArray[0].charAt(newArray[0].length()-1);
            ll = newArray[1].length();

        }
        int total = depth * forward;
        return total;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        String[] newArray = readFileIntoStringArray(fileName);
        int forward = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < newArray.length;i++){
            if (newArray[i].contains("forward")){
                forward = forward + Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length()));
                depth = depth + (aim * Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length())));
            }
            if (newArray[i].contains("down")){
                aim = aim + Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length()));

            }
            if (newArray[i].contains("up")){
                aim = aim - Integer.parseInt(newArray[i].substring(newArray[i].length()-1,newArray[i].length()));
            }
        }
            int total = depth * forward;
            return total;
        }
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    /**private static void writeFileAllAnswers(String outPutFileName, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }


    /** This method will read the values in inputFileName into an array of integers, which it will return.
     * Do not edit this method.

    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.

    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
     */


