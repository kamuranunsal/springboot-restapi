package com.freenow.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freenow.controller.mapper.CarMapper;
import com.freenow.domainobject.CarDO;
import com.freenow.domainvalue.GeoCoordinate;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDTO
{
    private Long id;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;

    private GeoCoordinate coordinate;

    private DriverDTO()
    {
    }


    public DriverDTO(Long id, String username, String password, GeoCoordinate coordinate)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coordinate = coordinate;
    }

    @JsonProperty
    public Long getId()
    {
        return id;
    }


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public GeoCoordinate getCoordinate()
    {
        return coordinate;
    }
}
