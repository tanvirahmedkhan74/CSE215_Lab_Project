package com.nsu.meet.nsu.service;

import com.nsu.meet.nsu.dto.HashTagDto;
import com.nsu.meet.nsu.model.HashTag;
import com.nsu.meet.nsu.repository.HashTagRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class HashTagService {
    private final HashTagRepository hashTagRepository;
    @Transactional
    public HashTagDto save(HashTagDto hashTagDto){
        HashTag save = hashTagRepository.save(mapHashTagDto(hashTagDto));
        hashTagDto.setId(save.getId());
        return hashTagDto;
    }

    private HashTag mapHashTagDto(HashTagDto hashTagDto) {
       return HashTag.builder().name(hashTagDto.getName())
                .description(hashTagDto.getDescription())
                .build();
    }
    @Transactional(readOnly = true)
    public List<HashTagDto> getAll() {
        return hashTagRepository.findAll().stream().map(this::maptToDto).collect(Collectors.toList());
    }

    private HashTagDto maptToDto(HashTag hashTag) {
        return HashTagDto.builder().name(hashTag.getName()).id(hashTag.getId()).numOfPosts(hashTag.getPosts().size()).build();
    }
}
