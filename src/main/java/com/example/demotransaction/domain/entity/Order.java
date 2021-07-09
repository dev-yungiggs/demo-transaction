package com.example.demotransaction.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "order_user")
    private String orderUser;

//    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
//    @JoinColumn(name="order_goods_id")
//    private Collection<OrderGoods> orderGoods;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
