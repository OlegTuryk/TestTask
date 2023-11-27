package olegt.solver;

import java.util.List;
import olegt.model.Tuple;
import olegt.parser.ParseResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuerySolverTest {
    private QuerySolver querySolver;

    @BeforeEach
    public void setUp() {
        querySolver = new QuerySolver();
    }

    @Test
    void solveQueries_validParseResult_CorrectResult() {
        ParseResult testData = new ParseResult(3,
                "ABABBA", List.of(new Tuple(1, 4, 2),
                new Tuple(4, 6, 1),
                new Tuple(1, 3, 5)));
        List<Integer> actual = querySolver.solveQueries(testData);
        List<Integer> expected = List.of(1, 3, -1);
        Assertions.assertEquals(expected, actual);
    }
}
