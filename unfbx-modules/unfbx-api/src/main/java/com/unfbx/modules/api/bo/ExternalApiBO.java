package com.unfbx.modules.api.bo;

import lombok.Data;

@Data
public class ExternalApiBO {

    private String name;
    private String url;
    private String method;
    private String key;
}
