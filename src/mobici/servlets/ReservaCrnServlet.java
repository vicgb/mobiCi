package mobici.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mobici.dao.ReservaDAOImplementation;
public class ReservaCrnServlet implements ServletContextListener {
    private Thread t = null;
    private ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
        t =  new Thread(){
            //task
            public void run(){                
                try {
                    while(true){
                        ReservaDAOImplementation.getInstancia().compruebaReservas();
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {}
            }            
        };
        t.start();
        context = contextEvent.getServletContext();
        // you can set a context variable just like this
        context.setAttribute("TEST", "TEST_VALUE");
    }
    public void contextDestroyed(ServletContextEvent contextEvent) {
        // si se destruye el contexto se interrumpe el thread
        t.interrupt();
    }            
}
