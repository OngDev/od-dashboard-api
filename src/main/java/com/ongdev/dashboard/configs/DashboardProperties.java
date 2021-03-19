package com.ongdev.dashboard.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dashboard")
@Getter
@Setter
public class DashboardProperties {
    private String apikey;
    private String channelId;
}
