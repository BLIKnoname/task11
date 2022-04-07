package com.metanit;


import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import util.ArrayUtils;

/*

 */

public class Main {

    public static class InputArgs {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static InputArgs parseArgs(String[] args) {
        InputArgs params = new InputArgs();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile = args[0];

            if (args.length > 1) {
                params.outputFile = args[1];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }


    public static void main(String[] args) {

        InputArgs params = parseArgs(args);

        if (params.help) {
            PrintStream out = params.error ?  System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        if (params.window) {
            System.out.println("WINDOW");
        } else {

            try {

                String[] dataStr = ArrayUtils.readLinesFromFile(params.inputFile);
                String message = Arrays.toString(dataStr);
                System.out.println(message);
                String dencryText = Logic.decod(message, 2);
                System.out.println(dencryText);


                PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile, "UTF-8") : System.out;
                for (int i = 0; i < 1; i++) {
                    out.print(dencryText);
                }
                out.close();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
