package com.freenow.controller.mapper;

import com.freenow.datatransferobject.DriverDTO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.GeoCoordinate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DriverMapper
{
    public static DriverDO makeDriverDO(DriverDTO driverDTO)
    {
        return new DriverDO(driverDTO.getUsername(), driverDTO.getPassword());
    }


    public static DriverDTO makeDriverDTO(DriverDO driverDO)
    {
        return new DriverDTO(driverDO.getId(), driverDO.getUsername(), driverDO.getPassword(), driverDO.getCoordinate());
    }


    public static List<DriverDTO> makeDriverDTOList(Collection<DriverDO> drivers)
    {
        return drivers.stream()
            .map(DriverMapper::makeDriverDTO)
            .collect(Collectors.toList());
    }
}
