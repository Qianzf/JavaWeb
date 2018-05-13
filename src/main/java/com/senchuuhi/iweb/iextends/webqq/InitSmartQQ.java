package com.senchuuhi.iweb.iextends.webqq;

import com.thankjava.toolkit3d.fastjson.FastJson;
import com.thankjava.wqq.SmartQQClient;
import com.thankjava.wqq.SmartQQClientBuilder;
import com.thankjava.wqq.consts.MsgType;
import com.thankjava.wqq.entity.enums.LoginResultStatus;
import com.thankjava.wqq.entity.msg.Content;
import com.thankjava.wqq.entity.msg.SendMsg;
import com.thankjava.wqq.entity.sys.LoginResult;
import com.thankjava.wqq.extend.ActionListener;
import com.thankjava.wqq.extend.CallBackListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

public class InitSmartQQ {

    private static final Logger logger = LoggerFactory.getLogger(InitSmartQQ.class);

    private SmartQQClientBuilder builder = null;

    public void login() {

        builder = SmartQQClientBuilder.custom(

                // 注册一个通知事件的处理器，它将在SmartQQClient获得到相关信息时被调用执行
                new MessageHandler()
        );

        /**
         * step 2 > 自定义可选参数(为方便查看可选方法，设置参数的函数均以set关键字命名开始)
         */
        builder
                .setAutoGetInfoAfterLogin() // 设置登录成功后立即拉取一些信息
                .setExceptionRetryMaxTimes(3) // 设置如果请求异常重试3次
                .setAutoRefreshQrcode() // 设置若发现登录二维码过期则自动重新拉取
//                .setOffLineListener(new CallBackListener() { // 注册一个离线通知 掉线后将被调用执行
//                    @Override
//                    public void onListener(ActionListener actionListener) {
//                        logger.info("登录的QQ已由掉线无法继续使用(系统已经尝试自动处理)");
//                    }
//                })
        ;


        // A: 声明一个获取到登录二维码的回调函数，将返回二维码的byte数组数据
        CallBackListener getQrListener = new CallBackListener() {

            // login 接口在得到登录二维码时会调用CallBackListener
            // 并且二维码byte[] 数据会通过ListenerAction.data返回

            @Override
            public void onListener(ActionListener actionListener) {

                try {
                    // 将返回的byte[]数据io处理成一张png图片
                    // 位于项目log/qrcode.png
                    ImageIO.write((BufferedImage) actionListener.getData(), "png", new File("E:/qrcode.png"));
                    logger.debug("获取登录二维码完成,手机QQ扫描 ./log/qrcode.png 位置的二维码图片");
                } catch (Exception e) {
                    logger.error("将byte[]写为图片失败", e);
                }

            }
        };

        // B: 声明一个登录结果的函数回调，在登录成功或者失败或异常时进行回调触发
        CallBackListener loginListener = new CallBackListener() {

            // ListenerAction.data 返回登录结果 com.thankjava.wqq.model.sys.LoginResult
            @Override
            public void onListener(ActionListener actionListener) {
                LoginResult loginResult = (LoginResult) actionListener.getData();
                logger.info("登录结果: " + loginResult.getLoginStatus());
                if (loginResult.getLoginStatus() == LoginResultStatus.success) {

                    SmartQQClient smartQQClient = loginResult.getClient();

                    int i = 0;
                    for (i = 0; i < 10; ++i) {
                        Content content = new Content(new Object[]{"刷屏神器 " + i + " | " + new Date()});

                        SendMsg sm = new SendMsg(164772210l, MsgType.group_message, content);
                        smartQQClient.sendMsg(sm);
                    }

                    // TODO: 后续就可以利用smartQQClient调用API
                    logger.info("获取到的好友列表信息: " + FastJson.toJSONString(smartQQClient.getGroupsList(true)));

                }
            }
        };

        // C: 进行登录动作
        builder.createAndLogin(getQrListener, loginListener);
    }

}
