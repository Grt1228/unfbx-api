package com.unfbx.modules.api.controller;

import com.alibaba.fastjson2.JSONObject;
import com.unfbx.common.core.domain.ServerResponse;
import com.unfbx.modules.api.controller.request.DistanceReq;
import com.unfbx.modules.api.controller.request.IpReq;
import com.unfbx.modules.api.controller.response.DistanceResp;
import com.unfbx.modules.api.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/distance")
    public ServerResponse<DistanceResp> distance(@RequestBody @Valid DistanceReq req){
        DistanceResp resp = apiService.distance(req);
        return ServerResponse.success(resp);
    }

    @PostMapping(value = "/ip")
    public ServerResponse<String> ipToDistrict (@RequestBody @Valid IpReq req){
        IpInfo resp = apiService.ipToDistrict(req);
        return ServerResponse.success(resp.getAddressAndIsp());
    }

    @PostMapping(value = "/district")
    public ServerResponse<JSONObject> district (){
        JSONObject resp = apiService.district();
        return ServerResponse.success(resp);
    }
}
