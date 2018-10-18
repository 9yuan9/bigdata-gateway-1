package com.weein.bigdata.base.vo;


import java.util.List;

import com.weein.bigdata.base.entity.MinipOpenidDO;
import com.weein.bigdata.base.entity.MinipThirdPartyBindDO;
import com.weein.bigdata.base.entity.MinipUserDO;
import com.weein.bigdata.base.entity.MinipUserMyselfBindDO;

public class MyUserDataVo {

	private List<MinipOpenidDO> minipOpenidDOs;
	
	private MinipUserDO minipUserDO;
	
	private MinipUserMyselfBindDO minipUserMyselfBindDO;
	
	private MinipThirdPartyBindDO minipThirdPartyBindDO;

	public MinipUserDO getMinipUserDO() {
		return minipUserDO;
	}

	public void setMinipUserDO(MinipUserDO minipUserDO) {
		this.minipUserDO = minipUserDO;
	}

	public MinipUserMyselfBindDO getMinipUserMyselfBindDO() {
		return minipUserMyselfBindDO;
	}

	public void setMinipUserMyselfBindDO(MinipUserMyselfBindDO minipUserMyselfBindDO) {
		this.minipUserMyselfBindDO = minipUserMyselfBindDO;
	}

	public MinipThirdPartyBindDO getMinipThirdPartyBindDO() {
		return minipThirdPartyBindDO;
	}

	public void setMinipThirdPartyBindDO(MinipThirdPartyBindDO minipThirdPartyBindDO) {
		this.minipThirdPartyBindDO = minipThirdPartyBindDO;
	}

	public List<MinipOpenidDO> getMinipOpenidDOs() {
		return minipOpenidDOs;
	}

	public void setMinipOpenidDOs(List<MinipOpenidDO> minipOpenidDOs) {
		this.minipOpenidDOs = minipOpenidDOs;
	}
	
	
}
