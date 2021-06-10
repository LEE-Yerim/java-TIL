package study3;

import org.assertj.core.api.Assertions;import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void move() {
        final Car car = new Car("yerim", 0);
        final Car actual = car.move(() -> true);
        Assertions.assertThat(actual.getPosition()).isEqualTo(1);
    }

    @Test
    public void stop() {
        final Car car = new Car("yerim", 0);
        final Car actual = car.move(() -> false);
        Assertions.assertThat(actual.getPosition()).isEqualTo(0);
    }
    //input -> body / return
    //input 이나 return 값의 타입을 명명해줄 필요가 없다.
    //똑똑한 컴파일러 ^^

    //람다함수를 사용하기 위해서는 모태가 되는 인터페이스는 추상메서드를 하나만 가져야 한다.
    //Single Abstract Method

    //인터페이스는 뭐고 추상메서드 default메서드는 뭘깡

}
