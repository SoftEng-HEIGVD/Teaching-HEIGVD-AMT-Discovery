package ch.heigvd.amt.restdemoapp.services;

import ch.heigvd.amt.restdemoapp.model.Company;
import ch.heigvd.amt.restdemoapp.model.Contract;
import ch.heigvd.amt.restdemoapp.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Singleton
public class InMemoryDataStore implements InMemoryDataStoreLocal {

  private long companyIdCounter = 0;
  private long personIdCounter = 0;
  private long contractIdCounter = 0;

  private final Map<Long, Company> companies = new HashMap<>();
  private final Map<Long, Person> people = new HashMap<>();
  private final Map<Long, Contract> contracts = new HashMap<>();

  @Override
  @Lock(LockType.READ)
  public long saveCompany(Company company) {
    companyIdCounter++; // is this thread safe?
    try {
      Thread.sleep(500);
    } catch (InterruptedException ex) {
      Logger.getLogger(InMemoryDataStore.class.getName()).log(Level.SEVERE, null, ex);
    }
    companies.put(companyIdCounter, company);
    return companyIdCounter;
  }

  @Override
  public Company loadCompany(long id) {
    return companies.get(id);
  }

  @Override
  public long savePerson(Person company) {
    personIdCounter++; // is this thread safe?
    people.put(personIdCounter, company);
    return personIdCounter;
  }

  @Override
  public Person loadPerson(long id) {
    return people.get(id);
  }

  @Override
  public long saveContract(Contract contract) {
    contractIdCounter++; // is this thread safe?
    contracts.put(contractIdCounter, contract);
    return contractIdCounter;
  }

  @Override
  public Contract loadContract(long id) {
    return contracts.get(id);
  }

  @Override
  public List<Contract> findAllContracts() {
    return new ArrayList(contracts.values());
  }

  @Override
  public List<Person> findAllPeople() {
    return new ArrayList(people.values());
  }

  @Override
  public List<Company> findAllCompanies() {
    return new ArrayList(companies.values());
  }
  
}
