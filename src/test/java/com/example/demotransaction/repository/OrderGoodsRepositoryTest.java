package com.example.demotransaction.repository;

import com.example.demotransaction.domain.entity.Goods;
import com.example.demotransaction.domain.entity.OrderGoods;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderGoodsRepositoryTest {

    @Autowired
    private OrderGoodsRepository orderGoodsRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @BeforeAll
    void before(){
        //init
//        goodsRepository.deleteAll();
//        orderGoodsRepository.deleteAll();
        for (int i = 0; i < 10 ; i++) {
            Goods goodsItem =
                    Goods.builder()
                            .goodsCode(String.format("%06d",i+1))
                            .goodsName(String.format("드래곤볼-%s",i+1))
                            .goodsPrice(3000)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();
            goodsRepository.save(goodsItem);
        }
//        IntStream.range(1, 10).forEach(i -> {
//            Goods goodsItem =
//                    Goods.builder()
//                            .goodsCode(String.format("%06d",i+1))
//                            .goodsName(String.format("드래곤볼-%s",i+1))
//                            .goodsPrice(3000)
//                            .createdAt(LocalDateTime.now())
//                            .updatedAt(LocalDateTime.now())
//                            .build();
//            goodsRepository.save(goodsItem);
//        });
    }


    @Test
    @Order(1)
    void save(){
        String goodsCode = "000001";
        Optional<Goods> optGoods = goodsRepository.findGoodsByGoodsCode(goodsCode);
        Assertions.assertNotNull(true);
//
        OrderGoods orderGoods =
                OrderGoods.builder()
                        .orderGoodsPrice(3000)
                        .orderId(1)
                        .goods(optGoods.get())
                        .build();

        OrderGoods result = orderGoodsRepository.saveAndFlush(orderGoods);

        Assert.notNull(result, "결과값이 정상적으로 저장안됨.");
    }

}