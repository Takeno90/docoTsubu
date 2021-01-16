package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FooterFL
 */
@WebFilter("/FooterFL")
public class FooterFL implements Filter {

	/**
	 * Default constructor.
	 */
	public FooterFL() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;

		// pass the request along the filter chain
		chain.doFilter(request, response);
		//後処理
		String uri = req.getRequestURI();
		System.out.println("アクセス:" + uri + ":フッターの出力");

		//HTMLを出力(非推奨)
		/*
		 * ①フォワードで呼び出されるJSPファイルには反映されない!?
		 * 	⇒対応)第12章「インクルード」参照
		 *
		 * ②レスポンスされたHTMLファイルのソースが汚い!?
		 */
		PrintWriter out = response.getWriter();
		out.println("<p>Copyright どこつぶ制作委員会 All Rights Reserved</p>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
