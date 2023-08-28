package myplant.model.vo;

import java.sql.Date;

public class Myplant implements java.io.Serializable{

	private String memberNo;
	private String petPlantNo;
	private String myplantName;
	private String myplantVariety;
	private String myplantImageURL;
	private String myplantMemo;
	private Date myplantStartDate;
	private String posWindows;
	private String posVeranda;
	private String posDesk;
	private String posYard;
	private String posGarden;
	private String envSunny;
	private String envShady;
	private String envWindy;
	private String envDry;
	private String envHumid;
	private String withPet;
	private String withPlant;
	private String withChild;
	private String withFriend;
	private String withAlone;
	
	
	public Myplant() {
		super();
		
	}


	public Myplant(String memberNo, String petPlantNo, String myplantName, String myplantVariety,
			String myplantImageURL, String myplantMemo, Date myplantStartDate, String posWindows, String posVeranda,
			String posDesk, String posYard, String posGarden, String envSunny, String envShady, String envWindy,
			String envDry, String envHumid, String withPet, String withPlant, String withChild, String withFriend,
			String withAlone) {
		super();
		this.memberNo = memberNo;
		this.petPlantNo = petPlantNo;
		this.myplantName = myplantName;
		this.myplantVariety = myplantVariety;
		this.myplantImageURL = myplantImageURL;
		this.myplantMemo = myplantMemo;
		this.myplantStartDate = myplantStartDate;
		this.posWindows = posWindows;
		this.posVeranda = posVeranda;
		this.posDesk = posDesk;
		this.posYard = posYard;
		this.posGarden = posGarden;
		this.envSunny = envSunny;
		this.envShady = envShady;
		this.envWindy = envWindy;
		this.envDry = envDry;
		this.envHumid = envHumid;
		this.withPet = withPet;
		this.withPlant = withPlant;
		this.withChild = withChild;
		this.withFriend = withFriend;
		this.withAlone = withAlone;
	}


	@Override
	public String toString() {
		return "Myplant [memberNo=" + memberNo + ", petPlantNo=" + petPlantNo + ", myplantName=" + myplantName
				+ ", myplantVariety=" + myplantVariety + ", myplantImageURL=" + myplantImageURL + ", myplantMemo="
				+ myplantMemo + ", myplantStartDate=" + myplantStartDate + ", posWindows=" + posWindows
				+ ", posVeranda=" + posVeranda + ", posDesk=" + posDesk + ", posYard=" + posYard + ", posGarden="
				+ posGarden + ", envSunny=" + envSunny + ", envShady=" + envShady + ", envWindy=" + envWindy
				+ ", envDry=" + envDry + ", envHumid=" + envHumid + ", withPet=" + withPet + ", withPlant=" + withPlant
				+ ", withChild=" + withChild + ", withFriend=" + withFriend + ", withAlone=" + withAlone + "]";
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getPetPlantNo() {
		return petPlantNo;
	}


	public void setPetPlantNo(String petPlantNo) {
		this.petPlantNo = petPlantNo;
	}


	public String getMyplantName() {
		return myplantName;
	}


	public void setMyplantName(String myplantName) {
		this.myplantName = myplantName;
	}


	public String getMyplantVariety() {
		return myplantVariety;
	}


	public void setMyplantVariety(String myplantVariety) {
		this.myplantVariety = myplantVariety;
	}


	public String getMyplantImageURL() {
		return myplantImageURL;
	}


	public void setMyplantImageURL(String myplantImageURL) {
		this.myplantImageURL = myplantImageURL;
	}


	public String getMyplantMemo() {
		return myplantMemo;
	}


	public void setMyplantMemo(String myplantMemo) {
		this.myplantMemo = myplantMemo;
	}


	public Date getMyplantStartDate() {
		return myplantStartDate;
	}


	public void setMyplantStartDate(Date myplantStartDate) {
		this.myplantStartDate = myplantStartDate;
	}


	public String getPosWindows() {
		return posWindows;
	}


	public void setPosWindows(String posWindows) {
		this.posWindows = posWindows;
	}


	public String getPosVeranda() {
		return posVeranda;
	}


	public void setPosVeranda(String posVeranda) {
		this.posVeranda = posVeranda;
	}


	public String getPosDesk() {
		return posDesk;
	}


	public void setPosDesk(String posDesk) {
		this.posDesk = posDesk;
	}


	public String getPosYard() {
		return posYard;
	}


	public void setPosYard(String posYard) {
		this.posYard = posYard;
	}


	public String getPosGarden() {
		return posGarden;
	}


	public void setPosGarden(String posGarden) {
		this.posGarden = posGarden;
	}


	public String getEnvSunny() {
		return envSunny;
	}


	public void setEnvSunny(String envSunny) {
		this.envSunny = envSunny;
	}


	public String getEnvShady() {
		return envShady;
	}


	public void setEnvShady(String envShady) {
		this.envShady = envShady;
	}


	public String getEnvWindy() {
		return envWindy;
	}


	public void setEnvWindy(String envWindy) {
		this.envWindy = envWindy;
	}


	public String getEnvDry() {
		return envDry;
	}


	public void setEnvDry(String envDry) {
		this.envDry = envDry;
	}


	public String getEnvHumid() {
		return envHumid;
	}


	public void setEnvHumid(String envHumid) {
		this.envHumid = envHumid;
	}


	public String getWithPet() {
		return withPet;
	}


	public void setWithPet(String withPet) {
		this.withPet = withPet;
	}


	public String getWithPlant() {
		return withPlant;
	}


	public void setWithPlant(String withPlant) {
		this.withPlant = withPlant;
	}


	public String getWithChild() {
		return withChild;
	}


	public void setWithChild(String withChild) {
		this.withChild = withChild;
	}


	public String getWithFriend() {
		return withFriend;
	}


	public void setWithFriend(String withFriend) {
		this.withFriend = withFriend;
	}


	public String getWithAlone() {
		return withAlone;
	}


	public void setWithAlone(String withAlone) {
		this.withAlone = withAlone;
	}


	
	
	
}
