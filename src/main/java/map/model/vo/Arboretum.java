package map.model.vo;

public class Arboretum { //수목원의 기본정보
	private String arboretum_id;  	 	//수목원 식별번호
	private String arboretum_name;		//수목원명
	private String arboretum_address;	//수목원주소
	private double arboretum_latitude;	//위도
	private double arboretum_longitude;	//경도
	private String arboretum_homepage;	//홈페이지
	private String arboretum_tel;		//전화번호
	private char entrance_fee_yn;		//입장료 여부
	private int fee_adult;				//입장료 - 성인
	private int fee_teenage;			//입장료 - 청소년
	private int fee_child;				//입장료 - 어린이
	private int fee_disabled;			//입장료 - 장애인
	private String fee_etc;				//입장료 - 기타
	private String open_days;			//개관일
	private String closed_days;			//휴관일
	private char with_pet_yn;			//반려동물 동반가능여부
	private char with_guidedog_yn;		//안내견 동반가능여부
	private char edu_program_yn;		//교육프로그램 운영여부
	
	private int    edu_program_id;		//교육프로그램 식별번호
	private String program_name;		//프로그램명
	private String period;				//프로그램 운영기간
	private String target;				//참가 대상
	private int    cost;
	
	public Arboretum() {
		super();
	}

	public Arboretum(String arboretum_id, String arboretum_name, String arboretum_address, double arboretum_latitude,
			double arboretum_longitude, String arboretum_homepage, String arboretum_tel, char entrance_fee_yn,
			int fee_adult, int fee_teenage, int fee_child, int fee_disabled, String fee_etc, String open_days,
			String closed_days, char with_pet_yn, char with_guidedog_yn, char edu_program_yn, int edu_program_id,
			String program_name, String period, String target, int cost) {
		super();
		this.arboretum_id = arboretum_id;
		this.arboretum_name = arboretum_name;
		this.arboretum_address = arboretum_address;
		this.arboretum_latitude = arboretum_latitude;
		this.arboretum_longitude = arboretum_longitude;
		this.arboretum_homepage = arboretum_homepage;
		this.arboretum_tel = arboretum_tel;
		this.entrance_fee_yn = entrance_fee_yn;
		this.fee_adult = fee_adult;
		this.fee_teenage = fee_teenage;
		this.fee_child = fee_child;
		this.fee_disabled = fee_disabled;
		this.fee_etc = fee_etc;
		this.open_days = open_days;
		this.closed_days = closed_days;
		this.with_pet_yn = with_pet_yn;
		this.with_guidedog_yn = with_guidedog_yn;
		this.edu_program_yn = edu_program_yn;
		this.edu_program_id = edu_program_id;
		this.program_name = program_name;
		this.period = period;
		this.target = target;
		this.cost = cost;
	}

	public String getArboretum_id() {
		return arboretum_id;
	}

	public void setArboretum_id(String arboretum_id) {
		this.arboretum_id = arboretum_id;
	}

	public String getArboretum_name() {
		return arboretum_name;
	}

	public void setArboretum_name(String arboretum_name) {
		this.arboretum_name = arboretum_name;
	}

	public String getArboretum_address() {
		return arboretum_address;
	}

	public void setArboretum_address(String arboretum_address) {
		this.arboretum_address = arboretum_address;
	}

	public double getArboretum_latitude() {
		return arboretum_latitude;
	}

	public void setArboretum_latitude(double arboretum_latitude) {
		this.arboretum_latitude = arboretum_latitude;
	}

	public double getArboretum_longitude() {
		return arboretum_longitude;
	}

	public void setArboretum_longitude(double arboretum_longitude) {
		this.arboretum_longitude = arboretum_longitude;
	}

	public String getArboretum_homepage() {
		return arboretum_homepage;
	}

	public void setArboretum_homepage(String arboretum_homepage) {
		this.arboretum_homepage = arboretum_homepage;
	}

	public String getArboretum_tel() {
		return arboretum_tel;
	}

	public void setArboretum_tel(String arboretum_tel) {
		this.arboretum_tel = arboretum_tel;
	}

	public char getEntrance_fee_yn() {
		return entrance_fee_yn;
	}

	public void setEntrance_fee_yn(char entrance_fee_yn) {
		this.entrance_fee_yn = entrance_fee_yn;
	}

	public int getFee_adult() {
		return fee_adult;
	}

	public void setFee_adult(int fee_adult) {
		this.fee_adult = fee_adult;
	}

	public int getFee_teenage() {
		return fee_teenage;
	}

	public void setFee_teenage(int fee_teenage) {
		this.fee_teenage = fee_teenage;
	}

	public int getFee_child() {
		return fee_child;
	}

	public void setFee_child(int fee_child) {
		this.fee_child = fee_child;
	}

	public int getFee_disabled() {
		return fee_disabled;
	}

	public void setFee_disabled(int fee_disabled) {
		this.fee_disabled = fee_disabled;
	}

	public String getFee_etc() {
		return fee_etc;
	}

	public void setFee_etc(String fee_etc) {
		this.fee_etc = fee_etc;
	}

	public String getOpen_days() {
		return open_days;
	}

	public void setOpen_days(String open_days) {
		this.open_days = open_days;
	}

	public String getClosed_days() {
		return closed_days;
	}

	public void setClosed_days(String closed_days) {
		this.closed_days = closed_days;
	}

	public char getWith_pet_yn() {
		return with_pet_yn;
	}

	public void setWith_pet_yn(char with_pet_yn) {
		this.with_pet_yn = with_pet_yn;
	}

	public char getWith_guidedog_yn() {
		return with_guidedog_yn;
	}

	public void setWith_guidedog_yn(char with_guidedog_yn) {
		this.with_guidedog_yn = with_guidedog_yn;
	}

	public char getEdu_program_yn() {
		return edu_program_yn;
	}

	public void setEdu_program_yn(char edu_program_yn) {
		this.edu_program_yn = edu_program_yn;
	}

	public int getEdu_program_id() {
		return edu_program_id;
	}

	public void setEdu_program_id(int edu_program_id) {
		this.edu_program_id = edu_program_id;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Arboretum [arboretum_id=" + arboretum_id + ", arboretum_name=" + arboretum_name + ", arboretum_address="
				+ arboretum_address + ", arboretum_latitude=" + arboretum_latitude + ", arboretum_longitude="
				+ arboretum_longitude + ", arboretum_homepage=" + arboretum_homepage + ", arboretum_tel="
				+ arboretum_tel + ", entrance_fee_yn=" + entrance_fee_yn + ", fee_adult=" + fee_adult + ", fee_teenage="
				+ fee_teenage + ", fee_child=" + fee_child + ", fee_disabled=" + fee_disabled + ", fee_etc=" + fee_etc
				+ ", open_days=" + open_days + ", closed_days=" + closed_days + ", with_pet_yn=" + with_pet_yn
				+ ", with_guidedog_yn=" + with_guidedog_yn + ", edu_program_yn=" + edu_program_yn + ", edu_program_id="
				+ edu_program_id + ", program_name=" + program_name + ", period=" + period + ", target=" + target
				+ ", cost=" + cost + "]";
	}	
	
	
}
