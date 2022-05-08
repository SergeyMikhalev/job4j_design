package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenKeyWithoutValue() {
        String path = "./data/key_without_value.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenValueWithoutKey() {
        String path = "./data/value_without_key.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenJustEquals() {
        String path = "./data/just_equals.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoEquals() {
        String path = "./data/no_equals.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
    }

    @Test
    public void whenDoubleEquals() {
        String path = "./data/double_equals.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
        assertThat(config.value("key1"), is("value1="));
        assertThat(config.value("key2"), is("value2=2"));
    }
}
