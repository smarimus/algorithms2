package com.companies.bill;

import java.util.List;

public class FillPage {
	
	static int MAX_WIDTH =10;

	public static void main(String[] args) {
		
		Block b = new Block(2,2,0,0);
		Block b2 = new Block(3,6,0,0);
		Block b3 = new Block(4,3,0,0);
		Block b4 = new Block(3,4,0,0);
		Block b5 = new Block(2,5,0,0);
		Block b6 = new Block(3,2,0,0);
		Block b7 = new Block(3,1,0,0);
		
		List<Block> blocks = List.of(b,b2,b3,b4,b5,b6,b7);
		List<Block> res = fillPage(blocks);
		
		res.forEach(block -> {
			System.out.println(block.x + "," + block.y);
			//System.out.print("");
		} );
	}
	
	// was struggle with the train of thought
	// lots of race condition, was trying to solve everything together.
	// 
	
	public static List<Block> fillPage(List<Block> list) {
		int preHeight = 0;
		int width=0;
		int height=0;
		
		int sum =0;
		for(int i=0; i< list.size(); i++) {
			Block block = list.get(i);
			
			sum = width + block.width;
			
			if(sum < MAX_WIDTH) {
				block.x = width;		//0, 2, 5, etc
				block.y = preHeight;    //0, 0, 0, etc
				width = width + block.width;
				
				height = Math.max(height, block.height);
			}else {
				preHeight = height + preHeight;
				width=0;
				sum=0;
				height =0;
				i--;
			}
		}
		return list;
	}
}

class Block{
	int width;
	int height;
	int x;
	int y;
	
	Block(int width, int height, int x, int y){
		this.width = width;
		this.height = height;
		this.x=x;
		this.y=y;
	}
}
