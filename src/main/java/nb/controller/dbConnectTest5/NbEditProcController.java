package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NbEditProcController implements NbController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbEditProcController mvc2 신호");

	}
}
