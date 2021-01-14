package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet( //"/CounterServlet"
		urlPatterns = { "/CounterServletLN" },
		initParams = {
				@WebInitParam(name = "bgcolor", value = "yellow")
		})

public class CounterServletLN extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String bgcolor; //★

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CounterServletLN() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		/*
		 * ①.なんらかのパラメータを受け取って初期化処理を行う場合
		 * =>パラメータありのinitメソッド
		 *
		 * ②.決まった初期化処理を行う場合
		 * =>パラメータなしのinitメソッド
		 */

		super.init(config);
		/*リスナーで監視するので、不要!
		 *訪問回数を表すIntegerインスタンスを新規作成し
		 *アプリケーションスコープに保存
		 */
		//		super.init();		//②.特に記述の制約はない

		//★
//		try {
//			bgcolor = config.getInitParameter("bgcolor");
//			System.out.println("bgcolor:" + bgcolor);
//		} catch (Exception e) {
//			System.out.println("error:" + e.toString());
//		}
		//訪問回数を表すIntegerインスタンスを新規作成し、アプリケーションスコープに保存
		/*リスト11-1
		 アプリケーションスコープに保存された訪問回数を増加
		 ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
		 */
//		Integer count = 0;
//		//		ServletContext application = config.getServletContext();
//		//						↑引数のインスタンスでもOK
//		//						↓自身のインスタンスでもOK
//		ServletContext application = this.getServletContext();
//		application.setAttribute("count", count);

		System.out.println("init()が実行されました");

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy()が実行されました");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//アプリケーションスコープに保存された訪問回数を増加
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>訪問回数を表示</title>");
		out.println("<style>");
		out.println("body{background-color:" + bgcolor + ";}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>訪問回数:" + count + "</p>");
		out.println("<a href=\"/docoTsubu/CounterServletLN\">更新</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
