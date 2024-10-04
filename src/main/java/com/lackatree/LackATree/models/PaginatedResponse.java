package com.lackatree.LackATree.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginatedResponse<T> {
    private List<T> result;
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalRecords;
}
