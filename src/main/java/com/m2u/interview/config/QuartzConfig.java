package com.m2u.interview.config;

import com.m2u.interview.scheduler.FileConsumer;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:application.properties")
public class QuartzConfig {
    @Value("${spring.quartz.properties.file-consumer.cron_schedule}")
    private String fileConsumerCronSchedule;

    @Bean
    public JobDetail fileConsumerTask() {
        return JobBuilder.newJob(FileConsumer.class).withIdentity("fileConsumerTask")
                .storeDurably().build();
    }

    @Bean
    public Trigger triggerFileConsumerDetail(JobDetail fileConsumerTask) {
        return TriggerBuilder.newTrigger().forJob(fileConsumerTask)
                .withIdentity("triggerFileConsumerDetail")
                .withSchedule(CronScheduleBuilder.cronSchedule(fileConsumerCronSchedule))
                .build();
    }

    // @Bean
    // public JobDetail compileAutoDebitInstrumentTask() {
    //     return JobBuilder.newJob(CompileAutoDebitInstrumentTask.class).withIdentity("compileAutoDebitInstrumentTask")
    //             .storeDurably().build();
    // }

    // @Bean
    // public Trigger triggerAutoDebitInstrumentTask(JobDetail compileAutoDebitInstrumentTask) {
    //     return TriggerBuilder.newTrigger().forJob(compileAutoDebitInstrumentTask)
    //             .withIdentity("triggerAutoDebitInstrumentTask")
    //             .withSchedule(CronScheduleBuilder.cronSchedule(compileAutoDebitInstrumentCronSchedule))
    //             .build();
    // }
}