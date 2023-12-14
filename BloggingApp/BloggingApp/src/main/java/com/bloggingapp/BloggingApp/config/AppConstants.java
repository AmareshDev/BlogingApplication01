package com.bloggingapp.BloggingApp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppConstants {   //THIS CLASS IS FOR GOOD PRACTICE    2.IF WE WANT TO CHANGE DATA THEN WE CAN ESSYLY IN THIS CLASS
    public static final String PAGE_NUMBER="0";
    public static final String PAGE_SIZE="10";
    public static final String SORT_BY="postId";
    public static final String SORT_DIR="asc";

}
