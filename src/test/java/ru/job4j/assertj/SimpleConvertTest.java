package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> stringList = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(stringList).isNotEmpty()
                .allSatisfy(e -> assertThat(e.length()).isLessThan(10))
                .anySatisfy(e -> assertThat(e.length()).isEqualTo(6))
                .allMatch(e -> e.length() < 9)
                .noneMatch(e -> e.startsWith("a"));

        assertThat(stringList)
                .filteredOn(e -> e.endsWith("e"))
                .contains("five")
                .doesNotContain("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> stringSet = simpleConvert.toSet("first", "second", "three", "four", "five", "first");
        assertThat(stringSet).isNotEmpty()
                .filteredOnAssertions(e -> assertThat(e).startsWith("f"))
                .hasSize(3)
                .first()
                .isEqualTo("four");

    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert
                .toMap("first", "second", "three", "four", "five", "first");

        assertThat(map)
                .containsEntry("first", 0)
                .containsKey("four")
                .containsValue(0)
                .containsKeys("five", "four");
    }
}