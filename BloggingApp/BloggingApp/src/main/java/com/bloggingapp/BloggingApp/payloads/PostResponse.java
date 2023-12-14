package com.bloggingapp.BloggingApp.payloads;

import com.bloggingapp.BloggingApp.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Component
public class PostResponse {
    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long TotalElements;
    private int totalPages;
    private boolean lastPage;

}
