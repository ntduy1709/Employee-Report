package com.ifi.employeereportbe.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RESTInvoker {

    public static final String USER_AGENT = "Mozilla/5.0";
    public final String baseUrl;
    public final String username;
    public final String password;

    public RESTInvoker(String baseUrl, String username, String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
    }

    private HttpURLConnection setUsernamePassword(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        String authString = username + ":" + password;
        String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
        urlConnection.setRequestProperty("Authorization", "Basic" + authStringEnc);
        return urlConnection;
    }

    public String getDataFromSever(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(baseUrl + path);
            URLConnection urlConnection = setUsernamePassword(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String postDataToServer(String path, Object input) throws Exception{
        URL url = new URL(baseUrl + path);
        HttpURLConnection connection = setUsernamePassword(url);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-agent", USER_AGENT);

        ObjectMapper mapper = new ObjectMapper();
        String inputJson = null;
        inputJson = mapper.writeValueAsString(input);

        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(inputJson.getBytes());
        outputStream.flush();
        outputStream.close();

        int responseCode = connection.getResponseCode();
        System.out.println("POST response code :: " +responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return null;
        }
    }
}
