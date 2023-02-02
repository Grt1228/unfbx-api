package com.unfbx.modules.api.external.config;

import com.unfbx.modules.api.bo.ExternalApiBO;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "external.gaode")
public class GaodeConfig {

    private ExternalApiBO district;
}
