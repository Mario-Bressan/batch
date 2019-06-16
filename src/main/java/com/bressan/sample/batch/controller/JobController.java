package com.bressan.sample.batch.controller;

import com.bressan.sample.batch.service.DocService;
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
    private DocService docService;

    @GetMapping
    public String lauchJob() {
        return docService.startJob();
    }
}
