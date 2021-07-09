package com.example.demotransaction.repository;

import com.example.demotransaction.domain.entity.Goods;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoodsRepositoryTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @BeforeAll
    void before(){
        //init
        goodsRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("step1:상품저장")
    void step1_goods_save(){
        //given
        String  goodsCode  = "00100";
        String  goodsName  = "드래곤볼";
        Integer goodsPrice = 3000;
        Goods newGoods =
                Goods.builder()
                        .goodsId(null)
                        .goodsCode(goodsCode)
                        .goodsName(goodsName)
                        .goodsPrice(goodsPrice)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                .build();

        //when
        Goods result = goodsRepository.save(newGoods);

        //then
        Assert.notNull(result, "결과값이 정상적으로 저장안됨.");
        Assert.notNull(result.toString(), "결과값이 정상적으로 저장안됨.");
        Assert.notNull(result.getGoodsId(),"ID 생성 안됨.");
        Assertions.assertThat(result.getGoodsPrice()).isEqualTo(goodsPrice);
        Assertions.assertThat(result.getGoodsPrice()).isEqualTo(goodsPrice);
        Assertions.assertThat(result.getCreatedAt()).isEqualTo(newGoods.getCreatedAt());
        Assertions.assertThat(result.getGoodsName()).isEqualTo(goodsName);
    }

    @Test
    @Order(2)
    @DisplayName("step2: 상품코드로 상품 조회")
    void step2_goods_code_search(){
        //given
        String goodsCode = "00100";

        //when
        Optional<Goods> optGoods = goodsRepository.findGoodsByGoodsCode(goodsCode);

        //then
        Assertions.assertThat(optGoods)
                .isPresent()
                .get()
                .extracting(Goods::getGoodsCode)
                .isEqualTo(goodsCode);
    }

    @Test
    @Order(3)
    @DisplayName("step3: 상품이름 수정")
    void step3_goodsName_update(){
        //given
        String goodsCode = "00100";
        Goods goods = goodsRepository.findGoodsByGoodsCode(goodsCode).get();
        Integer goodsPrice = 40000;
        //when
        goods.changeBaseInfo("드래곤볼-1수정",goodsPrice);

        Goods result = goodsRepository.save(goods);

        Assertions.assertThat(goods.getGoodsId()).isEqualTo(result.getGoodsId());
        Assertions.assertThat(goods.getGoodsName()).isEqualTo(result.getGoodsName());
        Assertions.assertThat(goods.getUpdatedAt().isBefore(result.getUpdatedAt()));
        Assertions.assertThat(goods.getGoodsPrice()).isEqualTo(goodsPrice);

    }

    @Test
    @Order(4)
    @DisplayName("step4: 상품 삭제")
    void step4_goods_delete(){
        //given
        String goodsCode = "00100";
        Optional<Goods> optGoods = goodsRepository.findGoodsByGoodsCode(goodsCode);

        //when
        goodsRepository.delete(optGoods.get());

        //then
        Optional<Goods> delGoods = goodsRepository.findGoodsByGoodsCode(goodsCode);

        Assertions.assertThat(delGoods)
                .isEmpty()
                .as("-> 해당상품이 삭제되지않았습니다.goodsCode=%s",goodsCode);
    }

}