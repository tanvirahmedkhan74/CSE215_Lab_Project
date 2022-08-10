package com.campus.meet.NSU.controller;

import com.campus.meet.NSU.dto.HashtagDto;
import com.campus.meet.NSU.service.HashtagService;
import lombok.AllArgsConstructor;
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
    public List<HashtagDto> getAllHashtags() {
        return hashtagService.getAll();
    }

    @GetMapping("/{id}")
    public HashtagDto getHashtag(@PathVariable Long id) {
        return hashtagService.getHashtag(id);
    }

    @PostMapping
    public HashtagDto create(@RequestBody @Valid HashtagDto hashtagDto) {
        return hashtagService.save(hashtagDto);
    }
}
