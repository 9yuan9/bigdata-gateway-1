package com.weein.bigdata.core.service.impl;
import com.weein.bigdata.core.service.impl.BaseServiceImpl;
import com.weein.common.base.dao.IBaseMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.weein.bigdata.dao.IBigdataGroupInfoMapper;
import com.weein.bigdata.core.service.IBigdataGroupInfoService;
import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
/**
 *com.weein.bigdata.core.service.impl.IBigdataGroupInfoServices.java
 *2018-09-30 12:57:22
 * This was class generated by ant velocity
 */
@Service
public class BigdataGroupInfoServiceImpl extends BaseServiceImpl<BigdataGroupInfoDO,java.lang.String> implements IBigdataGroupInfoService{
	 
   @Resource
   private IBigdataGroupInfoMapper mapper;

   
   @Override
   protected IBaseMapper<BigdataGroupInfoDO,java.lang.String> getEntityMapper() {
	return mapper;
   }
}