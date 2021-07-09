package com.example.demotransaction.domain.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "goods")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public void changeBaseInfo(String goodsName,Integer goodsPrice){
            this.goodsName = goodsName;
            this.goodsPrice = goodsPrice;
            this.updatedAt = LocalDateTime.now();
    }


}
