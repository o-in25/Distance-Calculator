/**
 *  Static class. Holds a static map, which is consistent
 *  through every static call of this class. Collections
 *  simply sorts a given array via merge sort, and
 *  holds a map for the results to be populated in. There
 *  is no need for any instance of this class, and is hence
 *  static.
 *
 *  @author Eoin Halligan
 *  @version Project 1
 */

import java.util.HashMap;
public class Collections {

    // holds a static map, as the object's prototype to which the sorted contents
    // will be mapped to
    private static HashMap<Integer, String> map = new HashMap<Integer, String>();


    /**
     * sort merge sorts the locations array, in
     * ascending order via a static call.
     *
     * @param previous the unsorted array
     * @return the newly sorted array
     */
    public static int[] sort(int[] previous) {
        // declare...
        int i, j, first, temp;
        for(i = previous.length - 1; i > 0; i--) {
            // initialize to subscript of first element
            first = 0;
            for(j = 1; j <= i; j++) {
                // locate smallest element between positions 1 and i
                if(previous[j] < previous[first]) {
                    first = j;
                }
            }
            // swap smallest found with element in position i
            temp = previous[first];
            previous[first] = previous[i];
            previous[i] = temp;
        }
        return previous;
    }



    /**
     * map puts the contents of the parameters into the
     * map via a static call
     * @param key the int representation of the distance
     * @param val the string representation of the location
     */
    public static void map(int key, String val) {
        map.put(key, val);
    }

    /**
     * getMap returns the static map
     * @return map the static map
     */
    public static HashMap<Integer, String> getMap() {
        return map;
    }
}
