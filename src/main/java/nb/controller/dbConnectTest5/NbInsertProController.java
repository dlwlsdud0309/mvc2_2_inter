package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;


public class NbInsertProController implements NbController{

//	HttpServletRequest httpSession;
	//HttpServlet session;
	//ServletRequest session;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbInsertProController mvc2 신호");
		
		String title = request.getParameter("title");
		//String loginId = (String)httpSession.getAttribute("loginId");
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		System.out.println("InsertPro title : "+title);
		System.out.println("InsertPro loginId : "+loginId);
		String content = request.getParameter("content");

		NoticeBoards nb = new NoticeBoards();
		nb.setTitle(title);
		nb.setWriter(loginId);
		nb.setContent(content);

		NoticeBoardsDao dao = new NoticeBoardsDao();
		int resultNum = dao.insert(nb);
		
		if(resultNum>0){
			//response.sendRedirect("noticeboards.jsp");
			request.getRequestDispatcher("noticeboardsDetail.jsp").forward(request, response);
		}
		
	}
}
