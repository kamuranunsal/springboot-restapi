package com.freenow.util;

import com.freenow.domainobject.CarDO;
import com.freenow.domainvalue.EngineType;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import org.apache.catalina.Engine;

import java.util.List;

public class FilterUtil {


    private static List<CarDO> getCarListAccordingToEngineType(List<CarDO> carList, EngineType engineType){
        Predicate<CarDO> byEngine = car -> car.getEngineType() == engineType;

        var results = FluentIterable.from(carList)
                .filter(byEngine)
                .toList();
        return results;
    }

}
