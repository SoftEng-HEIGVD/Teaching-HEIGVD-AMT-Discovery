package ch.heigvd.amt.restdemoapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olivier Liechti
 */
public class Person {

  private final String firstName;
  private final String lastName;

  private final List<Contract> contracts = new ArrayList<>();

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void addContract(Contract contract) {
    this.contracts.add(contract);
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  @Override
  public String toString() {
    return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
  }
  
  

}
