package study3;

import org.assertj.core.api.Assertions;import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {
    @Test
    public void name() {
        final Optional<String> maybeName = Optional.ofNullable("yerim");
        final Car actual = maybeName.map(name -> new Car(name, 0))
                .orElse(new Car("test", 0));
        Assertions.assertThat(Collections.singletonList(actual.getName())).isEqualTo("yerim");
    }
}
