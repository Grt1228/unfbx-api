package com.unfbx.modules.ippool.controller;

import com.unfbx.common.core.domain.ServerResponse;
import com.unfbx.modules.ippool.service.IpPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class IpPoolController {

    @Autowired
    private IpPoolService ipPoolService;

    @GetMapping(value = "/refresh")
    public ServerResponse<Void> refreshPool(){
        ipPoolService.refreshPool();
        return ServerResponse.success();
    }
}
