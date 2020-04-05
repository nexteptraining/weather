package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nextep.weather.WeatherDataFeedRepository;

@SpringBootTest
public class WeatherDataFeedRepositoryTest {
	
	@Autowired
	private WeatherDataFeedRepository dao;

	
	@Test
	public void test() throws Exception {
		
		dao.populateFeedIntoDatabase();
		
	}
	
	
}
