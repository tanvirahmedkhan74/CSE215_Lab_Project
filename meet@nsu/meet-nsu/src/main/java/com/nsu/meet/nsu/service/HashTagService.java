package com.nsu.meet.nsu.service;

import com.nsu.meet.nsu.dto.HashTagDto;
import com.nsu.meet.nsu.exceptions.MeetNsuAuthException;
import com.nsu.meet.nsu.mapper.HashTagMapper;
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
    private final HashTagMapper hashTagMapper;
    @Transactional
    public HashTagDto save(HashTagDto hashTagDto){
        HashTag save = hashTagRepository.save(hashTagMapper.mapDtoToHashTag(hashTagDto));
        hashTagDto.setId(save.getId());
        return hashTagDto;
    }

    @Transactional(readOnly = true)
    public List<HashTagDto> getAll() {
        return hashTagRepository.findAll().stream().map(hashTagMapper::mapHashTagToDto).collect(Collectors.toList());
    }

    public HashTagDto  getHashTag(Long id) {
        HashTag hashTag = hashTagRepository.findById(id).orElseThrow(
                ()-> new MeetNsuAuthException("This HashTag has not been created Yet!")
        );
        return hashTagMapper.mapHashTagToDto(hashTag);
    }
}
