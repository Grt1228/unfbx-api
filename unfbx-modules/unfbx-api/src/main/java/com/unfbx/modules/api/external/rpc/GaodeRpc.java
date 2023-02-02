package com.unfbx.modules.api.external.rpc;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.unfbx.modules.api.entity.District;
import com.unfbx.modules.api.external.config.GaodeConfig;
import com.unfbx.modules.api.service.DistrictService;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * 高德远程调用.
 **/
@Component
public class GaodeRpc {

  @Autowired
  private GaodeConfig gaodeConfig;
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private DistrictService districtService;

  /**
   * 查询地区信息.
   *
   * @return
   **/
  public JSONObject queryDistrict() {
    LambdaQueryWrapper<District> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.orderByDesc(District::getId);
    queryWrapper.last("limit 1");
    District district = districtService.getOne(queryWrapper);
    if (Objects.isNull(district)) {
      return this.syncDistrict();
    }
    return district.getData();
  }

  /**
   * 同步地区信息.
   *
   * @return 返回json格式的数据.
   */
  public JSONObject syncDistrict() {
    ResponseEntity<JSONObject> responseEntity =
        restTemplate.getForEntity(gaodeConfig.getDistrict().getUrl(), JSONObject.class);
    District district = District.builder()
        .data(responseEntity.getBody())
        .dateNode(new Date())
        .build();
    districtService.save(district);
    return responseEntity.getBody();
  }
}
