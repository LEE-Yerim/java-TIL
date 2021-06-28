[참고자료](https://www.daleseo.com/assertj/)

### String Calculator Test
- test 클래스의 package명은 main 클래스와 동일하게 한다.
```java
package stringcalculator;
```
- BeforeEach
```java
import org.junit.jupiter.api.BeforeEach;
```
```java
public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }
}
```
- DisplayName
- Test
```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
```
- assertThat
```java
import static org.assertj.core.api.Assertions.assertThat;
```
```java
public class StringCalculatorTest {
    @DisplayName(value = "공백을 기준으로 연산자와 피연산자를 구분한다.")
    @Test
    void splitOperatorAndOperand() {
        String input = "3 / 2";
        String[] splitInput = {"3", "/", "2"};

        assertThat(stringCalculator.splitBySeparator(input)).isEqualTo(splitInput);
    }

    @DisplayName(value = "두 숫자를 더할 수 있다.")
    @Test
    void additionTest() {
        String[] splitInput = {"1", "+", "3"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(4);
    }

    @DisplayName(value = "두 숫자를 뺄 수 있다.")
    @Test
    void subtractionTest() {
        String[] splitInput = {"4", "-", "1"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(3);
    }

    @DisplayName(value = "두 숫자를 곱할 수 있다.")
    @Test
    void multiplyTest() {
        String[] splitInput = {"2", "*", "4"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(8);
    }

    @DisplayName(value = "두 숫자를 나눌 수 있다.")
    @Test
    void divisionTest() {
        String[] splitInput = {"6", "/", "3"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(2);
    }
}
```
- assertThatIllegalArgumentException
```
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
```
```java
public class StringCalculatorTest {
    @DisplayName(value = "입력값이 빈 문자열이거나 null 이라면 isBlank 함수를 호출했을 때 true 를 반환한다.")
    @Test
    void isBlank_ShouldReturnTrueForNullOrBlankStrings() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.checkBlank(" ");
        });
    }

    @DisplayName(value = " + , - , * , / 외의 연산자를 입력하면 IllegalArgumentException을 발생시킨다.")
    @Test
    void operatorTest() {
        String[] splitInput = {"5", "!", "0"};

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateSplitString(splitInput);
        });
    }

    @DisplayName(value = "0으로 나누면 IllegalArgumentException을 발생시킨다.")
    @Test()
    void should_ThrowException_When_dividedByZero() {
        String[] splitInput = {"5", "/", "0"};

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateSplitString(splitInput);
        });
    }
}
```

### Racing Car Game Test
```java
package racingcargame;
```
- DisplayName
- Test
```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
```
- assertThat
```java
import static org.assertj.core.api.Assertions.assertThat;
```
```java
public class RacingCarGameTest {
    @DisplayName(value = "랜덤수는 1부터 10까지이다.")
    @Test
    void is_between_1_and_10() {
//        RandomNumber randomNumber = new RandomNumber();
//        int v = randomNumber.createRandomNumber();
//        assertThat(v >= 1 && v <= 10).isTrue();
        assertThat(RandomNumber.createRandomNumber()).isBetween(1,10);
    }
}
```

### String Addition Calculator Test
```java
package stringadditioncalculator;
```
- BeforeEach
```java
import org.junit.jupiter.api.BeforeEach;
```
```java
class StringAdditionCalculatorTest {
    private StringAdditionCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAdditionCalculator();
    }
}
```
- DisplayName
- Test
```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
```
- assertThat
```java
import static org.assertj.core.api.Assertions.assertThat;
```
- ParameterizedTest
  - NullAndEmptySource
  - ValueSource
```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
```
```java
class StringAdditionCalculatorTest {
    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }
}
```
```java
class StringAdditionCalculatorTest {
    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void twoNumbers(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void colons(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "구분자 사이가 비어있으면 0으로 생각하고 계산한다.")
    @ParameterizedTest
    @ValueSource(strings = {",,3"})
    void zeroAndColons(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void customDelimiter(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "//와 \n 문자 사이에 커스텀 구분자와 기존 구분자 (, 와 :)를 혼용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2,3"})
    void customAndColons(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }
}
```
- assertThatExceptionOfType
```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
```
```java
class StringAdditionCalculatorTest {
    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add("-1"));
    }

    @DisplayName(value = "문자열 계산기에 한글을 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요"})
    void nonNumber(final String text) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add(text));
    }
    
    @DisplayName(value = "숫자가 아닌 문자 하나를 문자열로 입력할 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = {","})
    void nonOneNumber(final String text) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add(text));
    }
}
```
