package com.ongdev.dashboard.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ongdev.dashboard.configuration.ApplicationConfig;
import com.ongdev.dashboard.models.YoutubeStatistic;
import com.ongdev.dashboard.services.YoutubeService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

@Service
public class YoutubeServiceImpl implements YoutubeService {
    private final Logger logger = LoggerFactory.getLogger(YoutubeServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ApplicationConfig applicationConfig;

    @PostConstruct
    public void initialize() {
        logger.info("initialize service with config: {}", applicationConfig);
    }

    public YoutubeStatistic getChannelStatistic() throws JsonProcessingException {
        String requestUrl = this.applicationConfig.getRequestUrl() + "channels";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam("part", "statistics")
                .queryParam("key", applicationConfig.getSecretApi())
                .queryParam("id", applicationConfig.getChannel());
        ObjectMapper mapper = new ObjectMapper();
        var response = mapper.writeValueAsString(restTemplate.getForEntity(
                builder.toUriString(), Object.class).getBody());
        YoutubeStatistic res = null;
        if (response != null) {
            var statistic = new JSONObject(response.toString())
                    .getJSONArray("items")
                    .getJSONObject(0).getJSONObject("statistics").toString();
            res = mapper.readValue(statistic, YoutubeStatistic.class);
        }
        return res;
    }


}
