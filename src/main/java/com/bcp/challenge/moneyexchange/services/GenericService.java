package com.bcp.challenge.moneyexchange.services;

import com.bcp.challenge.moneyexchange.domain.BaseEntity;
import com.bcp.challenge.moneyexchange.exception.EntityNotFoundException;
import com.bcp.challenge.moneyexchange.validators.ValidatorTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericService<ENTITY extends BaseEntity, DAO extends JpaRepository, VALIDATOR extends ValidatorTemplate<ENTITY>>{

    private final DAO repository;
    private final VALIDATOR validator;

    public GenericService(DAO repository, VALIDATOR validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public ENTITY retrieve(Long id) throws Throwable {
        return (ENTITY) repository.findById(id)
                .orElseThrow(()->{throw new EntityNotFoundException("Entity for id " + id + " does not exist");});
    }

    public List<ENTITY> retrieveAll() {
        return repository.findAll();
    }

    public ENTITY create(ENTITY entity) {
        validator.validate(entity);
        fillDefaults(entity);
        return (ENTITY) repository.save(entity);
    }

    protected void fillDefaults(ENTITY entity){}

    public ENTITY update(ENTITY entity, Long id) {
        validator.validate(entity);
        fillDefaults(entity);
        return (ENTITY) repository.save(entity);
    }

    public void delete(Long id) throws Throwable {
        ENTITY entity = retrieve(id);
        delete(entity);
    }

    public void delete(ENTITY entity) {
        repository.delete(entity);
    }
}
