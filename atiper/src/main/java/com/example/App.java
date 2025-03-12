package com.example;

import java.io.IOException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    public static void main(String[] args) {
        RepoService repoService = new RepoService();
        RepositoryList repositoryList = new RepositoryList();
        repositoryList.createRepositoryList();

        }

}
