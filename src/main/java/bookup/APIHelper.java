package bookup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** Provides methods for interacting with the OpenLibrary API */
class APIHelper {

    /** Returns a Book object with data of the book specified by the ISBN.
     * The data is obtained form a book API.
     */
    public static void get(String ISBN) throws IOException {
        URL urlForGetRequest = new URL(String.format("https://openlibrary.org/api/books?bibkeys=ISBN:%s", ISBN));
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println("JSON String Result: " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}