/**
 Sample program using the Google API and distancematrix
 Also provides an example of Java's JSON object

 @author Gary Lewandowski, appened by Eoin Halligan
 Fall 2016
 @version 10Aug2016
 **/

import javax.json.Json;
import javax.json.JsonObject;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

// class declaration
public class Connection {
    private JsonObject jsonObject;
    /**
     * GoogleTest constructor
     * @param urlString the googleapi string
     **/
    public Connection(String urlString) {
        URL url;
        // start try
        try {
            // construct a URL
            url = new URL(urlString);
            // open the connection across the network; receive the response
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            verify(connection.getResponseCode());
            // the InputStream is the data passed back from the url
            // the next three lines set up a way to read the data
            InputStream stream = connection.getInputStream();
            // create a new InputStreamReader to read the
            // content of stream
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader in = new BufferedReader(reader);
            // helper variable
            String inputLine;
            String jsonString = "";
            // while there is content in the input...
            while((inputLine = in.readLine()) != null) {
                // append the string
                jsonString += inputLine;
            }
            // prevent memory leak
            in.close();
            // method here
            jsonObject = CreateJSONObjectFromString(jsonString);
        }
        // start catch
        catch(Exception e) {
            Throwable[] thrown = e.getSuppressed();
            // print each thrown error
            for(Throwable element : thrown) {
                element.printStackTrace();
            }
        }

    }

    private boolean verify(int code) throws Exception {
        if(code != 200) {
            throw new Exception("Invalid Response Code");
        } else {
            // return...
            return false;
        }
    }

    /**
     *  getJsonObhect
     *  @return jsonObject a json object containing the data
     */
    public JsonObject getJsonObject() {
        return jsonObject;
    }

    /**
     * CreateJSONObjectFromString method signature
     * return the json object of the map data
     * @param string a string that represents a text json obect
     *
     */
    private JsonObject CreateJSONObjectFromString(String string) {
        // return the new json object
        return Json.createReader(new StringReader(string)).readObject();
    }

}
