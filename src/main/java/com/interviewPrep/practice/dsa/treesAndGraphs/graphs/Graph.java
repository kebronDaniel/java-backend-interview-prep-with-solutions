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

    public boolean detectCycleForDirectedGraph(){

        Map<String, Integer> states = new HashMap<>();
        for (String element: adjacencyList.keySet()){
            // you skip because once you open a node you would see it and all its neighbors and go through all the paths
            // thus you not only know the path from which you started but also the path of unvisited nodes as well.
            // so there is no need to visit them again.
            // this also helps detect unrelated or separated graphs.(you finish one path and go to the next starting from another node.)
            if (states.getOrDefault(element,0) == 2) continue;
            var result = detectCycle(element,states);
            if (result) return true;
        }
        return false;
    }

    // the whole idea is that what happens if I follow the path, would I return to the same node that I am visiting
    // or any node that I have started visiting.
    // thus if there is a cycle then you would try to visit the same node which you have visited.
    private boolean detectCycle(String current,Map<String, Integer> states){
        states.put(current,1);
        // get its neighbors
        var neighbors = getNeighbours(current);
        for (String neighbor: neighbors){
            if (states.getOrDefault(neighbor,0) == 1) return true;
            else if (states.getOrDefault(neighbor,0) == 2) {
                continue;
            }
            // the recursion is like saying if this node is not visit it take me to all unvisited nodes from this on.
            // if the path would eventually get back here it means there is a cycle.
            if (detectCycle(neighbor,states)) return true;
        }
        states.put(current,2);
        return false;
    }
}
