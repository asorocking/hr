package com.asorokin;

public interface ArticleService {
    
    abstract String getJSON(int id);
    abstract String uploadToServer(int id);
    
}
