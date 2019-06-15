package com.bressan.sample.batch.job;

import com.bressan.sample.batch.model.Doc;
import com.bressan.sample.batch.repository.DocRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@StepScope
@Component
public class DocReader implements ItemReader<Doc> {

    private Boolean firstReading = Boolean.TRUE;
    private int index;
    private List<Doc> docList;

    @Autowired
    DocRepository docRepository;

    @Override
    public synchronized Doc read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (firstReading) {
            this.docList = initialize();
            firstReading = Boolean.FALSE;
        }
        Doc doc = null;
        if(index < docList.size()) {
            doc = docList.get(index);
            index++;
        }
        return doc;
    }

    private List<Doc> initialize() {
        log.info("Reading docs from database");

        List<Doc> docs = docRepository.findAll();
        return docs;
    }

}
