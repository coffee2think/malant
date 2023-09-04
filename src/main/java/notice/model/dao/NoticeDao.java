package notice.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.Paging;
import notice.model.vo.Notice;

public class NoticeDao {

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from notice";

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public ArrayList<Notice> selectNoticeTitle(Connection conn, Paging paging) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select NOTICE_NO, ADMIN_NO, NOTICE_TYPE, TITLE, CONTENT, THUMBNAIL, CONTENT_IMG, PRIORITY, POST_DATE, START_DATE, "
				+ "                            END_DATE, VIEWCOUNT " + "from NOTICE " + "where ROWNUM between ? and ? "
				+ "order by POST_DATE";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, paging.getStartRow());
			pstmt.setInt(2, paging.getEndRow());

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Notice notice = new Notice();

				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setAdminNo(rset.getString("adminno"));
				notice.setNoticeType(rset.getString("noticetype"));
				notice.setTitle(rset.getString("title"));
				notice.setContent(rset.getString("content"));
				notice.setThumbnail(rset.getString("thumbnail"));
				notice.setContentImage(rset.getString("contentimage"));
				notice.setPriority(rset.getInt("priority"));
				notice.setPostDate(rset.getDate("postdate"));
				notice.setEventStart(rset.getDate("eventstart"));
				notice.setEventEnd(rset.getDate("eventend"));
				notice.setViewcount(rset.getInt("viewcount"));

				list.add(notice);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

}
