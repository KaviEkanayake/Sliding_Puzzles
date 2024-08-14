public class Node {
    private int x;
    private int y;
    private boolean visited;
    private boolean blocked;

    // Constructor
    public Node(int x, int y, boolean visited, boolean blocked) {
        this.x = x;
        this.y = y;
        this.visited = visited;
        this.blocked = blocked;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
