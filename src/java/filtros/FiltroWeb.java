/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Mara
 */
@WebFilter(filterName = "FiltroWeb", urlPatterns = {"/protegido/*"})
public class FiltroWeb implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{

            HttpSession session = ((HttpServletRequest) request).getSession(false);
            if (session != null) {
                if((session.getAttribute("LOGADO")!=null)&&(session.getAttribute("LOGADO").equals("SIM"))){
                    
                    chain.doFilter(request, response);
                }
                else{
                    
                    ((HttpServletResponse)response).sendRedirect("error.xhtml");
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
