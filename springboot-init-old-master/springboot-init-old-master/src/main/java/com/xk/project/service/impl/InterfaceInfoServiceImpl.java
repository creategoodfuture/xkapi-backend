package com.xk.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xk.project.common.ErrorCode;
import com.xk.project.exception.BusinessException;
import com.xk.project.mapper.InterfaceInfoMapper;
import com.xk.project.model.entity.InterfaceInfo;
import com.xk.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author 86132
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现

*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

        if(interfaceInfo==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);

        }
        String name=interfaceInfo.getName();
        if(add){
            if(StringUtils.isBlank(name)){
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }

        }
        if(StringUtils.isNotBlank(name)&&name.length()>50){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"名称过长");

        }
    }
}




