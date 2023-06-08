package com.unfbx.jd.asynctool.my;

/**
 * 包装器
 */
public class Wrapper {

    private String param;
    private Work work;
    private CallBack callBack;


    public void callBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public String getParam() {
        return param;
    }

    public Work getWork() {
        return work;
    }

    public CallBack getCallBack() {
        return callBack;
    }
}
