package com.unfbx.modules.ippool.service;

import com.unfbx.modules.ippool.entity.IpOrigin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IpOriginService extends IService<IpOrigin> {

    List<IpOrigin> queryList();
}
