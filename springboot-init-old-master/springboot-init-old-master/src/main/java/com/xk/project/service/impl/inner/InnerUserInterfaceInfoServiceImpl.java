package com.xk.project.service.impl.inner;

import com.xk.project.service.UserInterfaceInfoService;
import com.xk.xkapicommon.service.InnerUserInterfaceInfoService;

import com.xk.xkapicommon.service.model.entity.UserInterfaceInfo;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;


@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;


    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
