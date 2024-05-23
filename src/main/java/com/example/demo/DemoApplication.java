package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
            System.out.println("抽奖活动:");
            
            ArrayList prizes = new ArrayList<Prize>(Arrays.asList(new Prize("头等奖", "Iphone"), 
            		new Prize("Prize 2", ""), new Prize("Prize 3", ""), new Prize("Prize 4", ""), 
            		new Prize("Prize 5", ""), new Prize("Prize 6", "")));
            DrawUtil drawUtil = new DrawUtil(prizes, 20);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入任意字符进行抽奖，输入exit退出");
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }
                drawUtil.DrawOne();
            }
        };
	}
}
