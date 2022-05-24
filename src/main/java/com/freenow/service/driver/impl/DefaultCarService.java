package com.freenow.service.driver.impl;

import com.freenow.dataaccessobject.CarRepository;
import com.freenow.domainobject.CarDO;
import com.freenow.domainvalue.EngineType;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.service.driver.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultCarService implements CarService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    CarRepository carRepository;

    public DefaultCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException {
        CarDO car;

        try {
            car = carRepository.save(carDO);
        } catch (DataIntegrityViolationException e) {
            LOG.error("ConstraintsViolationException while creating a new car {} ", carDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }

    @Override
    public void delete(Long carId) throws EntityNotFoundException {
        CarDO carDO=find(carId);
        carRepository.delete(carDO);
    }

    @Override
    public CarDO find(Long carId) throws EntityNotFoundException {
        return carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Could not find car with id: " + carId));
    }

    @Override
    public CarDO update(Long carId, CarDO carDO) throws EntityNotFoundException{

        CarDO carToEdit= find(carId);
        carToEdit.setDriverDO(carDO.getDriverDO());
        return carToEdit;
    }

    @Override
    public List<CarDO> findCars() {
        return StreamSupport.stream(carRepository.findAll().spliterator(),false).filter(x->!x.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public List<CarDO> find(EngineType engineType) {
        return carRepository.findByEngineType(engineType);
    }

}
