package com.general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid = {
				{2,1,1},
				{1,1,0},
				{0,1,1}};
		//System.out.println(findRottingOrangeCount(grid));
		//System.out.println(orangesRotting(grid));
		
		int[][] grid2 = {
				{2,1,1},
				{0,1,1},
				{1,0,1}};
		//System.out.println(findRottingOrangeCount(grid2));
		//System.out.println(orangesRotting(grid2));
		
		int[][] grid1 = {{0,2}};
		//System.out.println(findRottingOrangeCount(grid1));
		//System.out.println(orangesRotting(grid1));
		
		int[][] grid3 = {
				{2,1,1},
				{1,1,1},
				{0,1,2}};
		//System.out.println(findRottingOrangeCount(grid3));
		//System.out.println(orangesRotting(grid3));

	}
	
	public static int findRottingOrangeCount(int[][] grid) {
		
		Deque<Cell> queue = new LinkedList<Cell>();
		
		//boolean[][] visited = new boolean[grid.length][grid[0].length];
        
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int value = grid[i][j];
				if(value == 2) {
					queue.add(new Cell(i,j, true));	
					//visited[i][j] = true; 
				}
			}
		}
		
		
		Cell sep = new Cell();
		sep.isSeperated=true;
		queue.add(sep);
		
		int count = 0;
		while(!queue.isEmpty()) {
			Cell cell = queue.poll();
			
			if(cell.isSeperated) {
				count = count + 1; continue;
			}
			
			if(grid[cell.row][cell.col] == 0)
				continue;
			
			boolean added = false;
			if(cell.col+1 <= grid[0].length-1 && grid[cell.row][cell.col+1] != 2) { // right
				if(grid[cell.row][cell.col+1] != 0) {
					queue.add(new Cell(cell.row, cell.col+1, true)); added=true;
					grid[cell.row][cell.col+1] = 2;
				}
			}
			if(cell.col-1 >= 0 && grid[cell.row][cell.col-1] != 2) { // left
				if(grid[cell.row][cell.col-1] != 0) {
					queue.add(new Cell(cell.row, cell.col-1, true)); added=true;
					grid[cell.row][cell.col-1] = 2;
				}
			}
			if(cell.row-1 >= 0 && grid[cell.row-1][cell.col] != 2) { //up
				if(grid[cell.row-1][cell.col] != 0) {
					queue.add(new Cell(cell.row-1, cell.col, true)); added=true;
					grid[cell.row-1][cell.col] = 2;
				}
			}
			if(cell.row+1 <= grid.length-1 && grid[cell.row+1][cell.col] != 2) { //down
				if(grid[cell.row+1][cell.col] != 0 ) {
					queue.add(new Cell(cell.row+1, cell.col, true)); added=true;
					grid[cell.row+1][cell.col] = 2;
				}
			}
			if(added) {
				queue.add(sep);
			}
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int value = grid[i][j];
				if(value == 1) {
					return count = -1;
				}
			}
		}
		
		return count;
    }
	
	public static int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty())
                    queue.offer(new Pair(-1, -1));
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS && 
                        neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }
	
	/*
	 * Find all the 2's and push them to the queue with seperator
	 * 
	 * Start processing the queue, when the seperator is found increment the count
	 * 
	 * Take an cell from the queue, take all of their neighbor, check the visited array
	 * if not visited add them, otherwise don't.
	 * 
	 * Keep visited flag, if the cell is visited then don't add them to the queue.
	 * 
	 */

}

class Pair<k, v>{
	Pair(){
		
	}
	Pair(k row, v col){
		this.key = row;
		this.value = col;
	}
	k key;
	v value;
	public k getKey() {
		return key;
	}
	public void setKey(k key) {
		this.key = key;
	}
	public v getValue() {
		return value;
	}
	public void setValue(v value) {
		this.value = value;
	}
	
}

class Cell{
	Cell(int row, int col, boolean visited){
		this.row = row;
		this.col = col;
		this.visited = visited;
	}
	Cell(){
		
	}
	int row;
	int col;
	int value;
	boolean visited;
	boolean isSeperated;
}