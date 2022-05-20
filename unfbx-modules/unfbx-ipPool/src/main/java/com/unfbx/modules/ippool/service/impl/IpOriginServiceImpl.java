package com.unfbx.modules.ippool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.unfbx.common.core.domain.BaseEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.ippool.entity.IpOrigin;
import com.unfbx.modules.ippool.mapper.IpOriginMapper;
import com.unfbx.modules.ippool.service.IpOriginService;

import java.util.List;

@Service
public class IpOriginServiceImpl extends ServiceImpl<IpOriginMapper, IpOrigin> implements IpOriginService {

    @Override
    public List<IpOrigin> queryList() {
        LambdaQueryWrapper<IpOrigin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(IpOrigin::getDeleted, BaseEntity.Deleted.NORMAL.code());
        wrapper.eq(IpOrigin::getStatus, BaseEntity.Status.NORMAL.code());
        return list(wrapper);
    }
}
