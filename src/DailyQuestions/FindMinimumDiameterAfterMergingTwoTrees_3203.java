package DailyQuestions;

import java.util.*;

public class FindMinimumDiameterAfterMergingTwoTrees_3203 {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}};
        int[][] edges2 = {{0,1},{0,2},{0,3}};

        /*
        if odd and odd nodes - 1 + (node+1) /2 + (node+1) /2
        if odd and even nodes - 1 + (node+1) /2 + node /2
        if even and even nodes - take midpt, so 1 + node /2 + node/2
         */
        int e1 = findLongestPath(edges1);
        int e2 = findLongestPath(edges2);

        // Compute formula
        if (e1 % 2 == 0 && e2 % 2 == 0) {
            System.out.println((1 + (e1 / 2) + (e2 / 2)));
        } else if (e1 % 2 == 1 && e2 % 2 == 1) {
            System.out.println((1 + (e1 +1)/ 2 + (e2+1) / 2));
        } else {
            if (e1 % 2 == 1 && e2 % 2 == 0) {
                System.out.println(1 + e2 / 2 + (e1 + 1) / 2);
            } else {
                System.out.println(1 + e1 / 2 + (e2 + 1) / 2);
            }
        }
    }

    public static int findLongestPath(int[][] edges) {
        if (edges.length ==0) return 0;
        // Step 1: Build the adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Step 2: Start BFS from an arbitrary node (the first node in the first edge)
        int arbitraryStartNode = edges[0][0];
        int[] firstBFS = bfs(adj, arbitraryStartNode);
        int farthest1 = firstBFS[0]; // Farthest node from arbitrary node

        // Step 3: Perform BFS from the farthest node found (farthest1)
        int[] secondBFS = bfs(adj, farthest1);
        return secondBFS[1]; // The longest path distance
    }

    private static int[] bfs(Map<Integer, List<Integer>> adj, int start) {
        // Initialize visited set and distance map
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the given start node
        queue.offer(start);
        visited.add(start);
        distance.put(start, 0);

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distance.put(neighbor, distance.get(node) + 1);
                    queue.offer(neighbor);

                    // Update the farthest node and max distance
                    if (distance.get(neighbor) > maxDistance) {
                        maxDistance = distance.get(neighbor);
                        farthestNode = neighbor;
                    }
                }
            }
        }

        // Return the farthest node and its distance
        return new int[]{farthestNode, maxDistance};
    }
}