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

    private static char[][] readMatrix(int rows, int cols, BufferedReader input) throws IOException {
        char[][] matrix = new char[rows][];

        for (int i=0; i<rows; i++) {
            matrix[i] = new char[cols];
            String line = input.readLine();
            String[] token = line.split("\\s");
            for (int j=0; j<cols; j++) {
                matrix[i][j] = token[j].charAt(0);
            }
        }

        return matrix;
    }

    public static void writeWorld(World world, Writer writer) {
        PrintWriter output = new PrintWriter(writer);
        output.format("Generation %d\n", world.getGeneration());
        char[][] matrix = world.getMatrix();
        output.format("%d %d\n", matrix.length, matrix[0].length);
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                output.format("%c%c", matrix[i][j], (j == matrix[i].length - 1)? '\n' : ' ');
            }
        }
    }

}
