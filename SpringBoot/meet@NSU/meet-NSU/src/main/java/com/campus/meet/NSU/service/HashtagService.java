package com.campus.meet.NSU.service;

import com.campus.meet.NSU.dto.HashtagDto;
import com.campus.meet.NSU.exception.MeetNsuException;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.repository.HashtagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class HashtagService {

    private final HashtagRepository hashtagRepository;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public List<HashtagDto> getAll() {
        return hashtagRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional
    public HashtagDto save(HashtagDto hashtagDto) {
        Hashtag hashtag = hashtagRepository.save(mapToHashtag(hashtagDto));
        hashtagDto.setId(hashtag.getId());
        return hashtagDto;
    }

    @Transactional(readOnly = true)
    public HashtagDto getHashtag(Long id) {
        Hashtag hashtag = hashtagRepository.findById(id)
                .orElseThrow(() -> new MeetNsuException("Subreddit not found with id -" + id));
        return mapToDto(hashtag);
    }

    private HashtagDto mapToDto(Hashtag hashtag) {
        return HashtagDto.builder().name(hashtag.getName())
                .id(hashtag.getId())
                .postCount(hashtag.getPosts().size())
                .build();
    }

    private Hashtag mapToHashtag(HashtagDto hashtagDto) {
        return Hashtag.builder().name("/h/" + hashtagDto.getName())
                .description(hashtagDto.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(now()).build();
    }
}