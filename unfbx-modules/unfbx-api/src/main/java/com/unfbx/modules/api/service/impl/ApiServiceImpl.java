package com.unfbx.modules.api.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.api.controller.request.DistanceReq;
import com.unfbx.modules.api.controller.request.IpReq;
import com.unfbx.modules.api.controller.response.DistanceResp;
import com.unfbx.modules.api.entity.Api;
import com.unfbx.modules.api.mapper.ApiMapper;
import com.unfbx.modules.api.mapper.ApiModuleCommonMapper;
import com.unfbx.modules.api.service.ApiService;
import com.unfbx.modules.api.service.DistrictService;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

    @Resource
    private ApiModuleCommonMapper apiModuleCommonMapper;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private Ip2regionSearcher regionSearcher;

    @Override
    public DistanceResp distance(DistanceReq req) {
        Integer m = apiModuleCommonMapper.selectDistance(req);
        DistanceResp resp = new DistanceResp();
        resp.setM(m);
        resp.setKm(m.doubleValue() / 1000);
        return resp;
    }

    @Override
    public IpInfo ipToDistrict(IpReq req) {
        IpInfo ipInfo = regionSearcher.btreeSearch(req.getIp());
        return ipInfo;
    }

    @Override
    public JSONObject district() {

//        return districtService.district();
        return null;
    }
}
