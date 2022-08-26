package com.campus.meet.NSU.controller;

import com.campus.meet.NSU.dto.HashtagDto;
import com.campus.meet.NSU.service.HashtagService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hashtag")
@AllArgsConstructor
@CrossOrigin
public class HashtagController {

    private final HashtagService hashtagService;

    @GetMapping
    public ResponseEntity<List<HashtagDto>> getAllHashtags() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hashtagService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashtagDto> getHashtag(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hashtagService.getHashtag(id));
    }

    @PostMapping
    public ResponseEntity<HashtagDto> create(@RequestBody HashtagDto hashtagDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(hashtagService.save(hashtagDto));
    }
}
