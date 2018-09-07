package com.TacoCloud.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.TacoCloud.TacoCloud.Domain.Entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
