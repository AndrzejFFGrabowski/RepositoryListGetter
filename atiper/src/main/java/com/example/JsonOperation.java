package com.example;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonOperation {
    RepoService repoService = new RepoService();

    public void createJsonFile(String jsonString){
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(jsonObject.getBoolean("fork")==false){
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.print("Repository name: "+jsonObject.getString("name"));
                System.out.println("  |   Owner login  "+jsonObject.getJSONObject("owner").getString("login"));
                try{
                    String branchUrl = jsonObject.getString("branches_url");
                    String branchesJsonString = repoService.getBranches(branchUrl.substring(0,branchUrl.length()-9));
                    writeBranches(branchesJsonString,jsonObject.getString("name"));
                }catch(Exception e){}
            }
        }
    }

    private void writeBranches(String jsonString,String repoName) throws JSONException, IOException{
        JSONArray jsonArray = new JSONArray(jsonString);
        System.out.println("Branches of "+repoName+":");
        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.print(jsonObject.getString("name"));
            System.out.println("  last commit sha: "+jsonObject.getJSONObject("commit").getString("sha"));
        }
    }
}
