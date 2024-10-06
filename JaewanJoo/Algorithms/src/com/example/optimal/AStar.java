package com.example.optimal;

import java.util.*;

class AStar {
    static class Node {
        int x, y;
        double g, h;

        Node parent;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double f() {
            return g + h;
        }
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Right, Left, Down, Up
    static Random random = new Random();

    public static void main(String[] args) {
        int N = 10; // Grid size
        int[][] grid = generateGrid(N);
        int[] pointA = generateRandomPoint(N, grid);

        grid[pointA[0]][pointA[1]] = 3; // Marking mandatory point A as 3

        System.out.println("Grid:");
        printGrid(grid);

        System.out.println("\nPath from (0, 0) to " + Arrays.toString(pointA) + ":");
        List<Node> pathToA = aStarSearch(grid, new Node(0, 0), new Node(pointA[0], pointA[1]));

        if (pathToA != null) {
            markPath(pathToA, grid);
            printGrid(grid);
        } else {
            System.out.println("No path found to point A.");
        }

        System.out.println("\nPath from " + Arrays.toString(pointA) + " to (" + (N - 1) + ", " + (N - 1) + "):");
        List<Node> pathToEnd = aStarSearch(grid, new Node(pointA[0], pointA[1]), new Node(N - 1, N - 1));

        if (pathToEnd != null) {
            markPath(pathToEnd, grid);
            printGrid(grid);
        } else {
            System.out.println("No path found to the end.");
        }
    }

    static int[][] generateGrid(int N) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (random.nextDouble() < 0.2 && !(i == 0 && j == 0) && !(i == N - 1 && j == N - 1)) {
                    grid[i][j] = 1; // Marking obstacles
                }
            }
        }
        return grid;
    }

    static int[] generateRandomPoint(int N, int[][] grid) {
        int x, y;
        do {
            x = random.nextInt(N);
            y = random.nextInt(N);
        } while (grid[x][y] == 1 || (x == 0 && y == 0) || (x == N - 1 && y == N - 1));
        return new int[]{x, y};
    }

    static List<Node> aStarSearch(int[][] grid, Node start, Node end) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(Node::f));
        boolean[][] closedSet = new boolean[grid.length][grid[0].length];
        start.g = 0;
        start.h = heuristic(start, end);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (current.x == end.x && current.y == end.y) {
                return reconstructPath(current);
            }

            closedSet[current.x][current.y] = true;

            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (isValid(newX, newY, grid) && !closedSet[newX][newY] && grid[newX][newY] != 1) {
                    Node neighbor = new Node(newX, newY);
                    double tentativeG = current.g + 1;

                    if (tentativeG < neighbor.g || !containsNode(openSet, neighbor)) {
                        neighbor.g = tentativeG;
                        neighbor.h = heuristic(neighbor, end);
                        neighbor.parent = current;

                        if (!containsNode(openSet, neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }
        }
        return null;
    }

    static double heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    static boolean containsNode(PriorityQueue<Node> openSet, Node node) {
        for (Node n : openSet) {
            if (n.x == node.x && n.y == node.y) {
                return true;
            }
        }
        return false;
    }

    static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    static void markPath(List<Node> path, int[][] grid) {
        for (Node node : path) {
            if (grid[node.x][node.y] == 0) {
                grid[node.x][node.y] = 2; // Marking the path with 2
            }
        }
    }

    static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                char symbol;
                switch (cell) {
                    case 1: symbol = '#'; break; // Obstacle
                    case 2: symbol = 'o'; break; // Path
                    case 3: symbol = 'A'; break; // Mandatory point A
                    default: symbol = '.'; break; // Empty space
                }
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}




