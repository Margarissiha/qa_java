package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {
    @Test
    public void testLionConstructorInvalidSexErrorMessage() {
        try {
            new Lion("Неизвестный", Mockito.mock(Feline.class));
            fail("Должно быть выброшено исключение для невалидного пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
        }
    }

    @Test
    public void testLionConstructorInvalidSexContainsValidValues() {
        try {
            new Lion("Неизвестный", Mockito.mock(Feline.class));
            fail("Должно быть выброшено исключение для невалидного пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'самец или самка'",
                    e.getMessage().contains("самец или самка"));
        }
    }

    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", Mockito.mock(Feline.class));
        assertTrue("Самец льва должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", Mockito.mock(Feline.class));
        assertFalse("Самка льва не должна иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testGetKittensReturnsOne() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals("Должен возвращаться 1 котенок", 1, lion.getKittens());
    }

    @Test
    public void testGetFoodIsNotNull() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);
        List<String> food = lion.getFood();
        assertNotNull("Еда не должна быть null", food);
    }

    @Test
    public void testGetFoodHasThreeItems() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);
        List<String> food = lion.getFood();
        assertEquals("Должно быть 3 вида еды", 3, food.size());
    }

    @Test
    public void testGetFoodContainsAnimals() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);
        List<String> food = lion.getFood();
        assertTrue("Должны содержаться 'Животные'", food.contains("Животные"));
    }

    @Test
    public void testGetFoodContainsBirds() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);
        List<String> food = lion.getFood();
        assertTrue("Должны содержаться 'Птицы'", food.contains("Птицы"));
    }

    @Test
    public void testGetFoodContainsFish() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);
        List<String> food = lion.getFood();
        assertTrue("Должны содержаться 'Рыба'", food.contains("Рыба"));
    }
}
