package com.freenow.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainobject.ManufacturerDO;
import com.freenow.domainvalue.EngineType;

import java.sql.Driver;
import java.time.ZonedDateTime;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO
{
    private Long id;

    private ZonedDateTime dateCreated;

    @NotNull
    private String licensePlate;

    @NotNull
    private Integer seatCount;

    @NotNull
    private Boolean convertible;

    @NotNull
    private Integer rating;

    private EngineType engineType;

    private DriverDO driverDO;

    private ManufacturerDO manufacturerDO;


    public CarDTO(Long id, ZonedDateTime dateCreated, String licensePlate, Integer seatCount, Boolean convertible, Integer rating, EngineType engineType,  DriverDO driverDO, ManufacturerDO manufacturerDO)
    {
        this.id = id;
        this.dateCreated = dateCreated;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.driverDO= driverDO;
        this.manufacturerDO=manufacturerDO;
    }

    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }


    public Integer getSeatCount()
    {
        return seatCount;
    }


    public void setSeatCount(Integer seatCount)
    {
        this.seatCount = seatCount;
    }


    public Boolean getConvertible()
    {
        return convertible;
    }


    public void setConvertible(Boolean convertible)
    {
        this.convertible = convertible;
    }


    public Integer getRating()
    {
        return rating;
    }


    public void setRating(Integer rating)
    {
        this.rating = rating;
    }


    public EngineType getEngineType()
    {
        return engineType;
    }


    public void setEngineType(EngineType engineType)
    {
        this.engineType = engineType;
    }

    public DriverDO getDriverDO() {
        return driverDO;
    }

    public ManufacturerDO getManufacturerDO() {
        return manufacturerDO;
    }

    public void setDriverDO(DriverDO driverDO) {
        this.driverDO = driverDO;
    }

    public void setManufacturerDO(ManufacturerDO manufacturerDO) {
        this.manufacturerDO = manufacturerDO;
    }
}
