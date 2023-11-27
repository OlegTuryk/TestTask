package olegt.parser;

import java.util.ArrayList;
import java.util.List;
import olegt.model.Tuple;

public class InputParser {
    private static final int INDEX_OF_FIRST_PART_OF_TEXT = 0;
    private static final int INDEX_OF_SECOND_PART_OF_TEXT = 1;
    private static final int INDEX_OF_THIRD_PART_OF_TEXT = 2;

    public ParseResult parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        int numberOfQueries = Integer.parseInt(lines[INDEX_OF_FIRST_PART_OF_TEXT]
                .substring(INDEX_OF_THIRD_PART_OF_TEXT));
        String givenString = lines[INDEX_OF_SECOND_PART_OF_TEXT];
        List<Tuple> queries = new ArrayList<>(numberOfQueries);
        for (int i = INDEX_OF_THIRD_PART_OF_TEXT; i < numberOfQueries
                + INDEX_OF_THIRD_PART_OF_TEXT; i++) {
            String[] tokens = lines[i].split(" ");
            queries.add(new Tuple(Integer.parseInt(tokens[INDEX_OF_FIRST_PART_OF_TEXT]),
                    Integer.parseInt(tokens[INDEX_OF_SECOND_PART_OF_TEXT]),
                    Integer.parseInt(tokens[INDEX_OF_THIRD_PART_OF_TEXT])));
        }
        return new ParseResult(numberOfQueries, givenString, queries);
    }
}
