package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Mutter;


/**
 * Application Lifecycle Listener implementation class DocoTsubuLN
 *
 */
@WebListener
public class DocoTsubuLN implements ServletContextListener {

    /**
     * Default constructor.
     */
    public DocoTsubuLN() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    	System.out.println("「どこつぶ」アプリを終了しました");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    	System.out.println("つぶやきリスト新規作成");
    	/*★アプリケーションスコープ内につぶやきリストがあることを
    	 * 保証する処理(p283)
    	 */
    	//ServletContextインスタンスの取得
    	ServletContext application = arg0.getServletContext();

    	//つぶやきリストを新規作成して、アプリケーションスコープに保存
    	List<Mutter> mutterList = new ArrayList<Mutter>();
    	application.setAttribute("mutterList", mutterList);
    }

}
