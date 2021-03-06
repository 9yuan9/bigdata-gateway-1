package com.weein.bigdata.core.service.impl;
import com.weein.bigdata.core.service.impl.BaseServiceImpl;
import com.weein.common.base.dao.IBaseMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.weein.bigdata.dao.IBigdataUserOfGroupMapper;
import com.weein.bigdata.core.service.IBigdataUserOfGroupService;
import com.weein.bigdata.base.entity.BigdataUserOfGroupDO;
/**
 *com.weein.bigdata.core.service.impl.IBigdataUserOfGroupServices.java
 *2018-09-30 01:08:56
 * This was class generated by ant velocity
 */
@Service
public class BigdataUserOfGroupServiceImpl extends BaseServiceImpl<BigdataUserOfGroupDO,java.lang.String> implements IBigdataUserOfGroupService{
	 
   @Resource
   private IBigdataUserOfGroupMapper mapper;

   
   @Override
   protected IBaseMapper<BigdataUserOfGroupDO,java.lang.String> getEntityMapper() {
	return mapper;
   }
}
