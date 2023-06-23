package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NbInsertRegController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbInsertRegController mvc2 신호");
		
		String title = request.getParameter("title");
		//String loginId = (String)session.getAttribute("sessionId");
		String content = request.getParameter("content");

		NoticeBoards nb = new NoticeBoards();
		nb.setTitle(title);
		//nb.setWriter(loginId);
		nb.setContent(content);

		NoticeBoardsDao dao = new NoticeBoardsDao();
		int resultNum = dao.insert(nb);
		
		if(resultNum>0){
			response.sendRedirect("noticeboards.jsp");
		}
	}
}
