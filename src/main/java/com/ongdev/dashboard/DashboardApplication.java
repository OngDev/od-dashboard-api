package com.ongdev.dashboard;

import com.ongdev.dashboard.models.YoutubeResponse;
import com.ongdev.dashboard.services.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashboardApplication implements CommandLineRunner {
	@Autowired
	YoutubeService youtubeService;

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		youtubeService.testGetYoutubeApi();
	}
}
