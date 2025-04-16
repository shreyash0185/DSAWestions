package org.example.graph;
//Breadth-First Search Technique - Traversal
//Breadth -> level wise traversal

import java.util.ArrayList;
import java.util.*;
public class BFS {

//Queue
    //Visited Arraay
// BFS from given source s
    static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj, int s){
        int V = adj.size();

        // create an array to store the traversal
        ArrayList<Integer> res = new ArrayList<>();

        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();


        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Mark source node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        // Iterate over the queue
        while (!q.isEmpty()){
            // Dequeue a vertex from queue and store it
            int curr = q.poll();
            res.add(curr);

            // Get all adjacent vertices of the dequeued
            // vertex curr If an adjacent has not been
            // visited, mark it visited and enqueue it
            for(int x : adj.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        int src = 0;
        ArrayList<Integer> ans = bfsOfGraph(adj, src);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }


}

//
//                1                           L0
//            /        \
//           2         6                      L1
//         /   \      /  \
//        3     4     7   8                   L2
//              \     /
//                  5                         L3
//
//1  2  6  3  4  7  8  5

//Noe suppose 6 is at level 0 the structure is

//
//                1                          L1
//            /        \
//           2         6                     L0
//         /   \      /  \
//        3     4     7   8                   L1
//              \     /
//                  5                         L2
// 6-l0 1 7 8-l1 2 5-l2 3 4-l3

//SC - Q + visted node + list -> O(N)
//TC - o(N) + o(2E)

