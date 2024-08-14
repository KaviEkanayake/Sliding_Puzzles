import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapParser {
    private char[][] map;
    private int width;
    private int height;
    private int startX;
    private int startY;
    private int finishX;
    private int finishY;
    private List<Integer> rockX;
    private List<Integer> rockY;

    public MapParser(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            height = lines.size();
            width = lines.get(0).length();
            map = new char[height][width];
            rockX = new ArrayList<>();
            rockY = new ArrayList<>();

            for (int i = 0; i < height; i++) {
                String row = lines.get(i);
                for (int j = 0; j < width; j++) {
                    char c = row.charAt(j);
                    map[i][j] = c;
                    if (c == 'S') {
                        startX = j;
                        startY = i;
                    } else if (c == 'F') {
                        finishX = j;
                        finishY = i;
                    } else if (c == '0') {
                        rockX.add(j);
                        rockY.add(i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters for map information
    public char[][] getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getFinishX() {
        return finishX;
    }

    public int getFinishY() {
        return finishY;
    }

    public List<Integer> getRockX() {
        return rockX;
    }

    public List<Integer> getRockY() {
        return rockY;
    }
}
