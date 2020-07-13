package com.test_task.translator.repository;

import com.test_task.translator.model.Translations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslatorRepository extends CrudRepository<Translations, Long> {

}
