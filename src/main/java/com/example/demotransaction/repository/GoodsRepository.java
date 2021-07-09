package com.example.demotransaction.repository;

import com.example.demotransaction.domain.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    Optional<Goods> findGoodsByGoodsCode(String goodsCode);
}
