package org.coveragetracking;

public class Coverage {
    public Coverage() {
        printmatchesCoverage();
    }

    //static boolean array used for counting branch coverage.
    public static boolean[] ArrayEqualsCoverage = new boolean[11];

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
    //Add more static variables and print functions after this line
    //And add it to Coverage().


}