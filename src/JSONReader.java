/**
 *  JSONReader reads the content of a json object
 *  and parses the data to string format. The class
 *  has static constants that define which particular
 *  indices and values are needed from the object.
 *
 *  @author Eoin Halligan
 *  @version Project 1
 */

import javax.json.JsonArray;
import javax.json.JsonObject;
public class JSONReader {
    // constants to define the parse of json
    private static final String ROUTES = "routes";
    private static final String LEGS = "legs";
    private static final String DISTANCE = "distance";
    private static final String END_ADDRESS = "end_address";
    private static final String TEXT = "text";
    private static final String DURATION = "duration";
    private static final int INDEX = 0;
    // the json object, and its values
    private JsonObject obj;
    private String[] values;

    /**
     * JSONReader constructor.
     * @param obj a jsonObject
     */
    public JSONReader(JsonObject obj) {
        this.obj = obj;
        values = new String[3];
        // init
        try {
            init();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     *  init
     *  Gets the json object with the constant specifications
     *  and returns them to a JsonValue[]
     */
    private void init() throws NullPointerException {
        // [route:[legs:[distance:{text, val}]]];
        // get route
        if(obj != null) {
            JsonArray routes = obj.getJsonArray(ROUTES);
            // get legs
            JsonArray legs = routes.getJsonObject(INDEX).getJsonArray(LEGS);
            // get distance
            JsonObject data = legs.getJsonObject(INDEX).getJsonObject(DISTANCE);

            JsonObject duration = legs.getJsonObject(INDEX).getJsonObject(DURATION);
            // init array
            values[0] = data.get(TEXT).toString();
            values[1] = legs.getJsonObject(INDEX).get(END_ADDRESS).toString();
            values[2] = duration.get(TEXT).toString();
            // print it...
            System.out.println(values[1] + " Travel time: " + values[2]);
        } else {
            // throw exception
            throw new NullPointerException("No Internet Connection");
        }

    }

    /**
     * getValues returns values
     * @return values a JsonValue[]
     */
    public String[] getValues() {
        return values;
    }


}
