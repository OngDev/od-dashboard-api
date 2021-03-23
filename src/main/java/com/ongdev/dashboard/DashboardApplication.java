package com.ongdev.dashboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ongdev.dashboard.models.YoutubeStatistic;
import com.ongdev.dashboard.services.impl.YoutubeServiceImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashboardApplication implements CommandLineRunner {
	@Autowired
	YoutubeServiceImpl youtubeService;
	private final Logger logger = LoggerFactory.getLogger(DashboardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	@Override
	public void run(String... args) throws JsonProcessingException {


	}
}
