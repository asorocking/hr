package com.asorokin;

import java.util.Map;

public interface ArticleService {
    
    abstract String getJSON(int id);
    abstract String uploadToServer(int id);
    
    
}
