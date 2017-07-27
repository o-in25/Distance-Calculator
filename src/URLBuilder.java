/**
 *  The Google API URL needs a specific format to
 *  fetch the data. This class will create a URL object
 *  that will be parsed in a format that is usable.
 *
 *  @author Eoin Halligan
 *  @version Project 1
 */
public class URLBuilder
{
    private String[] formattedUrl;
    private String url;

    /**
     * URLBuilder constructor
     * @param origin an unformatted string origin
     * @param destination an unformatted string destination
     * @param key an unformatted string key
     */
    public URLBuilder(String origin, String destination, String key) {
        // init the url
        initUrl(origin, destination);
        // the url is the address the program will
        // use to get the json object
        url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + formattedUrl[0] + "&destination=" + formattedUrl[1] + "4&" + key;
    }

    /**
     * getUrl gets the formatted url
     * @return url the new url
     */
    public String getURL() {
        return url;
    }

    /**
     * initUrl. Initialized the url array to have 2
     * formatted String elements
     * @param origin the newly formatted origin
     * @param destination the formatted destination
     */
    private void initUrl(String origin, String destination ) {
        formattedUrl = new String[2];
        formattedUrl[0] = tokenizeString(origin);
        formattedUrl[1] = tokenizeString(destination);
    }


    /**
     * tokenizeString returns a formatted string in the
     * pattern the Google Maps API recognizes
     * @param string an unformatted string
     * @return a formatted string
     */
    private String tokenizeString(String string) {
        // because strings are immuatable, create a
        // string object for convince
        StringBuilder mutableString = new StringBuilder(string);
        // for the length of the string
        for(int i = 0; i < mutableString.length(); i++) {
            // replace all whitespaces with +
            if(mutableString.charAt(i) == ' ') {
                mutableString.setCharAt(i, '+');
                // if the string has a comma, replace the next space
            } else if(mutableString.charAt(i) == ',') {
                // avoid exception
                if(!(mutableString.indexOf(mutableString.toString(), i + 1) <= mutableString.length())) {
                    // skip it
                    continue;
                } else {
                    mutableString.deleteCharAt(i + 1);
                }
            }
        }
        // return the string
        return mutableString.toString();
    }




}
