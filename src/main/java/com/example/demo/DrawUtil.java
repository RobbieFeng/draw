package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawUtil {
	private List<Prize> prizes;
	private int nPeople;
	private int alreadyDrawn;
	
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
	
	public void DrawOne() {
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
			System.out.println("Congratulations! You have won " + prizes.get(randomint).name);
			System.out.println("Description: " + prizes.get(randomint).description);
			System.out.println("**********************************************************************");
			System.out.println("People left: " + (nPeople-alreadyDrawn-1));
			prizes.remove(randomint);
			alreadyDrawn++;
		} else {
			//Lose
			System.out.println("**********************************************************************");
			System.out.println("Sorry, you have not won any prize.");
			System.out.println("**********************************************************************");
			System.out.println("People left: " + (nPeople-alreadyDrawn-1));
			alreadyDrawn++;
		}
		
	}
	
}
