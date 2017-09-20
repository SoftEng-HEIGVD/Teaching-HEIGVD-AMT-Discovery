package ch.heigvd.amt.jdbcdemo.services.dao;

import ch.heigvd.amt.jdbcdemo.model.Actor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface ActorsManagerLocal {

  public List<Actor> findAllActors();
  
}
