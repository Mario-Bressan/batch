package com.bressan.sample.batch.controller;


import com.bressan.sample.batch.job.JobConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobConfiguration jobConfiguration;

    @GetMapping
    public String lauchJob() {
        try {
            jobConfiguration.jobLaucher();

        } catch (Exception e) {
            log.error("Erro ao iniciar o job. ", e);
            return "Erro ao iniciar o job";
        }
        return "Job running";
    }
}
