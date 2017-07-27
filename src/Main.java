/**
 *  The main class is the "glue" of the program.
 *  It calls the necessary functions/constructors to
 *  initialize and populate data (to which, the other classes
 *  handle), and prints the results. This class does not hold
 *  any data, but rather simply handles it
 *
 *  @author Eoin Halligan
 *  @version Project 1
 */

import java.util.ArrayList;
import java.util.HashMap;
public class Main {

    // the unique API key
    private static final String KEY = "key=AIzaSyBX5LxpVvshWuXcfIJczt8NksMsfIKEODo";
    private static String path;
    // the starting locations
    private static String origin;

    // main method
    public static void main(String[] args) {
        // if there are no arguments, use
        // the defaults
        if(args.length == 0) {
            path = "/Users/o_in25/Desktop/test.txt";
        } else {
            path = args[0];
        }
        origin = "Cincinnati, OH";
        // let's gooooo....
        init();
    }

    /**
     *  init calls the necessary functions to run the program
     */
    private static void init() {
        System.out.println("Gathering data...");
        // constructs a urlBuilder object, which constructs a new url
        // with a destination and location, plus the API key
        // builder will fill strings
        Reader pathReader = new Reader(path);
        ArrayList<String> locations = pathReader.getLocations();
        // collection of urls from file,
        // which will not exceed the amount of locations
        URLBuilder[] urls = new URLBuilder[locations.size()];
        // helper variable
        int len = urls.length;
        // the integer values of the json object
        int[] jsonIntValues = new int[len];
        // new json readers, which will keep any
        // relevant data associated with the object
        // (in the case of this project, the travel
        // times)
        JSONReader[] readers = new JSONReader[len];
        // populate the data

        for(int i = 0; i < len; i++) {
            // initalizes each element in the url array to a new
            // url object, to which, the reader will use the data
            urls[i] = new URLBuilder(origin, locations.get(i), KEY);
             // get the data
            readers[i] = new JSONReader(new Connection(urls[i].getURL()).getJsonObject());
            // helper variable
            // gets the 0th index of the array
            String temp = readers[i].getValues()[0];
            // remove the quotes from the string, and get the integer values
            // with a regex
            jsonIntValues[i] = Integer.parseInt(0 + temp.replaceAll("\\D+",""));

            Collections.map(jsonIntValues[i], readers[i].getValues()[1]);
        }
        System.out.println("Done.");
        // print the data
        print(jsonIntValues);

    }

    /**
     * print sorts the contents of an array, and then prints it
     * @param array an array to be sorted
     */
    private static void print(int[] array) {
        System.out.println("Sorting...");
        // sort the array
        int[] newlySorted = Collections.sort(array);
        int j = 0;
        System.out.println("Done.");
        System.out.println("Sorted travel times:");
        System.out.println("Distance from " + origin + "... ");
        // get the map
        HashMap<Integer, String> map = Collections.getMap();
        // for each element in the newly
        // sorted array
        while(j < newlySorted.length) {
            System.out.println(map.get(newlySorted[j]) + ": " + newlySorted[j] + " miles");
            // increment
            j++;
        }
    }


}
