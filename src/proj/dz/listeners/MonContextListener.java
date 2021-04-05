package proj.dz.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;

@WebListener //pour dir que c'est un listener
public class MonContextListener implements ServletContextListener, HttpSessionListener
{
	//ServletContextListener: Permet d��couter les changements d��tat du ServletContext
	//ServletContextListener: r�aliser des traitements au moment du lancement de l�application Web et/ou au moment de son arr�t.
    public MonContextListener() 
    {
    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA Creatio du listener:"+getClass().getCanonicalName());
    }

    public void contextDestroyed(ServletContextEvent arg0)  
    { 
    	System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        System.out.println("destroyed");
    }

    public void contextInitialized(ServletContextEvent arg0)  
    { 
    	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
    	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC*** INITIALISATION DU CONTEXT"); 
    }
    
    public void sessionCreated()
    {
    	System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
    	System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD*** session a �t� cr�e"); 
    }
}
