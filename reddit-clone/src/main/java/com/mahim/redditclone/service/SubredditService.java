package com.mahim.redditclone.service;

import com.mahim.redditclone.dto.SubredditDto;
import com.mahim.redditclone.exception.SpringRedditException;
import com.mahim.redditclone.mapper.SubredditMapper;
import com.mahim.redditclone.model.Subreddit;
import com.mahim.redditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Optional<Subreddit> optionalSubreddit = subredditRepository.findById(id);
        Subreddit subreddit = optionalSubreddit.orElseThrow(() -> new SpringRedditException("No Subreddit found with id: " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}
