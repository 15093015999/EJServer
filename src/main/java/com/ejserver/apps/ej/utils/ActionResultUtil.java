package com.ejserver.apps.ej.utils;
/**
 * ActionResultUtil
 */
public class ActionResultUtil {

    public static ActionResult success(String msg,Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setStatus(200);
        actionResult.setMessage(msg);
        actionResult.setData(data);
        actionResult.setTimestamp(System.currentTimeMillis());
        return actionResult;
    }

    public static ActionResult success(String msg) {
        ActionResult actionResult = new ActionResult();
        actionResult.setStatus(200);
        actionResult.setMessage(msg);
        actionResult.setTimestamp(System.currentTimeMillis());
        return actionResult;
    }

    public static ActionResult error(String msg) {
        ActionResult actionResult = new ActionResult();
        actionResult.setStatus(500);
        actionResult.setMessage(msg);
        actionResult.setTimestamp(System.currentTimeMillis());
        return actionResult;
    }
    public static ActionResult error(int code,String msg) {
        ActionResult actionResult = new ActionResult();
        actionResult.setStatus(code);
        actionResult.setMessage(msg);
        actionResult.setTimestamp(System.currentTimeMillis());
        return actionResult;
    }
}