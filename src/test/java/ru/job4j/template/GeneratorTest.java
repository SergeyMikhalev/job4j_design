package ru.job4j.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Ignore("Generator not implemented yet")
public class GeneratorTest {

    @Test
    public void whenUsualUsage() {
        Generator generator = new GeneratorMock();

        String template = "My name is ${my_name}, and your name is ${your_name}.";
        String result = "My name is Zoya, and your name is Vera.";

        Map<String, String> args = new HashMap<>();
        args.put("my_name", "Zoya");
        args.put("your_name", "Vera");

        Assert.assertEquals(result, generator.produce(template, args));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAdditionalKeysInMap() {
        Generator generator = new GeneratorMock();

        String template = "My name is ${name}.";

        Map<String, String> args = new HashMap<>();
        args.put("name", "Zoya");
        args.put("age", "15");

        generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAdditionalKeysInTemplate() {
        Generator generator = new GeneratorMock();

        String template = "My name is ${name} and my age is ${age}.";

        Map<String, String> args = new HashMap<>();
        args.put("name", "Zoya");

        generator.produce(template, args);
    }

    @Test(expected = NullPointerException.class)
    public void whenTemplateIsNull() {
        Generator generator = new GeneratorMock();

        String template = null;
        Map<String, String> args = new HashMap<>();
        args.put("name", "Zoya");

        generator.produce(template, args);
    }

    @Test(expected = NullPointerException.class)
    public void whenMapIsNull() {
        Generator generator = new GeneratorMock();

        String template = "My name is ${name}.";
        Map<String, String> args = null;

        generator.produce(template, args);
    }

    @Test
    public void whenNoReplacementInTemplateAndEmptyMap() {
        Generator generator = new GeneratorMock();

        String template = "My name is Zoya, and your name is Vera.";
        String result = "My name is Zoya, and your name is Vera.";

        Map<String, String> args = new HashMap<>();

        Assert.assertEquals(result, generator.produce(template, args));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenErrorInTemplate() {
        Generator generator = new GeneratorMock();

        String template = "My name is ${name}name}.";

        Map<String, String> args = new HashMap<>();
        args.put("name", "Zoya");
        args.put("name}name", "Vera");

        generator.produce(template, args);
    }

}

