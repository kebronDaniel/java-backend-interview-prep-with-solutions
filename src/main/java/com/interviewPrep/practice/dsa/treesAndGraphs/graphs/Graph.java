package com.interviewPrep.practice.dsa.treesAndGraphs.graphs;

import java.util.*;

public class Graph {

    private Map<String, Set<String>> adjacencyList;
    private boolean undirected;

    public Graph(boolean undirected) {
        adjacencyList = new HashMap<>();
        this.undirected = undirected;
    }

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(String node){
        adjacencyList.putIfAbsent(node, new HashSet<>());
    }

    public void addEdge(String first, String second){
        addNode(first);
        addNode(second);
        adjacencyList.get(first).add(second);
        if (undirected) adjacencyList.get(second).add(first);
    }

    public Set<String> getNeighbours(String node){
        if (adjacencyList.get(node) == null) throw new IllegalArgumentException("Node not found");
        return adjacencyList.get(node);
    }

    public boolean pathExists(String start, String end){
        if (adjacencyList.get(start) == null || adjacencyList.get(end) == null)
            throw new IllegalArgumentException("Either the start or end node is invalid");

        Set<String> visitedNodes = new HashSet<>();
        return dfs(start,end,visitedNodes);
    }

    private boolean dfs(String current, String end, Set<String> visited){
        if (current.equals(end)) return true;
        visited.add(current);
        var neighbours = getNeighbours(current);
        for (String node: neighbours){
            if (visited.contains(node)) continue;
            var result = dfs(node,end,visited);
            if (result) return true;
        }
        return false;
    }
}
