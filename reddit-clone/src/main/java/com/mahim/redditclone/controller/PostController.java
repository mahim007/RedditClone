package com.mahim.redditclone.controller;

import com.mahim.redditclone.dto.PostRequestDto;
import com.mahim.redditclone.dto.PostResponseDto;
import com.mahim.redditclone.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostRequestDto postRequestDto) {
        postService.save(postRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/")
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/by-subreddit/{id}")
    public List<PostResponseDto> getPostBySubreddit(Long id) {
        return postService.getPostBySubreddit(id);
    }

    @GetMapping("/by-user/{name}")
    public List<PostResponseDto> getPostsByUsername(String username) {
        return postService.getPostsByUsername(username);
    }
}
