package ch.heigvd.amt.restdemoapp.web;

import ch.heigvd.amt.restdemoapp.model.Company;
import ch.heigvd.amt.restdemoapp.services.InMemoryDataStoreLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class CompanyServlet extends HttpServlet {

  @EJB
  private InMemoryDataStoreLocal inMemoryDataStore;
  
  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("application/json;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      long id = inMemoryDataStore.saveCompany(new Company("HEIG-VD", "Switzerland"));
      out.println("{\"id\": " + id + "}");
    }
  }


// </editor-fold>

}
