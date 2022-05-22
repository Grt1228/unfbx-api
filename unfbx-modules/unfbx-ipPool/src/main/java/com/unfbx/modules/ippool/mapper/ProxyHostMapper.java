package com.unfbx.modules.ippool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unfbx.modules.ippool.entity.ProxyHost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProxyHostMapper extends BaseMapper<ProxyHost> {
    int batchInsert(@Param("list") List<ProxyHost> proxyHosts);
}
