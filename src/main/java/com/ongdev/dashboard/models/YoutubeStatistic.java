package com.ongdev.dashboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YoutubeStatistic {


    private String viewCount;
    private String videoCount;
    private String hiddenSubscriberCount;
    private String subscriberCount;

}
