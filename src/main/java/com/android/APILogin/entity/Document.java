package com.android.APILogin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @Column(length = 500,columnDefinition = "nvarchar(500) not null")
    private String documentName;

    @Column(columnDefinition ="nvarchar(500) not null")
    private String documentDescription;

    @Column(nullable = false)
    private Integer page;

    @Column(nullable = false, length = 1000)
    private String documentImage;

    @Column(nullable = false)
    private Double sell_price;

    @Column(nullable = false)
    private Double original_price;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private Integer view;

    @Column(nullable = false)
    private Integer download;

    @Column(nullable = false)
    private String type;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
