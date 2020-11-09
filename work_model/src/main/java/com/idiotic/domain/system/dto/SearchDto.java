package com.idiotic.domain.system.dto;

import lombok.Data;

@Data
public class SearchDto {
    private String search;
    private Integer page = 1;
    private Integer pageSize = 20;
}
