package com.freenow.controller.mapper;

import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CarMapper
{

    public static CarDO makeCarDO(CarDTO carDTO) {
        return new CarDO(carDTO.getLicensePlate(), carDTO.getSeatCount(), carDTO.getConvertible(), carDTO.getRating(), carDTO.getEngineType(), carDTO.getDriverDO(), carDTO.getManufacturerDO());
    }

    public static CarDTO makeCarDTO(CarDO car) {
        return new CarDTO(
            car.getId(), car.getDateCreated(), car.getLicensePlate(), car.getSeatCount(), car.isConvertible(), car.getRating(), car.getEngineType(),
                car.getDriverDO(), car.getManufacturerDO()
        );
    }

    public static List<CarDTO> makeCarDTOList(Collection<CarDO> carDOList){
        return carDOList.stream().map(CarMapper::makeCarDTO).collect(Collectors.toList());
    }
}
