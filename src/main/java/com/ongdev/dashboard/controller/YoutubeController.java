package com.ongdev.dashboard.controller;

import com.ongdev.dashboard.models.YoutubeStatistic;
import com.ongdev.dashboard.services.YoutubeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube/")
public class YoutubeController {
    private final Logger logger = LoggerFactory.getLogger(YoutubeController.class);

    @Autowired
    YoutubeService youtubeService;

    @GetMapping("statistic")
    public YoutubeStatistic getYoutubeStatistic() {
        logger.info("Getting Youtube statistic...");
        YoutubeStatistic res = null;
        try {
            res = youtubeService.getChannelStatistic();
        } catch (Exception e) {
            logger.error("Error when getting YoutubeStatistic ", e);
        }
        return res;
    }
}
