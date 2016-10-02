package ch.heigvd.amt.restdemoapp.web;

import ch.heigvd.amt.restdemoapp.model.Contract;
import ch.heigvd.amt.restdemoapp.services.HumanResourcesServiceLocal;
import ch.heigvd.amt.restdemoapp.services.TestDataServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class TestDataServlet extends HttpServlet {

  @EJB
  private TestDataServiceLocal testDataService;

  @EJB
  private HumanResourcesServiceLocal humanResourcesService;

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
    testDataService.generateTestData();
    List<Contract> contracts = humanResourcesService.getAllContracts();
    PrintWriter out = new PrintWriter(response.getWriter());
    out.println("<html><head></head><body>");
    out.println("<h2>Contracts</h2>");
    out.println("<ul>");
    for (Contract contract : contracts) {
      out.println("<li>"+ contract + "</li>");
    }
    out.println("</ul>");
    out.println("</body></html>");
  }



}
