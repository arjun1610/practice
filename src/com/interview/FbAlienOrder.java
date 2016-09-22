package com.interview;

import java.util.*;

/**
 * Created by arjun on 1/10/16.
 * Build Graph

 Init indegree[26] for number of links pointing to w[i], adj[26] for neighbors of w[i].
 For each first seeing character w[i] with indegree initially-1, mark it as indegree = 0.
 For each adjacent words w1 and w2, if w1[i] != w2[i], insert w1[i] -> w2[i] into graph. Increase indegree[w2[i]] by 1.

 * Topological Sort

 Start from queue filled with indegree = 0 characters (lexicographically earliest).
 poll queue, append these 0 indegree guys, and reduce indegree of their neighbors by 1.
 If neighbors reduced to indegree = 0, add them back to queue.
 Peel level by level until queue is empty.

 */
public class FbAlienOrder {
    private final int N = 26;
    public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<>(N);
        int[] degree = new int[N];
        buildGraph(words, adj, degree);

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(degree[i] == 0) q.add(i);
        }
        Stack<Integer> s1= new Stack<>();
        s1.peek();
        //topological sort
        // peeling 0 indegree nodes
        while(!q.isEmpty()) {
            int i = q.poll();
            sb.append((char) ('a' + i));
            for(int j : adj.get(i)) {
                if(--degree[j] == 0) {
                    q.add(j);
                }
            }
        }
        for(int d : degree)
            if(d > 0)
                return "";  // invalid
        return sb.toString();
    }

    public void buildGraph(String[] words, List<Set<Integer>> adj, int[] degree) {
        for(int i = 0; i < N; i++)
            adj.add(new HashSet<Integer>());
        Arrays.fill(degree, -1);

        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                if(degree[c - 'a'] < 0) degree[c - 'a'] = 0;
            }
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    if(w1.charAt(j) != w2.charAt(j)) {
                        int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                        // c1 -> c2, c1 is lexically earlier to c2.
                        if(!adj.get(c1).contains(c2)) {
                            adj.get(c1).add(c2);
                            degree[c2]++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FbAlienOrder ao = new FbAlienOrder();
        String[] words= {"bac", "bad", "abc", "abd", "caa"};
        System.out.print(ao.alienOrder(words));
    }
}
