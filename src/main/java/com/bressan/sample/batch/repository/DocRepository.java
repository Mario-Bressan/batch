package com.bressan.sample.batch.repository;

import com.bressan.sample.batch.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Doc, Integer> {
}
