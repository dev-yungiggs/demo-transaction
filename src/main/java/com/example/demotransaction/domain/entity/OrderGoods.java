package com.example.demotransaction.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_goods")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderGoods {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_goods_id")
    private Integer orderGoodsId;

    @Column(name="order_id")
    private Integer orderId;

    @OneToOne
    @JoinColumn(name="goods_id")
    private Goods goods;

    @Column(name = "order_goods_price")
    private Integer orderGoodsPrice;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
