package olegt.parser;

import java.util.List;
import olegt.model.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        inputParser = new InputParser();
    }

    @Test
    void parseString_validString_ParseResultCreatedCorrectly() {
        ParseResult expected = new ParseResult(1,
                "ABABBA", List.of(new Tuple(1, 4, 2)));
        String testData = """
                6 1\r
                ABABBA\r
                1 4 2""";
        ParseResult actual = inputParser.parse(testData);
        Assertions.assertEquals(expected, actual);
    }
}
