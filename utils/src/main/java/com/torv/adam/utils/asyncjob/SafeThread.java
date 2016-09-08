package com.torv.adam.utils.asyncjob;

import com.torv.adam.utils.log.L;

/**
 * Created by AdamLi on 2016/9/8.
 */
public class SafeThread extends Thread {

    private volatile Thread mBlinker;

    @Override
    public synchronized void start() {
        super.start();
        mBlinker = this;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (mBlinker == thread) {
            try {
                L.d("Thread running E");
                thread.sleep(5000);
                L.d("Thread running X");
            } catch (InterruptedException e) {
                e.printStackTrace();
                L.d("Thread interrupted");
                return;
            }

            try {
                L.d("Thread running E");
                thread.sleep(5000);
                L.d("Thread running X");
            } catch (InterruptedException e) {
                e.printStackTrace();
                L.d("Thread interrupted");
                return;
            }
        }
    }

    public void safeStop() {
        Thread tmpBlinker = mBlinker;
        mBlinker = null;
        if (null != tmpBlinker) {
            /** For block case: sleep(), wait(), read()...*/
            tmpBlinker.interrupt();
        }
    }
}
