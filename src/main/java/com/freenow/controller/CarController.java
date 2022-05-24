package com.freenow.controller;

import com.freenow.controller.mapper.CarMapper;
import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.domainvalue.EngineType;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.service.driver.CarService;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException {
        CarDO carDO = CarMapper.makeCarDO(carDTO);
        return CarMapper.makeCarDTO(carService.create(carDO));
    }

    @GetMapping("/{id}")
    public CarDTO getCar(@PathVariable Long carId) throws EntityNotFoundException {
        return CarMapper.makeCarDTO(carService.find(carId));
    }

    @GetMapping
    public List<CarDTO> getCars() {
        return CarMapper.makeCarDTOList(carService.findCars());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JSONObject> deleteCar(@PathVariable Long carId) throws EntityNotFoundException {
        carService.delete(carId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("actionStatus", "car is deleted succesfully");
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    @GetMapping("filter_engine_type")
    public List<CarDTO> getCarListAccordingToEngineType(@RequestParam EngineType engineType){
        return CarMapper.makeCarDTOList(carService.find(engineType));
    }
}
