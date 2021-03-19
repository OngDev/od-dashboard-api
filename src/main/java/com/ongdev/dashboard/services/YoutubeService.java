package com.ongdev.dashboard.services;

import com.ongdev.dashboard.configuration.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

@Service
public class YoutubeService {
    private final Logger logger = LoggerFactory.getLogger(YoutubeService.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ApplicationConfig applicationConfig;

    @PostConstruct
    public void initialize(){
        logger.info("initialize service with config: {}", applicationConfig);
    }

    public Object testGetYoutubeApi(){
        
        String requestUrl = this.applicationConfig.getRequestUrl() + "channel";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUrl)
            .queryParam("part", "contentDetails,snippet,statistics")
                .queryParam("key", applicationConfig.getSecretApi());
        return restTemplate.getForEntity(
                builder.toUriString(),Object.class );

    }


}
