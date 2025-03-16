package com.local.latihan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PagingResponse {

    private Integer currentPage;

    private Integer TotalPages;

    private Integer size;
}
