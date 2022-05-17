package com.unfbx.modules.api.service.impl;

import com.unfbx.modules.api.controller.request.DistanceReq;
import com.unfbx.modules.api.controller.response.DistanceResp;
import com.unfbx.modules.api.mapper.ApiModuleCommonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.api.entity.Api;
import com.unfbx.modules.api.mapper.ApiMapper;
import com.unfbx.modules.api.service.ApiService;

@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

    @Resource
    private ApiModuleCommonMapper apiModuleCommonMapper;

    @Override
    public DistanceResp distance(DistanceReq req) {
        Integer m = apiModuleCommonMapper.selectDistance(req);
        DistanceResp resp = new DistanceResp();
        resp.setM(m);
        resp.setKm(m.doubleValue() / 1000);
        return resp;
    }
}
