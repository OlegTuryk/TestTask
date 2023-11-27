package olegt.parser;

import java.util.List;
import olegt.model.Tuple;

public record ParseResult(int numberOfQueries,
                          String givenString, List<Tuple> queries) {
}
