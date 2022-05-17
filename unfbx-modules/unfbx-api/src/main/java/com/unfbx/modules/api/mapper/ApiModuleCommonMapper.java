package com.unfbx.modules.api.mapper;

import com.unfbx.modules.api.controller.request.DistanceReq;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ApiModuleCommonMapper {

    @Select("SELECT ST_Distance_Sphere(POINT(#{req.longitudeStart}, #{req.latitudeStart}), POINT(#{req.longitudeEnd}, #{req.latitudeEnd})) AS distant")
    Integer selectDistance(@Param("req") DistanceReq req);
}
