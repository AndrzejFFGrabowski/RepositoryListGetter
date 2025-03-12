package com.example;

import java.util.Scanner;

public class RepositoryList {
    public void createRepositoryList(){
        RepoService repoService = new RepoService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter User Name:");
        try{
        String userName = scanner.nextLine();
        scanner.close();
        String response = repoService.getReposList(userName);
        if(response!=null){
            JsonOperation jsonOperation = new JsonOperation();
            jsonOperation.createJsonFile(response);
        }
        }catch(Exception e){}
    }
}
