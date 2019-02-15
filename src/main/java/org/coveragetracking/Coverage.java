package org.coveragetracking;

public class Coverage {
    public Coverage() {
        printmatchesCoverage();
        printprintValuesCoverage();
        printInterceptedEqualsCoverage();
    }

    //static boolean array used for counting branch coverage.
    public static boolean[] ArrayEqualsCoverage = new boolean[11];
    public static boolean[] ValuePrinter = new boolean[6];

    public static void printmatchesCoverage() {
        String fileName = "matches.txt";
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(fileName, "UTF-8");
            int counter = 0;
            for(int i = 0; i < ArrayEqualsCoverage.length; i++) {
                writer.println("index: " + i + ", visited: " + ArrayEqualsCoverage[i]);
                if(ArrayEqualsCoverage[i]) {
                    counter++;
                }
            }
            writer.println("(" + counter + " / " + ArrayEqualsCoverage.length + ") branches visited.");
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed writing to file: " + fileName);
        }

    }

    public static void printprintValuesCoverage() {
        String fileName = "printValues.txt";
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(fileName, "UTF-8");
            int counter = 0;
            for(int i = 0; i < ValuePrinter.length; i++) {
                writer.println("index: " + i + ", visited: " + ValuePrinter[i]);
                if(ValuePrinter[i]) {
                    counter++;
                }
            }
            writer.println("(" + counter + " / " + ValuePrinter.length + ") branches visited.");
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed writing to file: " + fileName);
        }

    }
    public static boolean[] InterceptedEquals = new boolean[2];

    public static void printInterceptedEqualsCoverage() {
        String fileName = "InterceptedEquals.txt";
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(fileName, "UTF-8");
            int counter = 0;
            for(int i = 0; i < InterceptedEquals.length; i++) {
                writer.println("index: " + i + ", visited: " + InterceptedEquals[i]);
                if(InterceptedEquals[i]) {
                    counter++;
                }
            }
            writer.println("(" + counter + " / " + InterceptedEquals.length + ") branches visited.");
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed writing to file: " + fileName);
        }

    }


    //Add more static variables and print functions after this line
    //And add it to Coverage().


}
