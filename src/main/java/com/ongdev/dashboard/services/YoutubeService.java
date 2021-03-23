package com.ongdev.dashboard.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ongdev.dashboard.models.YoutubeStatistic;

public interface YoutubeService {

    YoutubeStatistic getChannelStatistic() throws JsonProcessingException;
}
