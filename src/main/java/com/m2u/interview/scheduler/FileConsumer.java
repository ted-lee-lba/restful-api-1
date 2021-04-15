package com.m2u.interview.scheduler;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.m2u.interview.file.DataFileProcessor;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
public class FileConsumer implements Job {
    private static final Logger logger = LoggerFactory.getLogger(FileConsumer.class);

    @Autowired
    private DataFileProcessor _dataFileProcessor;
    
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        try {
            File dataDir = new File("./file");
            File archiveDir = new File("./file/archive");
            if (!archiveDir.exists()) archiveDir.mkdir();

            File[] dataFiles = dataDir.listFiles();
            if (dataFiles.length <= 0) {
                logger.info("No file found");
                return;
            }
            logger.info("--------File consumer start----------------");
            long start = System.currentTimeMillis();
            for(File dataFile : dataFiles) {
                if (dataFile.isDirectory()) continue;
                _dataFileProcessor.processFile(dataFile.getAbsolutePath());
                File archivFile = new File(archiveDir.getAbsolutePath() + "/" + dataFile.getName());
                Files.move(dataFile.toPath(), archivFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            long end = System.currentTimeMillis();
            logger.info("--------File consumer end----------------");
            logger.info("--------Elapsed Time: {} ----------------", (end - start));
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}