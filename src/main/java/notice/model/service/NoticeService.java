package notice.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import common.Paging;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = ndao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Notice> selectNoticeTitle(Paging paging) {
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectNoticeTitle(conn, paging);
		close(conn);
		return list;
	}
}
