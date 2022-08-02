package com.nsu.meet.nsu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HashTagDto {
    private Long id;
    private String name;
    public String description;
    public Integer numOfPosts;
}
