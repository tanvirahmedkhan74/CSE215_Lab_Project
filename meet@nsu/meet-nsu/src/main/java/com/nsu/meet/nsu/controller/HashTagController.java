package com.nsu.meet.nsu.controller;

import com.nsu.meet.nsu.dto.HashTagDto;
import com.nsu.meet.nsu.service.HashTagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hashtag")
@AllArgsConstructor
@Slf4j
public class HashTagController {
    private final HashTagService hashTagService;

    @PostMapping
    public ResponseEntity<HashTagDto> createHashtag(@RequestBody HashTagDto hashTagDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hashTagService.save(hashTagDto));
    }

    @GetMapping
    public ResponseEntity<List<HashTagDto>> getAllHashTag(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hashTagService.getAll());
    }
}
