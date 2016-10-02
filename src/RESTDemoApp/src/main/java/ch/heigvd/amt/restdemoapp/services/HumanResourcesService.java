package ch.heigvd.amt.restdemoapp.services;

import ch.heigvd.amt.restdemoapp.model.Company;
import ch.heigvd.amt.restdemoapp.model.Contract;
import ch.heigvd.amt.restdemoapp.model.Person;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Stateless
public class HumanResourcesService implements HumanResourcesServiceLocal {

  @EJB
  private InMemoryDataStoreLocal inMemoryDataStore;
  
  @Override
  public long hireEmployee(long companyId, long employeeId, String position, int monthlySalary, Date startDate) {
    Company company = inMemoryDataStore.loadCompany(companyId);
    Person employee = inMemoryDataStore.loadPerson(employeeId);
    
    Contract contract = new Contract(company, employee, position, monthlySalary, startDate);
    company.addContract(contract);
    employee.addContract(contract);
    long contractId = inMemoryDataStore.saveContract(contract);
    return contractId;
  }

  @Override
  public List<Contract> getAllContracts() {
    return inMemoryDataStore.findAllContracts();
  }
  
  
  
  
}
