package com.dg.chatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {
	
	public List<Integer> generate(int money){
		if(!isValidMoney(money)) {
			throw new RuntimeException("올바른 금액이 아닙니다.");
		}
		return generate();
	}

	private boolean isValidMoney(int money) {
		return money == 1000;
	}
	
    public List<Integer> generate() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        
        while (numbers.size() < 6) {
            int number = random.nextInt(45) + 1; 
            if (!numbers.contains(number)) { 
                numbers.add(number);
            }
        }
        
        return numbers;
    }
}
