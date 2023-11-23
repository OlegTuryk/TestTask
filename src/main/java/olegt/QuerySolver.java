package olegt;

import java.util.ArrayList;
import java.util.List;

public class QuerySolver {
    private final FileReader fileReader = new FileReader();
    private final InputParser inputParser = new InputParser();

    public List<Integer> solveQueries(String filename) {
        inputParser.parse(fileReader.read(filename));
        List<Integer> answers = new ArrayList<>(inputParser.getNumberOfQueries());
        String sub = inputParser.getGivenString();
        for (Tuple query : inputParser.getQueries()) {
            answers.add(solveQuery(sub.substring(query.l() - 1, query.r()), query.k()));
        }
        return answers;
    }

    private int solveQuery(String sub, int k) {
        char ch = sub.charAt(k - 1);
        int pos = -1;
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
