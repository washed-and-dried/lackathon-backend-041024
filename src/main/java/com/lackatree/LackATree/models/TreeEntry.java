package com.lackatree.LackATree.models;

import com.lackatree.LackATree.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tree_entries")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Country country;
    private Long numberOfTrees;
    private Date day;
    private String plantedBy;
}
