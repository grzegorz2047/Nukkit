package cn.nukkit.scheduler;

import cn.nukkit.Server;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class AsyncTask extends Thread {

    private Object result;
    private int taskId;
    private boolean finished = false;
    private boolean cancelRun = false;

    public void run() {
        this.result = null;
        if (!this.cancelRun) {
            this.onRun();
        }
        this.finished = true;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public Object getResult() {
        return this.result;
    }

    public boolean hasResult() {
        return this.result != null;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public abstract void onRun();

    public void onCompletion(Server server) {

    }

    public void cleanObject() {
        this.result = null;
        this.taskId = 0;
        this.finished = false;
    }
}
