package com.senchuuhi.iweb.iextend.webqq;

import com.thankjava.wqq.SmartQQClient;
import com.thankjava.wqq.entity.msg.PollMsg;
import com.thankjava.wqq.extend.NotifyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageHandler implements NotifyListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handler(SmartQQClient smartQQClient, PollMsg pollMsg) {
        log.info("收到消息：" + pollMsg.toGetMsgText() + " | " + pollMsg.getFrom());
    }
}
