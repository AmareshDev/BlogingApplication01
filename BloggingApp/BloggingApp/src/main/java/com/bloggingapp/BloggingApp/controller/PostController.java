package com.bloggingapp.BloggingApp.controller;

import com.bloggingapp.BloggingApp.config.AppConstants;
import com.bloggingapp.BloggingApp.dto.PostDto;
import com.bloggingapp.BloggingApp.entity.Post;
import com.bloggingapp.BloggingApp.payloads.ApiResponse;
import com.bloggingapp.BloggingApp.payloads.PostResponse;
import com.bloggingapp.BloggingApp.service.FileService;
import com.bloggingapp.BloggingApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Value("${project.image}")
    private  String path;

    @Autowired
    private FileService fileService;
    @Autowired
    private PostService postService;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        System.err.println("heo");
        PostDto createdPost=this.postService.createPost(postDto,userId,categoryId);
          return new ResponseEntity<PostDto>( createdPost, HttpStatus.CREATED);

    }
    @PutMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>>getPostByUser(@PathVariable Integer userId){
        List<PostDto> posts=this.postService.getPostsByUSer((userId));
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>>getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts=this.postService.getPostByCategory((categoryId));
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }
    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(@RequestParam(value="pageNumber",defaultValue= AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
                                                   @RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required = false)Integer pageSize ,
                                                   @RequestParam(value="sortBy", defaultValue=AppConstants.SORT_BY, required = false)String sortBy,
                                                   @RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR, required=false)String sortDir){

        PostResponse allPosts=this.postService.getAllPost(pageNumber,pageSize, sortBy,sortDir);
        return new ResponseEntity <PostResponse>(allPosts, HttpStatus.OK);
    }
    //get single post
    @GetMapping("/posts/{postId}")
    public ResponseEntity< PostDto >getSinglePost(@PathVariable Integer postId){
       PostDto spost = this.postService.getSinglePost(postId);
        return  new ResponseEntity <PostDto>(spost,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{postId}")
    public ApiResponse deleteById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("post is deleted!!",true);
    }
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId ){
      PostDto updatePost=  this.postService.updatePost (postDto,postId);
      return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }
    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDto>>searchPostByTitle(@PathVariable("keyword")String keywords){
       List<PostDto>result= this.postService.searchPosts(keywords);
       return new ResponseEntity<>(result,HttpStatus.OK);
    }
    //post image uploads
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto>uploadPostImage(@RequestParam("image")MultipartFile image,
    @PathVariable Integer postId) throws IOException {
        PostDto postDto=this.postService.getSinglePost(postId);
        String fileName=this.fileService.uploadImage(path,image);

         postDto.setImageName(fileName);
         PostDto updatePost=this.postService.updatePost(postDto,postId);
         return new ResponseEntity<>(updatePost,HttpStatus.OK);

    }
}
