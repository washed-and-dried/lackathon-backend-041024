package com.lackatree.LackATree.controller;

import com.lackatree.LackATree.models.PaginatedResponse;
import com.lackatree.LackATree.models.TreeEntry;
import com.lackatree.LackATree.service.TreeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")

@Tag(name = "Tree")

@RequiredArgsConstructor
public class TreeController {
    private final TreeService treeService;

    @PostMapping
    public TreeEntry createTreeEntry(@RequestBody TreeEntry treeEntry) {
        return this.treeService.createTreeEntry(treeEntry);
    }

    @GetMapping("/all")
    public List<TreeEntry> getTreeEntries() {
        return this.treeService.getTreeEntry();
    }

    @GetMapping
    public PaginatedResponse<TreeEntry> getTreeEntries(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "") String sortBy,
            @RequestParam(required = false, defaultValue = "false") boolean descending,
            @RequestParam(required = false, defaultValue = "") String country
    ) {
        return this.treeService.getTreeEntry(pageNumber, sortBy, descending, country);
    }
}
