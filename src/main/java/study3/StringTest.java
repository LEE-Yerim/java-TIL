package study3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAll() {
        //int - null x / Integer - null o
        //numbers.type = Stream<Integer>
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .sum();
        //numbers.type = IntStream
        assertThat(result).isEqualTo(21);
    }

    @Test
    public void sumAllEven() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .filter(number -> number % 2 == 0)
                .sum();
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumAllEvenFastCode() {
        final int result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number)
                .sum();
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void sumAllDouble() {
        final int result = numbers.stream()
                .mapToInt(number -> number * 2)
                .sum();
        assertThat(result).isEqualTo(42);
    }

    @Test
    public void name() {
        final List<Integer> result = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        assertThat(result).containsExactly(2, 4, 6, 8, 10, 12);

        final List<String> names = Arrays.asList("가", "나", "다");
        final List<Car> cars = new ArrayList<>();
        for (final String name : names) {
            cars.add(new Car(name, 0));
        }

        final List<String> names2 = Arrays.asList("가", "나", "다");
        final List<Car> cars2 = names.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    @Test
    public void sumAllOverThreeDouble() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number * 2)
                .sum();
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void sumAllOverThreeDoubleReduce() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, (x, y) -> x + y);
        //((0 + 8) + 10) + 12 = 30
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void sumAllOverThreeDoubleForLoop() {
        int result = 0;
        for (int number : numbers) {
            if (number > 3) {
                result += number * 2;
            }
        }
        assertThat(result).isEqualTo(30);
    }


}
