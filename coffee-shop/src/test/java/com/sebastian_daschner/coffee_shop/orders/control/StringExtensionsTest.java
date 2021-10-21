package com.sebastian_daschner.coffee_shop.orders.control;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringExtensionsTest {

    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input, String expected) {
        assertThat(StringExtensions.capitalize(input)).isEqualTo(expected);
    }

    static Stream<String[]> testCapitalize() {
        return Stream.of(
                new String[]{"ESPRESSO", "Espresso"},
                new String[]{"eSPRESSO", "Espresso"},
                new String[]{"e", "E"},
                new String[]{"hello world", "Hello world"},
                new String[]{"HELLO", "Hello"},
                new String[]{"hELLO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hellO", "Hello"},
                new String[]{"hello", "Hello"}

        );
    }

}