package com.android.APILogin.entity;

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
@Table(name = "orders")
public class Order  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long order_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    LocalDateTime order_date;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    String note;

    @Column(nullable = false)
    String total_original_price;

    @Column(nullable = false)
    String total_sell_price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetail> orderDetails;

}
