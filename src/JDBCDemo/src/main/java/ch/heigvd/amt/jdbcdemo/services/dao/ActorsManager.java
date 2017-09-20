package ch.heigvd.amt.jdbcdemo.services.dao;

import ch.heigvd.amt.jdbcdemo.model.Actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Stateless
public class ActorsManager implements ActorsManagerLocal {

  @Resource(lookup = "java:/jdbc/sakila")
  private DataSource dataSource;

  @Override
  public List<Actor> findAllActors() {
    List<Actor> actors = new ArrayList<>();
    try {
      try (Connection connection = dataSource.getConnection(); PreparedStatement pstmt = connection.prepareStatement("");) {
        //PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM actor");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          String firstName = rs.getString("first_name");
          String lastName = rs.getString("last_name");
          long id = rs.getLong("actor_id");
          actors.add(new Actor(id, firstName, lastName));
        }
        pstmt.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(ActorsManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return actors;
  }

}
