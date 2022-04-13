package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> whiskies = whiskyRepository.findByYear(1991);
		assertEquals(1, whiskies.size());
	}

	@Test
	public void canFindByRegion(){
		List<Distillery> distilleries = distilleryRepository.findByRegionIgnoreCase("Speyside");
		assertEquals(3, distilleries.size());
	}

	@Test
	public void canFindByDistAndAge(){
		List<Whisky> whiskies = whiskyRepository.findByAgeAndDistilleryName(15, "Glendronach");
		assertEquals(1, whiskies.size());
	}

	@Test
	public void canFindByDistilleryRegion(){
		List<Whisky> whiskies = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(7, whiskies.size());
	}

	@Test
	public void canFindDistWhiskyLT12(){
		List<Whisky> whiskies = whiskyRepository.findByAgeLessThanEqual(12);
		assertEquals(12, whiskies.size());
	}
}
