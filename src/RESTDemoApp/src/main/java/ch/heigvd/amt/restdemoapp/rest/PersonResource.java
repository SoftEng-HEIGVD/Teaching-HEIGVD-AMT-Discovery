package ch.heigvd.amt.restdemoapp.rest;

import ch.heigvd.amt.restdemoapp.model.Contract;
import ch.heigvd.amt.restdemoapp.model.Person;
import ch.heigvd.amt.restdemoapp.rest.dto.PersonDTO;
import ch.heigvd.amt.restdemoapp.services.InMemoryDataStoreLocal;
import java.net.URI;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Olivier Liechti
 */
@Stateless
@Path("/people")
public class PersonResource {

  @EJB
  private InMemoryDataStoreLocal inMemoryDataStore;

  @Context
  UriInfo uriInfo;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<PersonDTO> getPeople(@QueryParam(value = "byName" ) String byName) {
    List<Person> people = inMemoryDataStore.findAllPeople();
    return people.stream()
      .filter(p -> byName == null || p.getLastName().equalsIgnoreCase(byName))
      .map(p -> toDTO(p))
      .collect(toList());
      
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createPerson(PersonDTO personDTO) {
    Person person = fromDTO(personDTO);
    long personId = inMemoryDataStore.savePerson(person);

    URI href = uriInfo
      .getBaseUriBuilder()
      .path(PersonResource.class)
      .path(PersonResource.class, "getPerson")
      .build(personId);

    return Response
      .created(href)
      .build();
  }

  @Path("{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public PersonDTO getPerson(@PathParam(value = "id") long id) {
    Person person = inMemoryDataStore.loadPerson(id);
    return toDTO(person);
  }
  
  public Person fromDTO(PersonDTO dto) {
    return new Person(dto.getFirstName(), dto.getLastName());
  }
  
  public PersonDTO toDTO(Person person) {
    PersonDTO dto = new PersonDTO(person.getFirstName(), person.getLastName());
    for (Contract c : person.getContracts()) {
      if (c.isActive()) {
        dto.addEmployer(c.getCompany().getName());
      }
    }
    return dto;
  }

}
