package com.bressan.sample.batch.service;

import com.bressan.sample.batch.job.JobConfiguration;
import com.bressan.sample.batch.model.Doc;
import com.bressan.sample.batch.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocService {
    @Autowired
    JobConfiguration jobConfiguration;

    public Doc docProcessing(Doc doc) {
        ThreadSleep.startThread();
        doc.setDescription(doc.getDescription().toUpperCase());
        return doc;
    }

    public String startJob() {
        try {
            jobConfiguration.jobLaucher();
        } catch (Exception e) {
            log.error("Fail to start job", e);
            return "Fail to start job";
        }
        return "Job started";
    }
}
