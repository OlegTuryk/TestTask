package olegt;

public class App {
    public static void main(String[] args) {
        long start = System.nanoTime();
        QuerySolver querySolver = new QuerySolver();
        FileWriter fileWriter = new FileWriter();
        fileWriter.write("output.txt", querySolver.solveQueries("input.txt"));
        long finish = System.nanoTime(); // get the finish time in nanoseconds
        long timeElapsed = finish - start; // calculate the elapsed time
        System.out.println("The execution time was " + timeElapsed / 1000000 + " milliseconds");
    }
}
