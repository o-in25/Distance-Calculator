/**
 *  Reader gets the contents of a file, reads
 *  the content, and puts the data into an ArrayList.
 *  The Reader object takes a string path as an argument. The reader
 *  is used to get the locations from a text file, to which,
 *  the rest of the program will use.
 *
 *  @author Eoin Halligan
 *  @version Project 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Reader {

    private Scanner scanner;
    private ArrayList<String> locations;

    /**
     * Reader constructor
     * Creates a new reader object, which will
     * return the contents of a file into an array
     * @param path the path of the file in string form
     */
    public Reader(String path) {
        // prevent FileNotFoundException
        try {
            scanner = new Scanner(new File(path));
            // initalize
            init();
        }
        // start catch
        catch(Exception e) {
            Throwable[] thrown = e.getSuppressed();
            // print each thrown error
            for (Throwable element : thrown) {
                element.printStackTrace();
            }
        }
    }

    /**
     * getLocations
     * Returns the array
     * @return locations an array of locations
     */
    public ArrayList<String> getLocations() {
        return locations;
    }

    public int getSize() {
        return locations.size();
    }

    /** init
     *  Initializes the locations array with the file
     *  contents
     */
    private void init() {
        locations = new ArrayList<>();
        // while the file has text...
        while(scanner.hasNext()) {
            String nextToken = scanner.nextLine();
            // add to array
            locations.add(nextToken);
        }
        // prevent leak
        scanner.close();
    }

}


