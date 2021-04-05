package filtres;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter({ "/css/*","/js/*" })
public class Filtre_Css_Js implements Filter 
{
    public Filtre_Css_Js() 
    {
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@// créer une instance du filtre: 'filtres css et JS' //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
    
	public void destroy() 
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		String id_sess=req.getSession().getId();
        System.out.println("filter:"+((HttpServletRequest)request).getRequestURL().toString()+"\t"+id_sess);
        String url= ((HttpServletRequest)request).getRequestURL().toString();
        String fileName = url.substring( url.lastIndexOf('/')+1, url.length() );
        System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd  "+fileName);

	
        if(fileName.contains("css")) 
        {
        	req.getRequestDispatcher("/ressources/css/"+fileName).forward(req, response);       	
        }
        else 
        {
        	req.getRequestDispatcher("/ressources/js/"+fileName).forward(req, response);
        }
	}
	public void init(FilterConfig fConfig) throws ServletException 
	{
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@// execution de la méthode: ''init()'' du filtre: 'filtres css et JS' //@@@@@@@@@@@@@@@@@@@@@@@");

	}
}
