package ch.heigvd.amt.restdemoapp.model;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Olivier Liechti
 */
public class Contract {
  
  private final Company company;
  private final Person employee;
  private final String position;
  private final int monthlySalary;
  private final Date startDate;
  private Date endDate;
  private final String contractId = UUID.randomUUID().toString();

  public Contract(Company company, Person employee, String position, int monthlySalary, Date startDate) {
    this.company = company;
    this.employee = employee;
    this.position = position;
    this.monthlySalary = monthlySalary;
    this.startDate = startDate;
  }

  public String getContractId() {
    return contractId;
  }
  
  public Company getCompany() {
    return company;
  }

  public Person getEmployee() {
    return employee;
  }

  public String getPosition() {
    return position;
  }
  
  public int getMonthlySalary() {
    return monthlySalary;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  
  public boolean isActive() {
    if (startDate == null) {
      return false;
    }
    Date today = new Date();
    if (startDate.after(today)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Contract{" + "company=" + company + ", employee=" + employee + ", position=" + position + ", monthlySalary=" + monthlySalary + ", startDate=" + startDate + ", endDate=" + endDate + ", contractId=" + contractId + '}';
  }
  
  
  
 
}
