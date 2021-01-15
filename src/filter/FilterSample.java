package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterSample
 */
/*
@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encode", value = "UTF-8")
})
*/
public class FilterSample implements Filter {
	String encode;//★

	/**
	 * Default constructor.
	 */
	public FilterSample() {
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
//		request.setCharacterEncoding("UTF-8");
		//前処理
		request.setCharacterEncoding(encode);
		//pass the request along the filter chain
		chain.doFilter(request, response);//↑前処理	↓後処理
		//後処理
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//初期化パラメータの読み込み
		encode = fConfig.getInitParameter("encode");
		System.out.println("encode:" + encode);
	}

}
