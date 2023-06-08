package com.unfbx.jd.asynctool.my;

public class TestThread {

    public static void main(String[] args) {

        TestThread main = new TestThread();
        Work work = main.newWork();

        Wrapper wrapper = new Wrapper();
        wrapper.setWork(work);
        wrapper.setParam("hello world!");
        wrapper.callBack(new CallBack() {
            @Override
            public void result(Object obj) {
                System.out.println("result："+ obj.toString());
            }
        });
        main.doWork(wrapper);
    }

    private Work newWork() {
        Work work = new Work() {
            @Override
            public String action(String param) {
                System.out.println("work开始参数：" + param + "~~~~~~~~~~~~~~~~~~~~~");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("work结束~~~~~~~~~~~~~~~~~~~~~");
                return "成功";
            }
        };
        return work;
    }

    private void doWork(Wrapper wrapper){
        new Thread(() -> {
            Work work = wrapper.getWork();
            String result = work.action(wrapper.getParam());
            wrapper.getCallBack().result(result);
        }).start();
    }
}
