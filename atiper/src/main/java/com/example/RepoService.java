package com.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepoService {

    private  String siteURL = "https://api.github.com/users/";
    private String siteConfiguration = "/repos";
    RepoService(){        
    }
    
    public String getReposList(String userName) throws IOException {
        
        URL url = new URL(siteURL+userName+siteConfiguration);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if(responseCode!=HttpURLConnection.HTTP_OK){
            System.out.println("status: " + responseCode);
            String responseMessage = connection.getResponseMessage();
            System.out.println("message: " + responseMessage);
            return null;
        }else{
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) 
            {
                response.append(inputLine);
            }
            
            in.close();
            return response.toString();
        }
        

    } 

    public String getBranches(String urlString) throws IOException
    {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if(responseCode==HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) 
            {
                response.append(inputLine);
            }
            
            in.close();
            return response.toString();
        }
        return null;
    }

}
