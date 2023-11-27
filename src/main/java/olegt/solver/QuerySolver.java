package olegt.solver;

import java.util.ArrayList;
import java.util.List;
import olegt.model.Tuple;
import olegt.parser.ParseResult;

public class QuerySolver {

    public List<Integer> solveQueries(ParseResult parseResult) {
        List<Integer> answers = new ArrayList<>(parseResult.numberOfQueries());
        String sub = parseResult.givenString();
        for (Tuple query : parseResult.queries()) {
            answers.add(solveQuery(sub.substring(query.l() - 1, query.r()), query.k()));
        }
        return answers;
    }

    private int solveQuery(String sub, int k) {
        int pos = -1;
        if (k > sub.length()) {
            return pos;
        }
        char ch = sub.charAt(k - 1);
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (sub.charAt(i) == ch) {
                count++;
            }
        }
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) != ch) {
                count--;
            }
            if (count == 0) {
                return i + 1;
            }
        }
        return pos;
    }
}
