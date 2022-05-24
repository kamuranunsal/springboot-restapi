package com.freenow.dataaccessobject;

import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.OnlineStatus;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface DriverRepository extends CrudRepository<DriverDO, Long>
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);
}
