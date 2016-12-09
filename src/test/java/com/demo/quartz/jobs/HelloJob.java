package com.demo.quartz.jobs;

import org.quartz.*;

/**
 * Created by liliang on 2016/12/9.
 */
public class HelloJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Test");

        JobKey key = context.getJobDetail().getKey();

        //JobDataMap associated the job
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }
}
