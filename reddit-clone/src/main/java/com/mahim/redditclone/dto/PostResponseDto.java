package com.mahim.redditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDto {
    private Long id;
    private String postName;
    private String url;
    private String description;
    private String userName;
    private String subredditName;
}
