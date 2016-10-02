package ch.heigvd.amt.restdemoapp.services;

import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface TestDataServiceLocal {

  void generateTestData();
  
}
