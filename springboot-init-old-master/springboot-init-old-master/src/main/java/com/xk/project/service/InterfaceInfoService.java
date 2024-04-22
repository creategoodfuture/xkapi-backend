package com.xk.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xk.project.model.entity.InterfaceInfo;


/**
* @author 86132
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-04-18 13:15:38
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean b);
}
