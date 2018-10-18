package com.weein.bigdata.activemq.producer;

import com.alibaba.fastjson.JSONObject;

public interface IMessageNotificationMqProducer {
	void sendMessageNotificationMessage(JSONObject object);
}
