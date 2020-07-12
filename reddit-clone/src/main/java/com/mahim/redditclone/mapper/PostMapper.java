package com.mahim.redditclone.mapper;

import com.mahim.redditclone.dto.PostRequestDto;
import com.mahim.redditclone.dto.PostResponseDto;
import com.mahim.redditclone.dto.SubredditDto;
import com.mahim.redditclone.model.AppUser;
import com.mahim.redditclone.model.Post;
import com.mahim.redditclone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post mapToPost(PostRequestDto postRequest, Subreddit subreddit, AppUser appUser);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "subredditName", source = "subreddit.name")
    PostResponseDto mapToDto(Post post);
}