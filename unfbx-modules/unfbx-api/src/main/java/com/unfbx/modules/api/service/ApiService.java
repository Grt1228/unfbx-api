package com.unfbx.modules.api.service;

import com.unfbx.modules.api.controller.request.DistanceReq;
import com.unfbx.modules.api.controller.request.IpReq;
import com.unfbx.modules.api.controller.response.DistanceResp;
import com.unfbx.modules.api.entity.Api;
import com.baomidou.mybatisplus.extension.service.IService;
import net.dreamlu.mica.ip2region.core.IpInfo;

public interface ApiService extends IService<Api>{
    /**
     * 经纬度距离计算
     * @param req
     * @return
     */
    DistanceResp distance(DistanceReq req);

    /**
     * ip地址转换地区
     * @param req
     * @return
     */
    IpInfo ipToDistrict(IpReq req);
}
