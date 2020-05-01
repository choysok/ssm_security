package com.page.ssm.dao;

import com.page.ssm.domain.Traveller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerDao {
    List<Traveller> findByOrderId(String orderId) throws Exception;
}
