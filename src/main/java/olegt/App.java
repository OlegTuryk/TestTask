package olegt;

import olegt.io.FileReader;
import olegt.io.FileWriter;
import olegt.parser.InputParser;
import olegt.parser.ParseResult;
import olegt.solver.QuerySolver;

public class App {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        InputParser inputParser = new InputParser();
        QuerySolver querySolver = new QuerySolver();
        FileWriter fileWriter = new FileWriter();
        ParseResult parseResult = inputParser.parse(fileReader.read("input.txt"));
        fileWriter.write("output.txt", querySolver.solveQueries(parseResult));
    }
}
