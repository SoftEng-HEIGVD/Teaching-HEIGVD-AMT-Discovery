package ch.heigvd.amt.jdbcdemo.model;

/**
 *
 * @author Olivier Liechti
 */
public class Actor {
  
  private long id;
  private String firstName;
  private String lastName;

  public Actor(long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
