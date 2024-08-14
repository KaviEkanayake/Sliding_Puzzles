//Kavindi Ekanayake
//Student ID : 20221327

import java.io.File;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        String filename = "input.txt";// Change this to your input file name
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("Error: File not found.");
            return;
        }
        MapParser parser = new MapParser(filename);

        // Access map information
        char[][] map = parser.getMap();
        int width = parser.getWidth();
        int height = parser.getHeight();
        int startX = parser.getStartX();
        int startY = parser.getStartY();
        int finishX = parser.getFinishX();
        int finishY = parser.getFinishY();
        List<Integer> rockX = parser.getRockX();
        List<Integer> rockY = parser.getRockY();

        // Use map information as needed
        // For example, print the map
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
