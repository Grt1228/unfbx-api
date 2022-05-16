package com.unfbx.modules.api.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unfbx.modules.api.entity.Api;
import com.unfbx.modules.api.mapper.ApiMapper;
import com.unfbx.modules.api.service.ApiService;
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService{

}
