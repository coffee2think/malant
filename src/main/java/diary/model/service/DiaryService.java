package diary.model.service;

import diary.model.dao.ArrayList;
import diary.model.dao.Connection;
import diary.model.dao.Diary;
import diary.model.dao.DiaryDao;

public class DiaryService {
	
	private DiaryDao ddao = new DiaryDao();
	
	public DiaryService () {}
	
	public ArrayList<Diary> selectDiaryList(String){}
	
	public int insertNewDiray (Diary, String) {}
	
	public int updateDiary(Diary, String) {}
	
	public int deleteDiary(String, int) {}
	
	public int insertDiaryImage(String, int) {}
	
	public int insertDiaryEmoji(String, int) {}
	
	public int intertDiaryManaging(String, int) {}

	public int getDiaryManagingCount() {}	
	
	public int getDiaryCount() {}
	
}
