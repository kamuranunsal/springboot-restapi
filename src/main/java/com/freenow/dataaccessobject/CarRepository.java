package com.freenow.dataaccessobject;

import com.freenow.domainobject.CarDO;
import com.freenow.domainvalue.EngineType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarDO,Long> {
    List<CarDO> findByEngineType(EngineType engineType);
}
