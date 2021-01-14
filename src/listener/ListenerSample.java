package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerSample implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		//訪問回数を表すIntegerインスタンスを新規作成しアプリケーションスコープに保存
		ServletContext context = sce.getServletContext();
		Integer count = 0;
		context.setAttribute("count",count);
	}
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
