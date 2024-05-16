package com.dg.chatting;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitTest {

	@DisplayName("로또 번호 갯수 테스트")
	@Test
	void lottoNumberSizeTest() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		int price = 1000;
		
		List<Integer> lottoNumber = lottoNumberGenerator.generate(price);
		
		assertThat(lottoNumber.size(), is(6));
	}
	
    @DisplayName("로또 번호 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        int price = 1000;
        
        List<Integer> lottoNumber = lottoNumberGenerator.generate(price);
        
        assertThat(lottoNumber, everyItem(greaterThanOrEqualTo(1)));
        assertThat(lottoNumber, everyItem(lessThanOrEqualTo(45)));
    }
}
