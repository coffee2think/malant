package diary.model.dao;

public class DiaryDao {
	
	public DiaryDao() {}
	
	public ArrayList<Diary> selectDiaryList(Connection, String, int){}
	
	public int insertNewDiray (Connection, Diary, String) {}
	
	public int updateDiary(Connection, Diary, String) {}
	
	public int deleteDiary(Connection, String, int) {}
	
	public int insertDiaryImage(Connection, String, int) {}
	
	public int insertDiaryEmoji(Connection, String, int) {}
	
	public ArrayList<Diary> intertDiaryManaging(Connection, String, int) {}
	
	public int getDiaryManagingCount() {}
	
	public int getDiaryCount() {}
}
