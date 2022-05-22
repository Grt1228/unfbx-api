package com.unfbx.modules.ippool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.ippool.entity.ProxyHost;
import com.unfbx.modules.ippool.mapper.ProxyHostMapper;
import com.unfbx.modules.ippool.service.ProxyHostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 描述：
 *
 * @author grt
 * @date 2022-05-22
 */
@Service
public class ProxyHostServiceImpl extends ServiceImpl<ProxyHostMapper, ProxyHost> implements ProxyHostService {
    @Resource
    private ProxyHostMapper proxyHostMapper;

    @Override
    public int batchAdd(List<ProxyHost> proxyHosts) {
        if (Objects.nonNull(proxyHosts) && proxyHosts.size() >0 ){
            return proxyHostMapper.batchInsert(proxyHosts);
        }
        return 0;
    }
}
