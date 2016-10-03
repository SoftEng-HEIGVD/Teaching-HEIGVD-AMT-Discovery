package ch.heigvd.amt.restdemoapp.rest.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olivier Liechti
 */
public class PersonDTO {
  
  private String firstName;
  private String lastName;
  private List<String> currentEmployers = new ArrayList<>();
  
  public PersonDTO() {
  }

  public PersonDTO(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<String> getCurrentEmployers() {
    return currentEmployers;
  }
  
  public void addEmployer(String company) {
    currentEmployers.add(company);
  }
  
  

}
