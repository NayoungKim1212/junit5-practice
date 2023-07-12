package com.sparta.junit5practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("assertEquals")
    void test1() {
        Double result = calculator.operate(5, "/", 2);
        assertEquals(2.5, result); // assertEquals(예측값, 결과값)
    }

    @Test
    @Disabled
    @DisplayName("assertEquals - Supplier") // 문제가 생겼을 때 메세지 전달
    void test1_1() {
        Double result = calculator.operate(5, "/", 0);
        // 테스트 실패 시 메시지 출력 (new Supplier<String>())
        assertEquals(2.5, result, () -> "연산자 혹은 분모가 0이 아닌지 확인해보세요!");
    }

    @Test
    @DisplayName("assertNotEquals")
    void test1_2() {
        Double result = calculator.operate(5, "/", 0);
        assertNotEquals(2.5, result); // assertNotEquals : 둘이 틀림을 예측해야함
    }

    @Test
    @DisplayName("assertTrue 와 assertFalse")
    void test2() { // boolean 타입을 테스트 하고 싶을 땐  assertTrue or assertFalse 사용
        assertTrue(calculator.validateNum(9));
        assertFalse(calculator.validateNum(0));
    }

    @Test
    @DisplayName("assertNotNull 과 assertNull")
    void test3() {
        Double result1 = calculator.operate(5, "/", 2);
        assertNotNull(result1);
        Double result2 = calculator.operate(5, "/", 0);
        assertNull(result2);
    }

    @Test
    @DisplayName("assertThrows")
    void test4() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.operate(5, "?", 2));
        assertEquals("잘못된 연산자입니다.", exception.getMessage());
    }  // assertThrows : 첫 번재 parameter로 예상하는 class type
}
