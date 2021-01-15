package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormSampleServlet
 */
@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormSampleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの文字コードを指定
//		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

		//リクエストパラメータをチェック
		String errorMsg = "";
		if(name == null || name.length() == 0) {
			errorMsg += "名前が入力されていません<br>";
		}
		if(gender == null || gender.length() == 0) {
			errorMsg += "性別が選択されていません<br>";
		}else {
			if(gender.equals("0")) {
				gender = "男性";
			}else if(gender.equals("1")) {
				gender = "女性";
			}
		}
		int intAge = 0;
		if(age == null || age.length() == 0) {
			errorMsg += "年齢が入力されていません<br>";
		}else {
			try {
				intAge = Integer.parseInt(age);
			}catch(NumberFormatException e) {
				errorMsg += "年齢に数値以外が入力されています<br>";
			}
		}


		//表示するメッセージを設定
		String msg = name + "さん(" + gender + "、" + age + "歳)を登録しました";
		if(errorMsg.length() != 0) {
			msg = errorMsg;
		}

		//HTMLを出力
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>ユーザー登録結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>"+ msg + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
