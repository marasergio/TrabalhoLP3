
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

@WebFilter(filterName = "FiltroWeb", urlPatterns = {"/protegido/*"})
public class FiltroWeb implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Iniciou");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{

            HttpSession session = ((HttpServletRequest) request).getSession(false);
            if (session != null) {
                if((session.getAttribute("LOGADO")!=null)&&(session.getAttribute("LOGADO").equals("SIM"))){
                    System.out.println("Usuario Logado");
                    chain.doFilter(request, response);
                }
                else{
                    System.err.println("Usuario NÃO Logado");
                    ((HttpServletResponse)response).sendRedirect("../index.xhtml");
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void destroy() {
        System.out.println("Finalizou");
    }

}
