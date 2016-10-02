package ch.heigvd.amt.restdemoapp.services;

import ch.heigvd.amt.restdemoapp.model.Company;
import ch.heigvd.amt.restdemoapp.model.Person;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Stateless
public class TestDataService implements TestDataServiceLocal {

  @EJB
  private HumanResourcesServiceLocal humanResourcesService;

  @EJB
  private InMemoryDataStoreLocal inMemoryDataStore;

  @Override
  public void generateTestData() {
    int numberOfCompanies = 5;
    int minEmployeesPerCompany = 1;
    int maxEmployeesPerCompany = 20;
    for (int i=0; i<numberOfCompanies; i++) {
      Company newCompany = new Company("Company-" + i, "Unknown country");
      long companyId = inMemoryDataStore.saveCompany(newCompany);
      int numberOfEmployees = (int)(Math.random() * (maxEmployeesPerCompany - minEmployeesPerCompany) + minEmployeesPerCompany);
      for (int j=0; j<numberOfEmployees; j++) {
        Person newPerson = new Person("firstName-" + i + "-" + j, "firstName-" + i + "-" + j);
        long personId = inMemoryDataStore.savePerson(newPerson);
        humanResourcesService.hireEmployee(companyId, personId, "worker", 5000, new Date());
      }
    }
    
    
    
    
  }

  
}
