package com.example.demotransaction.domain.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GoodsTest {

    @Test
    @DisplayName("빈값 Builder Test")
    public void emptiy_builder(){
        //when

        //then
        Goods goods = Goods.builder().build();
//
//        System.out.println(Goods.builder().toString());
        //given
        Assert.isNull(goods.getGoodsName(),"상품 이름 정상 null 이 아닙니다.");
        Assert.isNull(goods.getGoodsCode(),"상품 코드 정상 null 이 아닙니다.");
        Assert.isNull(goods.getGoodsPrice(),"상품 가격 정상 null 이 아닙니다.");
        Assert.isNull(goods.getCreatedAt(),"상품 생성일 null 이 아닙니다.");
        Assert.isNull(goods.getUpdatedAt(),"상품 수정일 null 이 아닙니다.");

    }

    @Test
    @DisplayName("값 생성 Builder Test")
    public void existence_value_builder(){
        //when
        String  goodsCode  = "00100";
        String  goodsName  = "드래곤볼";
        Integer goodsPrice = 3000;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        //given
        Goods newGoods =
                Goods.builder()
                        .goodsCode(goodsCode)
                        .goodsName(goodsName)
                        .goodsPrice(goodsPrice)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build();

        //then
        Assertions.assertThat(newGoods.getGoodsCode()).isEqualTo(goodsCode);
        Assertions.assertThat(newGoods.getGoodsPrice()).isEqualTo(goodsPrice);
        Assertions.assertThat(newGoods.getGoodsName()).isEqualTo(goodsName);
        Assertions.assertThat(newGoods.getCreatedAt()).isEqualTo(createdAt);
        Assertions.assertThat(newGoods.getUpdatedAt()).isEqualTo(updatedAt);

    }

    @Test
    @DisplayName("생성자 and builder test")
    public void builder_construct_test(){
        //when
        String  goodsCode  = "00100";
        String  goodsName  = "드래곤볼";
        Integer goodsPrice = 3000;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        //given
        Goods builderGoods =
                Goods.builder()
                        .goodsCode(goodsCode)
                        .goodsName(goodsName)
                        .goodsPrice(goodsPrice)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build();

        Goods constructGoods = new Goods(null, goodsCode, goodsName, goodsPrice, createdAt, updatedAt);

        //then
        Assertions.assertThat(builderGoods.getGoodsCode()).isEqualTo(constructGoods.getGoodsCode());
        Assertions.assertThat(builderGoods.getGoodsPrice()).isEqualTo(constructGoods.getGoodsPrice());
        Assertions.assertThat(builderGoods.getGoodsName()).isEqualTo(constructGoods.getGoodsName());
        Assertions.assertThat(builderGoods.getCreatedAt()).isEqualTo(constructGoods.getCreatedAt());
        Assertions.assertThat(builderGoods.getUpdatedAt()).isEqualTo(constructGoods.getUpdatedAt());
    }
}

