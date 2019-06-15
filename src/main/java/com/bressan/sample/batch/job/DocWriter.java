package com.bressan.sample.batch.job;

import com.bressan.sample.batch.model.Doc;
import com.bressan.sample.batch.repository.DocRepository;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@StepScope
@Component
public class DocWriter implements ItemWriter<Doc> {
    @Autowired
    DocRepository docRepository;

    @Override
    public void write(List<? extends Doc> list) throws Exception {
        docRepository.saveAll(list);
    }
}
