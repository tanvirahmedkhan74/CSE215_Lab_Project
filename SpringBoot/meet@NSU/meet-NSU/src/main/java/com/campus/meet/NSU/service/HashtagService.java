package com.campus.meet.NSU.service;

import com.campus.meet.NSU.dto.HashtagDto;
import com.campus.meet.NSU.exception.MeetNsuException;
import com.campus.meet.NSU.mapper.HashtagMapper;
import com.campus.meet.NSU.model.Hashtag;
import com.campus.meet.NSU.repository.HashtagRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class HashtagService {

    private final HashtagRepository hashtagRepository;
    private final HashtagMapper hashtagMapper;

    @Transactional
    public HashtagDto save(HashtagDto hashtagDto) {
        Hashtag save = hashtagRepository.save(hashtagMapper.mapDtoToHashtag(hashtagDto));
        hashtagDto.setId(save.getId());
        return hashtagDto;
    }

    @Transactional(readOnly = true)
    public List<HashtagDto> getAll() {
        return hashtagRepository.findAll()
                .stream()
                .map(hashtagMapper::mapHashtagToDto)
                .collect(toList());
    }

    public HashtagDto getHashtag(Long id) {
        Hashtag hashtag = hashtagRepository.findById(id)
                .orElseThrow(() -> new MeetNsuException("No subreddit found with ID - " + id));
        return hashtagMapper.mapHashtagToDto(hashtag);
    }
}