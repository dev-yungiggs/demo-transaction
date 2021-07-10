package com.example.demotransaction.domain.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "goods")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_code")
    private String goodsCode;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_price")
    private Integer goodsPrice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    private Goods(String goodsCode, String goodsName, Integer goodsPrice, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.goodsCode = goodsCode;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void changeBaseInfo(String goodsName,Integer goodsPrice){
            this.goodsName = goodsName;
            this.goodsPrice = goodsPrice;
            this.updatedAt = LocalDateTime.now();
    }


}
