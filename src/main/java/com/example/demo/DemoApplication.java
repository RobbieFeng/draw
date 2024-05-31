package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("抽奖活动:");
        
        ArrayList prizes = new ArrayList<Prize>(Arrays.asList(new Prize("头等奖", "Iphone"), 
        		new Prize("Prize 2", "￥1000"), new Prize("Prize 2", "￥1000"), new Prize("Prize 3", "￥500"), 
        		new Prize("Prize 3", "￥500"), new Prize("Prize 4", "￥100")));
        DrawUtil drawUtil = new DrawUtil(prizes, 20);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入昵称进行抽奖，输入list查看中奖名单，输入exit退出。");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            if (input.equals("list")) {
                System.out.println("中奖名单:");
                drawUtil.printList();
                continue;
               }
            drawUtil.DrawOne(input);
	}
	

}}
