package com.sebastian_daschner.coffee_shop.systemtest.backend;

import com.sebastian_daschner.coffee_shop.systemtest.backend.entity.Order;
import com.sebastian_daschner.coffee_shop.systemtest.backend.entity.OrderAssert;
import com.sebastian_daschner.coffee_shop.systemtest.backend.systems.BaristaSystem;
import com.sebastian_daschner.coffee_shop.systemtest.backend.systems.CoffeeOrderSystem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.URI;

class CreateOrderTest {

    private CoffeeOrderSystem coffeeOrderSystem;
    private BaristaSystem baristaSystem;

    @BeforeEach
    void setUp() {
        coffeeOrderSystem = new CoffeeOrderSystem();
        baristaSystem = new BaristaSystem();
    }

    @Test
    void create_verify_order() {
        Order order = new Order("Espresso", "Colombia");
        URI orderUri = coffeeOrderSystem.createOrder(order);

        Order loadedOrder = coffeeOrderSystem.getOrder(orderUri);
        OrderAssert.assertThat(loadedOrder).matchesOrderedData(order);

        Assertions.assertThat(coffeeOrderSystem.getOrders()).contains(orderUri);
    }

    @Test
    @Disabled
    void createOrderCheckStatusUpdate() {
        Order order = new Order("Espresso", "Colombia");
        URI orderUri = coffeeOrderSystem.createOrder(order);

        baristaSystem.answerForOrder(orderUri, "PREPARING");

        Order loadedOrder = coffeeOrderSystem.getOrder(orderUri);
        OrderAssert.assertThat(loadedOrder).matchesOrderedData(order);

        loadedOrder = waitForProcessAndGet(orderUri, "PREPARING");
        Assertions.assertThat(loadedOrder.getStatus()).isEqualTo("Preparing");

        baristaSystem.answerForOrder(orderUri, "FINISHED");

        loadedOrder = waitForProcessAndGet(orderUri, "FINISHED");
        Assertions.assertThat(loadedOrder.getStatus()).isEqualTo("Finished");
    }

    private Order waitForProcessAndGet(URI orderUri, String requestedStatus) {
        baristaSystem.waitForInvocation(orderUri, requestedStatus);
        return coffeeOrderSystem.getOrder(orderUri);
    }

    @AfterEach
    void close() {
        coffeeOrderSystem.close();
    }

}