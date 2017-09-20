package ch.heigvd.amt.jdbcdemo.web;

import ch.heigvd.amt.jdbcdemo.services.dao.ActorsManagerLocal;
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
public class TestServlet extends HttpServlet {
  
  @EJB
  private ActorsManagerLocal actorsManager;

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
    response.setContentType("text/html;charset=UTF-8");
    request.setAttribute("actors", actorsManager.findAllActors());
    request.getRequestDispatcher("/WEB-INF/pages/actors.jsp").forward(request, response);
  }
}

