package gol;

import java.io.*;

public class Main {
    public static void main(String[] argv) throws IOException {
        Reader input = getInputReader(argv);
        World world = UI.readWorld(input);
        input.close();

        OutputStreamWriter output = getOutputReader(argv);
        UI.writeWorld(world.next(), output);
        output.close();
    }

    private static OutputStreamWriter getOutputReader(String[] argv)
            throws IOException {

        OutputStreamWriter output;
        if (argv.length < 2)
            output = new OutputStreamWriter(System.out);
        else
            output = new FileWriter(argv[1]);

        return output;
    }

    private static Reader getInputReader(String[] argv)
            throws FileNotFoundException {
        
        Reader input;
        if (argv.length == 0)
            input = new InputStreamReader(System.in);
        else
            input = new FileReader(argv[0]);
        return input;
    }
}
