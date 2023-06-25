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
		HttpSession session = request.getSession(true);
		String sendInsertProWriterId = (String)session.getAttribute("sendInsertProWriterId");
		//String loginId = (String)session.getAttribute("writerId");
		//String loginId = (String)request.getAttribute("writerId");
		System.out.println("InsertPro title : "+title);
		System.out.println("InsertPro sendInsertProWriterId : "+sendInsertProWriterId);
		String content = request.getParameter("content");

		NoticeBoards nb = new NoticeBoards();
		nb.setTitle(title);
		nb.setWriter(sendInsertProWriterId);
		nb.setContent(content);

		NoticeBoardsDao dao = new NoticeBoardsDao();
		int resultNum = dao.insert(nb);
		
		if(resultNum>0){
			//response.sendRedirect("noticeboards.jsp");
			request.getRequestDispatcher("noticeboardsDetail.jsp").forward(request, response);
		}
		
	}
}
