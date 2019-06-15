package com.bressan.sample.batch.service;


import com.bressan.sample.batch.model.Doc;
import com.bressan.sample.batch.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocService {

    public Doc docProcessing(Doc doc) {
        ThreadSleep.startThread();
        doc.setDescricao(doc.getDescricao().toUpperCase());
        return doc;
    }
}
