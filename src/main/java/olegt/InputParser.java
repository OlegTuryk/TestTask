package olegt;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final int INDEX_OF_FIRST = 0;
    private static final int INDEX_OF_SECOND = 1;
    private static final int INDEX_OF_THIRD = 2;
    private int numberOfQueries;
    private String givenString;
    private List<Tuple> queries;

    public int getNumberOfQueries() {
        return numberOfQueries;
    }

    public String getGivenString() {
        return givenString;
    }

    public List<Tuple> getQueries() {
        return queries;
    }

    public void parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        numberOfQueries = Integer.parseInt(lines[INDEX_OF_FIRST].substring(2));
        givenString = lines[INDEX_OF_SECOND];
        queries = new ArrayList<>(numberOfQueries);
        for (int i = INDEX_OF_THIRD; i < numberOfQueries + INDEX_OF_THIRD; i++) {
            String[] tokens = lines[i].split(" ");
            queries.add(new Tuple(Integer.parseInt(tokens[INDEX_OF_FIRST]),
                    Integer.parseInt(tokens[INDEX_OF_SECOND]),
                    Integer.parseInt(tokens[INDEX_OF_THIRD])));
        }
    }
}
