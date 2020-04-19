package bookup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** Provides methods for interacting with the OpenLibrary API */
public class APIHelper {

    /** Returns a Book object with data of the book specified by the ISBN.
     * The data is obtained form a book API.
     */
    public static String getJson(String ISBN) throws IOException {
        URL urlForGetRequest = new URL(String.format("https://openlibrary.org/api/books?bibkeys=ISBN:%s&jscmd=data", ISBN));
        String readLine;
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

            return cleanResponse(response.toString());
        } else {
            throw new RuntimeException(String.format("HTTP request failed: %s", ISBN));
        }
    }

    private static String cleanResponse(String response) {
            return response.replaceFirst("ISBN:\\d+", "ISBN")
                .replaceFirst("var _OLBookInfo = ", "")
                .replace(";", "");
    }
}