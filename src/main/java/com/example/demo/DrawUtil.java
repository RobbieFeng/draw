package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DrawUtil {
	private List<Prize> prizes;
	private int nPeople;
	private int alreadyDrawn;

	public Map<String, Prize> result = new java.util.HashMap<String, Prize>();
	
	public DrawUtil(int nPrize, int nPeople) {
		this.nPeople = nPeople;
		this.prizes = new ArrayList<Prize>();
		for (int i = 0; i < nPrize; i++) {
			prizes.add(new Prize("Prize " + i, ""));
		}
		this.alreadyDrawn = 0;
	}

	public DrawUtil(List<Prize> prizes, int nPeople) {
		this.nPeople = nPeople;
		this.prizes = prizes;
		this.alreadyDrawn = 0;
	}
	
	public void DrawOne(String name) {
		//可能不公平，但模拟现场用抽奖箱
		//Check if all attendees have drawn
		if (alreadyDrawn == nPeople) {
			System.out.println("所有人都已经抽过奖了！");
			return;
		}
		
		// generate a random number between 0 and nPeople-alreadyDrawn, if the number is less than the number of prizes, get the prize
		Random random = new Random();
		int randomint = random.nextInt(nPeople-alreadyDrawn);;
		if (randomint < prizes.size()) {
			// Win
			System.out.println("**********************************************************************");
			System.out.println("恭喜! 你获得 " + prizes.get(randomint));
			System.out.println("**********************************************************************");
			System.out.println("剩余人数: " + (nPeople-alreadyDrawn-1));
			// Add the winner to the list
			result.put("Winner " + alreadyDrawn, prizes.get(randomint));
			prizes.remove(randomint);
			alreadyDrawn++;
			
		} else {
			//Lose
			System.out.println("**********************************************************************");
			System.out.println("很遗憾. 您没有获得奖品");
			System.out.println("**********************************************************************");
			System.out.println("剩余人数: " + (nPeople-alreadyDrawn-1));
			alreadyDrawn++;
		}
		
	}

	public void printList() {
		for (String key : result.keySet()) {
			System.out.println(key + ": " + result.get(key));
		}
		
	}
	
}
