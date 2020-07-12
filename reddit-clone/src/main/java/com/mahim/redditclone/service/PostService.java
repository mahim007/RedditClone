package com.mahim.redditclone.service;

import com.mahim.redditclone.dto.PostRequestDto;
import com.mahim.redditclone.dto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {
    public void save(PostRequestDto postRequestDto) {
    }

    public PostResponseDto getPost(Long id) {
        return null;
    }

    public List<PostResponseDto> getAllPosts() {
        return null;
    }

    public List<PostResponseDto> getPostBySubreddit(Long id) {
        return null;
    }

    public List<PostResponseDto> getPostsByUsername(String username) {
        return null;
    }
}
