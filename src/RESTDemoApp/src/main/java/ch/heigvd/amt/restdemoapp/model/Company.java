package ch.heigvd.amt.restdemoapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olivier Liechti
 */
public class Company {
  
  private final String name;
  private final String country;
  private final List<Contract> contracts = new ArrayList<>();

  public Company(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }
  
  public void addContract(Contract contract) {
    this.contracts.add(contract);
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  @Override
  public String toString() {
    return "Company{" + "name=" + name + ", country=" + country + '}';
  }
  
  
}
