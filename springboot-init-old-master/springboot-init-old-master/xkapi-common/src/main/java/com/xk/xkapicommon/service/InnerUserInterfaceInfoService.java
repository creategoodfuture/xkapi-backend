package com.xk.xkapicommon.service;


import com.baomidou.mybatisplus.extension.service.IService;

import com.xk.xkapicommon.service.model.entity.UserInterfaceInfo;

/**
* @author 86132
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-05-10 15:26:36
*/
public interface InnerUserInterfaceInfoService {




    boolean invokeCount(long interfaceInfoId, long userId);
}
