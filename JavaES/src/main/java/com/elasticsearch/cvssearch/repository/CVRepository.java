package com.elasticsearch.cvssearch.repository;

import com.elasticsearch.cvssearch.model.Cv;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CVRepository extends ElasticsearchRepository<Cv,String> {

    Iterable<Cv> findByCv(String langage);
}
