package com.unfbx.modules.api.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.api.mapper.DistrictMapper;
import com.unfbx.modules.api.entity.District;
import com.unfbx.modules.api.service.DistrictService;
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements DistrictService{

}
