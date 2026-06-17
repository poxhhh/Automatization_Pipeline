package ua.pr6;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TextProcessorTest {

    TextProcessor processor = new TextProcessor();

    @Tag("no_parameter")
    @Test
    public void testCapitalize() {
        String result = processor.capitalize("I love cakes");
        String expectedResult = "I Love Cakes";
        assumeTrue(result != null && result.matches(".*[a-zA-Z].*"));
        assertEquals(expectedResult, result);
    }

    @Tag("parameter")
    @ParameterizedTest
    @ValueSource(strings = {
            "I love cakes",
            "Kittens are playing in the garden",
            "Cup of tea"
    })
    void testReverseOrder(String text) {
        assumeTrue(text != null && text.matches(".*[a-zA-Z].*"));
        String result = processor.reverseOrder(processor.reverseOrder(text));
        assertEquals(text.trim().replaceAll("\\s+", " "), result);
    }

    @Tag("parameter")
    @ParameterizedTest
    @CsvSource({
            "She's so pretty!,she's so pretty",
            "Something9 bad' happened!!,something bad happened",
            "Oh NOoOoO,oh nooooo"
    })
    void testNormalize(String text, String expectedText) {
        assumeTrue(text != null && text.matches(".*[a-zA-Z].*"));
        assumeTrue(expectedText != null);
        assertEquals(expectedText, processor.normalize(text));
    }

    @Tag("dynamic")
    @TestFactory
    Stream<DynamicTest> test() throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("src/test/resources/order.txt"));
        return inputs.stream().map(text -> DynamicTest.dynamicTest
                (text, () -> assertEquals(text, processor.reverseOrder(processor.reverseOrder(text)))));
    }
}