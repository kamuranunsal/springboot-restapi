package com.freenow.service.driver;

import com.freenow.domainobject.CarDO;
import com.freenow.domainvalue.EngineType;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;

import java.util.List;

public interface CarService {

    //Define CRUD operations

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    CarDO find(Long carId) throws EntityNotFoundException;

    CarDO update(Long carId, CarDO carDO) throws EntityNotFoundException;

    void delete(Long carId) throws EntityNotFoundException;

    List<CarDO> findCars();

    List<CarDO> find(EngineType engineType) ;
}
