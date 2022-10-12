
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
/**
 *
 * @author Silvia 
 */
@WebServlet(name = "ContadorServlet", urlPatterns = {"/ContadorServlet"})
public class ContadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
        
        int contador = 0;
        
        //Obtener el arreglo de cookies del cliente 
        Cookie[] cukis = request.getCookies();
        
        if (cukis != null){
           for (Cookie c: cukis){
              if (c.getName().equals("visitas")){
                  // Antes de la asignacion se convierte un valor en cadena
                 contador = Integer.parseInt(c.getValue());
              }
           }
        }
       
        contador++;
        //antes de la asignacion se convierte cadena en valor 
        Cookie c = new Cookie("visitas",Integer.toString(contador));
        
        c.setMaxAge(30);
        response.addCookie(c);
        //generar contenido a partir del servlet
        response.setContentType("text/html");
        
        
        PrintWriter out = response.getWriter();
        out.println("Visitante N " + contador);
        
        
    }        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        }
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
