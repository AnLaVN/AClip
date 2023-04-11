package Tool;
//Make by Bình An || AnLaVN || KatoVN

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface HTTPFilter extends Filter {
	
    @Override
    default void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
    	HttpServletRequest  httpREQ  = (HttpServletRequest)  req;
    	HttpServletResponse httpRESP = (HttpServletResponse) resp;
    	doFilter(httpREQ, httpRESP, fc);
    }
    
    void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain fc) throws IOException, ServletException;
    
    @Override
    default void init(FilterConfig filterConfig) throws ServletException {}
    
    @Override
    default void destroy() {}
}