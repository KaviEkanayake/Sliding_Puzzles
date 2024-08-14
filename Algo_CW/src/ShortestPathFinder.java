import java.util.*;

public class ShortestPathFinder {
    private char[][] map;
    private int width;
    private int height;
    private int startX;
    private int startY;
    private int finishX;
    private int finishY;

    public ShortestPathFinder(char[][] map, int startX, int startY, int finishX, int finishY) {
        this.map = map;
        this.width = map[0].length;
        this.height = map.length;
        this.startX = startX;
        this.startY = startY;
        this.finishX = finishX;
        this.finishY = finishY;
    }

    public List<String> findShortestPath() {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parentMap = new HashMap<>();

        Node startNode = new Node(startX, startY);
        queue.add(startNode);
        visited.add(startNode);
        parentMap.put(startNode, null);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.getX() == finishX && currentNode.getY() == finishY) {
                // Found the finish node, construct the path
                return constructPath(parentMap, currentNode);
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

        // No path found
        return null;
    }

    private List<Node> getNeighbors(Node node) {
        int x = node.getX();
        int y = node.getY();
        List<Node> neighbors = new ArrayList<>();

        // Check up
        if (isValid(x, y - 1) && !isBlocked(x, y - 1)) {
            neighbors.add(new Node(x, y - 1));
        }
        // Check down
        if (isValid(x, y + 1) && !isBlocked(x, y + 1)) {
            neighbors.add(new Node(x, y + 1));
        }
        // Check left
        if (isValid(x - 1, y) && !isBlocked(x - 1, y)) {
            neighbors.add(new Node(x - 1, y));
        }
        // Check right
        if (isValid(x + 1, y) && !isBlocked(x + 1, y)) {
            neighbors.add(new Node(x + 1, y));
        }

        return neighbors;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private boolean isBlocked(int x, int y) {
        return map[y][x] == '0'; // '0' represents a blocked square
    }

    private List<String> constructPath(Map<Node, Node> parentMap, Node finishNode) {
        List<String> path = new ArrayList<>();
        Node node = finishNode;

        while (node != null) {
            path.add("Move to (" + node.getX() + "," + node.getY() + ")");
            node = parentMap.get(node);
        }

        Collections.reverse(path);
        return path;
    }

    private static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

