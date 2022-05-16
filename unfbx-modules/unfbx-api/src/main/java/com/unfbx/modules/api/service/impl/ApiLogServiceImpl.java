package com.unfbx.modules.api.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.api.mapper.ApiLogMapper;
import com.unfbx.modules.api.entity.ApiLog;
import com.unfbx.modules.api.service.ApiLogService;
@Service
public class ApiLogServiceImpl extends ServiceImpl<ApiLogMapper, ApiLog> implements ApiLogService{

}
