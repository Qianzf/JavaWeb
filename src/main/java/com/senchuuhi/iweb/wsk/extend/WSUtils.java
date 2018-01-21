package com.senchuuhi.iweb.wsk.extend;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

public class WSUtils {

    /**
     * 数据解析器.
     * @param orignCommand
     * @return
     */
    public static String getMessageData(final String orignCommand) {
        //
        int dataIndex = orignCommand.toLowerCase().indexOf("?data=");
        if (dataIndex == -1) {
            return null;
        }
        String data = orignCommand.substring(dataIndex + 6, orignCommand.length());
        return data;
    }

    /**
     * 数据map解析器.
     * @param orignCommand
     * @return
     */
    public static Map getMapFromData(final String orignCommand) {
        if (getMessageData(orignCommand) == null) {
            return null;
        }
        Map mapType = JSON.parseObject(getMessageData(orignCommand), Map.class);
        return mapType;
    }

    /**
     * 数据list解析器.
     * @param orignCommand
     * @return
     */
    public static List<Map> getListFromData(final String orignCommand) {
        if (getMessageData(orignCommand) == null) {
            return null;
        }
        JSONArray jsonArray = JSONArray.fromObject(getMessageData(orignCommand));
        List<Map> mapListJson = (List) jsonArray;
        return mapListJson;
    }

    /**
     * 指令解析器.
     * @param orignCommand
     * @return
     */
    public static String getCommandFromOrignCommand (final String orignCommand) {
        if (orignCommand == null || orignCommand.trim().equals("")) {
            return null;
        }
        String command = orignCommand;
        if (orignCommand.indexOf("?") != -1) {
            command = command.substring(0, command.indexOf("?"));
        }
        return command;
    }

}
