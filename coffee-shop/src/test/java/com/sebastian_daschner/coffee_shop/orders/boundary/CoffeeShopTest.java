package com.sebastian_daschner.coffee_shop.orders.boundary;

import com.sebastian_daschner.coffee_shop.orders.control.OrderRepository;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import com.sebastian_daschner.coffee_shop.orders.entity.Order;
import com.sebastian_daschner.coffee_shop.orders.entity.Origin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class CoffeeShopTest {

    private CoffeeShop coffeeShop;

    @BeforeEach
    void setUp() {
        coffeeShop = new CoffeeShop();
        coffeeShop.orderRepository = mock(OrderRepository.class);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order(UUID.randomUUID(), CoffeeType.ESPRESSO, new Origin("Ethiopia"));
        coffeeShop.createOrder(order);
        verify(coffeeShop.orderRepository).persist(order);
        verifyNoMoreInteractions(coffeeShop.orderRepository);
    }

}