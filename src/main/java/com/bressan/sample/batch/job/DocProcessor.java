package com.bressan.sample.batch.job;


import com.bressan.sample.batch.model.Doc;
import com.bressan.sample.batch.service.DocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@StepScope
@Component
public class DocProcessor implements ItemProcessor<Doc, Doc> {
    @Autowired
    private DocService docService;

    @Override
    public Doc process(Doc doc) throws Exception {
        log.info("Starting process: " + System.currentTimeMillis() + "doc_id: "+ doc.getId());
        doc = docService.docProcessing(doc);
        log.info("Ending   process: " + System.currentTimeMillis() + "doc_id: "+ doc.getId());
        return doc;
    }
}
