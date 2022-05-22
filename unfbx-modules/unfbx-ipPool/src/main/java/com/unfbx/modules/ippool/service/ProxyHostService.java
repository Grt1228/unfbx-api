package com.unfbx.modules.ippool.service;

import com.unfbx.modules.ippool.entity.ProxyHost;

import java.util.List;

public interface ProxyHostService {

    int batchAdd(List<ProxyHost> proxyHosts);
}
