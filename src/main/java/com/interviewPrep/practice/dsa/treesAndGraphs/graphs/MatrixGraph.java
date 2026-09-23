package com.interviewPrep.practice.dsa.treesAndGraphs.graphs;

import java.util.ArrayList;
import java.util.List;

public class MatrixGraph {

    private int[][] matrix;
    private int rowSize;
    private int columnSize;

    public MatrixGraph(int rowSize, int columnSize) {
        // can place validation not to have exaggerated size.
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        matrix = new int[rowSize][columnSize];
    }

    public void assignNode(int rowPosition, int columnPosition, int value){
        if ((rowPosition >= rowSize || rowPosition < 0)
                || (columnPosition >= columnSize || columnPosition < 0))
            throw new IllegalArgumentException("Invalid node position");
        matrix[rowPosition][columnPosition] = value;
    }

    public List<int[]> getNeighbors(int rowPosition, int columnPosition){
        List<int[]> neighbours = new ArrayList<>();
        // Direction offsets: Up, Down, Left, Right
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int[] point: directions){
            int neighbourRow = rowPosition + point[0];
            int neighbourColumn = columnPosition + point[1];

            // check the boundary
            if ((neighbourRow >= rowSize || neighbourRow < 0)
                    || (neighbourColumn >= columnSize || neighbourColumn < 0)) continue;
            neighbours.add(new int[] {neighbourRow,neighbourColumn});
        }
        return neighbours;
    }

    public int getNumberOfIslands(){

        int numberOfIslands = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    // here we add the number of islands when we get 1 because neighboring 1's (part of the island)
                    // would be taken care of by the dfs method.
                    numberOfIslands = numberOfIslands + 1;
                    dfs(i,j);
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(int rowPosition, int columnPosition){
        //mark this as visited - simply change it to 0 since those are escaped.
        matrix[rowPosition][columnPosition] = 0;
        var neighbors = getNeighbors(rowPosition,columnPosition);
        for (int i = 0; i < neighbors.size(); i++) {
            // get the neighbor and check if the neighbor (which is also part of the matrix)
            // contains 0 or 1 if its 1 it means its a neighbor of another 1
            // (since this method runs in the first place if the element is 1)
            // which means its part of the island so we just mark and continue to get other non 0 neighbors
            // because all are connected islands.
            int[] neighbor = neighbors.get(i);
            if (matrix[neighbor[0]][neighbor[1]] == 1) dfs(neighbor[0], neighbor[1]);
        }
    }

}
