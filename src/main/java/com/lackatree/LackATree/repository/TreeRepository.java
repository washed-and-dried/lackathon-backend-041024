package com.lackatree.LackATree.repository;

import com.lackatree.LackATree.enums.Country;
import com.lackatree.LackATree.models.TreeEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TreeRepository extends JpaRepository<TreeEntry, Long> {
    @Query("SELECT t FROM TreeEntry t WHERE t.country = :country OR :country IS NULL")
    Page<TreeEntry> findByState(@Param("country") Country country, Pageable pageable);
}
