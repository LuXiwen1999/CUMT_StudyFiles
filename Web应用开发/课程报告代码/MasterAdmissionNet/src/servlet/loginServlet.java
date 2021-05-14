package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;
import vo.Users;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(description = "sendURLmatchUser", urlPatterns = { "/loginServlet" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Users user = new Users();
		String id = request.getParameter("ID");
		System.out.println("request�����л�ȡ���ĵ�¼�û���Ϊ��"+id);
        HttpSession session = request.getSession();
		try {
			user = DAOFactory.getIUsersDAOInstance().findByID(id);
			session.setAttribute("user", user);
			if(user==null) {
				System.out.println("��¼id��Ч");
				response.getWriter().append("Served at: ");
				response.getWriter().print("\n Please login again!");
			}else if (user.getRole().equals("admin")) {
				System.out.println("��ӭ�������Ա����");
				response.sendRedirect("jsp/home.jsp");
			}else if(user.getRole().equals("guest")) {
				System.out.println("��ӭ������ͽ���");
				response.sendRedirect("jsp/homeGuest.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("html/login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
