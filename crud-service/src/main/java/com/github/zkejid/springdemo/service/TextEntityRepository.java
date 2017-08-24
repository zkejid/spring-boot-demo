package com.github.zkejid.springdemo.service;

import com.github.zkejid.springdemo.entities.TextEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * TextEntity repository. Defines basic CRUD operations on {@link TextEntity}.
 */
public interface TextEntityRepository extends CrudRepository<TextEntity, Long> {
}