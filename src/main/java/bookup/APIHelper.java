package bookup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

/** Provides methods for interacting with the OpenLibrary API */
class APIHelper {

    /** Returns a Book object with data of the book specified by the ISBN.
     * The data is obtained form a book API.
     */
    static void get(String ISBN) throws IOException {
        URL urlForGetRequest = new URL(String.format("https://openlibrary.org/api/books?bibkeys=ISBN:%s&jscmd=data", ISBN));
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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
        Gson gson = new Gson();
//        gson.fromJson(response.toString(), Book.class);
    }
}