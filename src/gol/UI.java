package gol;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI {
    public static final Pattern DIMENSIONS_REGEX = Pattern.compile("\\s*(\\d+)\\s+(\\d+)\\s*");
    public static final Pattern GENERATION_REGEX = Pattern.compile("(\\d+)\\s*$");

    public static World readWorld(Reader inputReader) throws IOException {
        BufferedReader input = new BufferedReader(inputReader);
        int generation = readGeneration(input.readLine());

        String dimensions = input.readLine();
        Matcher matcher = DIMENSIONS_REGEX.matcher(dimensions);
        matcher.matches();
        int rows = Integer.parseInt(matcher.group(1));
        int cols = Integer.parseInt(matcher.group(1));

        return new World(generation, readMatrix(rows, cols, input));
    }

    private static int readGeneration(String line) {
        Matcher matcher = GENERATION_REGEX.matcher(line);
        matcher.find();
        return Integer.parseInt(matcher.group(1));
    }

    private static Matrix<Character> readMatrix(int rows, int cols, BufferedReader input) throws IOException {
        Matrix<Character> matrix = new Matrix<Character>(rows, cols);

        for (int i=0; i<rows; i++) {
            String line = input.readLine();
            String[] token = line.split("\\s");
            for (int j=0; j<cols; j++)
                matrix.put(i, j, token[j].charAt(0));
        }

        return matrix;
    }

    public static void writeWorld(World world, Writer writer) {
        PrintWriter output = new PrintWriter(writer);
        output.format("Generation %d\n", world.getGeneration());
        Matrix<Character> matrix = world.getMatrix();
        output.format("%d %d\n", matrix.rows(), matrix.cols());
        for (int i=0; i<matrix.rows(); i++)
            for (int j=0; j<matrix.cols(); j++)
                output.format("%c%c", matrix.get(i, j), (j == matrix.cols() - 1)? '\n' : ' ');
    }

}
