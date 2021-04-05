package proj.dz.filtres;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFiltres implements Filter 
{
    public EncodingFiltres() 
    {
    }

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		chain.doFilter(request, response);
		response.setCharacterEncoding("ISO8859-1");
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}
}
