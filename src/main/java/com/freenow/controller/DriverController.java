package com.freenow.controller;

import com.freenow.controller.mapper.DriverMapper;
import com.freenow.datatransferobject.DriverDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.EngineType;
import com.freenow.domainvalue.OnlineStatus;
import com.freenow.exception.*;
import com.freenow.service.driver.CarService;
import com.freenow.service.driver.DriverService;

import java.sql.Driver;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * All operations with a driver will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/drivers")
public class DriverController
{

    private final DriverService driverService;

    private final CarService carService;


    @Autowired
    public DriverController(final DriverService driverService, final CarService carService)
    {
        this.driverService = driverService;
        this.carService = carService;
    }


    @GetMapping("/{driverId}")
    public DriverDTO getDriver(@PathVariable long driverId) throws EntityNotFoundException
    {
        return DriverMapper.makeDriverDTO(driverService.find(driverId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO createDriver(@Valid @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException
    {
        DriverDO driverDO = DriverMapper.makeDriverDO(driverDTO);
        return DriverMapper.makeDriverDTO(driverService.create(driverDO));
    }


    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable long driverId) throws EntityNotFoundException
    {
        driverService.delete(driverId);
    }


    @PutMapping("/{driverId}")
    public void updateLocation(
        @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
        throws EntityNotFoundException
    {
        driverService.updateLocation(driverId, longitude, latitude);
    }


    @GetMapping
    public List<DriverDTO> findDrivers(@RequestParam OnlineStatus onlineStatus)
    {
        return DriverMapper.makeDriverDTOList(driverService.find(onlineStatus));
    }

    @PutMapping("/selectCar/{driverId}")
    public DriverDTO selectCar(@PathVariable Long driverId, @RequestParam Long carId) throws EntityNotFoundException, CarAlreadyInUse {
        DriverDO driverDO = driverService.find(driverId);

        if(driverDO.getCarDO()!=null){
            throw new DriverHasAlreadyCar("Driver has already a car license plate with: " + driverDO.getCarDO().getLicensePlate());
        }

        CarDO carDO = carService.find(carId);
        if(carDO.getDriverDO()!=null)
        {
            throw new CarAlreadyInUse("Selected car is already in use by: " + carDO.getDriverDO().getUsername());
        }
        driverDO.setCarDO(carDO);

        return DriverMapper.makeDriverDTO(driverService.update(driverId, driverDO));
    }

    @PutMapping("/deselectCar/{driverId}")
    public DriverDTO deselectCar(@PathVariable Long driverId) throws EntityNotFoundException, DriverHasNoSelectedCar {
        DriverDO driverDO = driverService.find(driverId);

        if(driverDO.getCarDO()==null){
            throw new DriverHasNoSelectedCar("Driver has any selected car " );
        }

        driverDO.setCarDO(null);
        return DriverMapper.makeDriverDTO(driverService.update(driverId,driverDO));

    }

    @GetMapping("/selected_gas_car")
    public List<DriverDTO> getDriverHasGasCar(){
       List<DriverDO> onlineDrivers = driverService.find(OnlineStatus.ONLINE);
       onlineDrivers = onlineDrivers.stream().filter(x->x.getCarDO()!=null).filter(x->x.getCarDO().getEngineType()== EngineType.GAS).collect(Collectors.toList());
       return DriverMapper.makeDriverDTOList(onlineDrivers);

    }

    @GetMapping("/filter_seat_count/{seat_count}")
    public List<DriverDTO> getDriverWhoHasCarWithXSeatCounts(@PathVariable Integer seat_count){

        List<DriverDO> onlineDrivers = driverService.find(OnlineStatus.ONLINE);
        onlineDrivers = onlineDrivers.stream().filter(x->x.getCarDO()!=null).filter(x->x.getCarDO().getSeatCount()>=seat_count).collect(Collectors.toList());
        return DriverMapper.makeDriverDTOList(onlineDrivers);
    }

}
