package com.unfbx.modules.api.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.api.mapper.ApiDataMapper;
import com.unfbx.modules.api.entity.ApiData;
import com.unfbx.modules.api.service.ApiDataService;
@Service
public class ApiDataServiceImpl extends ServiceImpl<ApiDataMapper, ApiData> implements ApiDataService{

}
