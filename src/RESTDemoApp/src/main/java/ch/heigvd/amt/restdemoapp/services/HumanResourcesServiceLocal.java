package ch.heigvd.amt.restdemoapp.services;

import ch.heigvd.amt.restdemoapp.model.Contract;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface HumanResourcesServiceLocal {

  public long hireEmployee(long companyId, long employeeId, String position, int monthlySalary, Date startDate);

  List<Contract> getAllContracts();
  
}
