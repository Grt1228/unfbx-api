package com.unfbx.modules.api.controller;

import com.unfbx.common.core.domain.ServerResponse;
import com.unfbx.modules.api.controller.request.DistanceReq;
import com.unfbx.modules.api.controller.response.DistanceResp;
import com.unfbx.modules.api.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/distance")
    public ServerResponse<DistanceResp> distance(@RequestBody DistanceReq req){
        DistanceResp resp = apiService.distance(req);
        return ServerResponse.success(resp);
    }
}
