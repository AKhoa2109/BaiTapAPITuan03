package com.android.APILogin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Category  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;

    String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Document> documents;
}
