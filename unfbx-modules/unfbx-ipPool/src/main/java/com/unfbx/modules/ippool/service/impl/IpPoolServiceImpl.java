package com.unfbx.modules.ippool.service.impl;

import com.unfbx.modules.ippool.entity.IpOrigin;
import com.unfbx.modules.ippool.service.IpOriginService;
import com.unfbx.modules.ippool.service.IpPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpPoolServiceImpl implements IpPoolService {
    @Autowired
    private IpOriginService ipOriginService;

    @Override
    public void refreshPool() {
        List<IpOrigin> ipOrigins = ipOriginService.queryList();
        ipOrigins.forEach(e -> {

        });

    }
}
