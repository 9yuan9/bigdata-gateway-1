package com.weein.bigdata.activemq.producer;

import com.weein.bigdata.base.entity.MyOrderDO;

public interface IOrderChangeMqProducer {
	void sendOrderChangeMessage(MyOrderDO myOrderDO);
}
