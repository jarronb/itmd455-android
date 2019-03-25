package com.example.bailey.journeyhome.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baile on 12/4/2017.
 */

public class Task{
    public String getRealtor() {
        return realtor;
    }

    public void setRealtor(String realtor) {
        this.realtor = realtor;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public List<ToDoData> getTask() {
        return task;
    }

    public void setTask(List<ToDoData> task) {
        this.task = task;
    }

    private String realtor;
    private String buyer;
    private List<ToDoData> task;

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID++;
    }

    private int TaskID;

    public ToDoData getTask(int taskID, String realtor, String buyer){
        ArrayList<Task> tasks = null;
        this.TaskID=taskID;
        this.realtor = realtor;
        this.buyer = buyer;


        return (ToDoData)tasks.get(TaskID).getTask();

    }
}
