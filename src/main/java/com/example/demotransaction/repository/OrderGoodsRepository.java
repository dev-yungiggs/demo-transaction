package com.example.demotransaction.repository;

import com.example.demotransaction.domain.entity.Order;
import com.example.demotransaction.domain.entity.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsRepository extends JpaRepository<OrderGoods,Integer> {
}
