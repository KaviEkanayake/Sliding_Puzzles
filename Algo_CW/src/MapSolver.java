import java.util.*;
public class MapSolver {
    private int numRows;
    private int numCols;
    private char[][] grid;
    private int startX;
    private int startY;
    private int finishX;
    private int finishY;

    public MapSolver(char[][] grid, int startX, int startY, int finishX, int finishY) {
        this.grid = grid;
        this.numRows = grid.length;
        this.numCols = grid[0].length;
        this.startX = startX;
        this.startY = startY;
        this.finishX = finishX;
        this.finishY = finishY;
    }

    // Getters
    public char[][] getGrid() {
        return grid;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
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
    // Breadth-First Search
    public List<Node> findShortestPath() {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parentMap = new HashMap<>();
        List<Node> shortestPath = new ArrayList<>();

        Node startNode = new Node(startX, startY, false, false);
        queue.add(startNode);
        visited.add(startNode);
        parentMap.put(startNode, null);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.getX() == finishX && currentNode.getY() == finishY) {
                // Found the finish node, construct the path
                Node node = currentNode;
                while (node != null) {
                    shortestPath.add(node);
                    node = parentMap.get(node);
                }
                Collections.reverse(shortestPath);
                break;
            }

            // Explore neighbors
            for (Node neighbor : getNeighbors(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentNode);
                }
            }
        }

        return shortestPath;
    }

    // Helper method to get neighboring nodes
    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();

        // Calculate coordinates of potential neighboring nodes
        int x = node.getX();
        int y = node.getY();

        // Check up
        if (isValid(x, y - 1) && grid[y - 1][x] != '0') {
            neighbors.add(new Node(x, y - 1, false, false)); // Pass all required arguments
        }
        // Check down
        if (isValid(x, y + 1) && grid[y + 1][x] != '0') {
            neighbors.add(new Node(x, y + 1, false, false)); // Pass all required arguments
        }
        // Check left
        if (isValid(x - 1, y) && grid[y][x - 1] != '0') {
            neighbors.add(new Node(x - 1, y, false, false)); // Pass all required arguments
        }
        // Check right
        if (isValid(x + 1, y) && grid[y][x + 1] != '0') {
            neighbors.add(new Node(x + 1, y, false, false)); // Pass all required arguments
        }

        return neighbors;
    }

    // Helper method to check if coordinates are valid
    private boolean isValid(int x, int y) {
        return x >= 0 && x < numCols && y >= 0 && y < numRows;
    }
        // Implement logic to get neighboring nodes (up, down, left, right)
}


