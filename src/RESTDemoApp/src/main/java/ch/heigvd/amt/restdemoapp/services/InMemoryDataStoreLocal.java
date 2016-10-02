package ch.heigvd.amt.restdemoapp.services;

import ch.heigvd.amt.restdemoapp.model.Company;
import ch.heigvd.amt.restdemoapp.model.Contract;
import ch.heigvd.amt.restdemoapp.model.Person;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface InMemoryDataStoreLocal {

  public long saveCompany(Company company);
  public Company loadCompany(long id);
  
  public long savePerson(Person person);
  public Person loadPerson(long id);

  public long saveContract(Contract contract);
  public Contract loadContract(long id);

  List<Contract> findAllContracts();
  
}
