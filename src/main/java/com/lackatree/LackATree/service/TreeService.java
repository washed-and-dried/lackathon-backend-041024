package com.lackatree.LackATree.service;

import com.lackatree.LackATree.enums.Country;
import com.lackatree.LackATree.models.PaginatedResponse;
import com.lackatree.LackATree.models.TreeEntry;
import com.lackatree.LackATree.repository.TreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreeService {
    private final TreeRepository treeRepository;

    public TreeEntry createTreeEntry(TreeEntry treeEntry) {
        return this.treeRepository.save(treeEntry);
    }

    public List<TreeEntry> getTreeEntry() {
        return this.treeRepository.findAll();
    }

    public PaginatedResponse<TreeEntry> getTreeEntry(int pageNumber, String sortBy, boolean descending, String country) {
        Pageable pageable = this.getPageable(pageNumber, sortBy, descending);
        Page<TreeEntry> result;

        result = this.treeRepository.findByState(Country.fromValue(country), pageable);

        return this.mapPaginatedResponse(result);
    }


    public Pageable getPageable(int pageNumber, String sortBy, boolean descending) {
        Pageable pageable;
        if (sortBy.isBlank()) {
            pageable = descending ? PageRequest.of(pageNumber, 5, Sort.by("createdDate").descending()) : PageRequest.of(pageNumber, 5);
        } else {
            pageable = descending ? PageRequest.of(pageNumber, 5, Sort.by(sortBy).descending()) : PageRequest.of(pageNumber, 5, Sort.by(sortBy));
        }
        return pageable;
    }

    public <T> PaginatedResponse<T> mapPaginatedResponse(Page<T> result) {
        PaginatedResponse<T> response = PaginatedResponse.<T>builder().result(result.getContent()).currentPage(result.getNumber()).pageSize(result.getNumberOfElements()).totalPages(result.getTotalPages()).totalRecords(result.getTotalElements()).build();

        return response;
    }
}
