package com.unfbx.remote.ippool;

import com.unfbx.common.core.constant.ServerNameConstant;
import com.unfbx.common.core.domain.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = ServerNameConstant.IP_POOL_SERVER)
public interface RemoteIpPoolService {


    /**
     * 代理池更新的接口
     * @return
     */
    @GetMapping(value = "/ip-pool/refresh")
    ServerResponse<Void> refreshPool();
}
