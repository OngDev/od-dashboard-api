package com.ongdev.dashboard;

import com.ongdev.dashboard.models.YoutubeResponse;
import com.ongdev.dashboard.services.YoutubeService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashboardApplication implements CommandLineRunner {
	@Autowired
	YoutubeService youtubeService;
	private Logger logger = LoggerFactory.getLogger(DashboardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("test request: {}", youtubeService.testGetYoutubeApi().toString());

	}
}
