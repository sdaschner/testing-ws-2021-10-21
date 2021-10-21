package com.sebastian_daschner.coffee_shop.orders.boundary;

import com.sebastian_daschner.coffee_shop.orders.control.OrderProcessorTestDouble;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import com.sebastian_daschner.coffee_shop.orders.entity.Order;
import com.sebastian_daschner.coffee_shop.orders.entity.Origin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.sebastian_daschner.coffee_shop.orders.TestData.unfinishedOrders;

class CoffeeShopUseCaseTest {

    private CoffeeShopTestDouble coffeeShop;
    private OrderProcessorTestDouble orderProcessor;

    @BeforeEach
    void setUp() {
        orderProcessor = new OrderProcessorTestDouble();
        coffeeShop = new CoffeeShopTestDouble(orderProcessor);
    }

    @Test
    void create_coffee_order() {
        Order order = new Order(UUID.randomUUID(), CoffeeType.ESPRESSO, new Origin("Colombia"));
        coffeeShop.createOrder(order);
        coffeeShop.verifyCreateOrder(order);
    }

    @Test
    void verify_process_unfinished_orders() {
        List<Order> orders = unfinishedOrders();

        coffeeShop.answerForUnfinishedOrders(orders);

        coffeeShop.processUnfinishedOrders();
        coffeeShop.verifyProcessUnfinishedOrders(orders);
    }

}
