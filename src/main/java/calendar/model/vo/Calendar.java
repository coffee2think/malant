package calendar.model.vo;

import java.sql.Date;

public class Calendar implements java.io.Serializable{

	private String memberNo;
	private String petPlantNo;
	private Date calendarDate;
	private int diaryNo;
	private String calendarMemo;
	private String managingPruningTrimming;
	private String managingFertilization;
	private String managingPestDisease;
	private String managingWatering;
	private String managingVentilation;
	private String managingPottingTransplant;
	private String managingSoilReplacement;
	private String managingRemovalDeadplants;
	private String managingWaterReplacement;
	private String managingRelocation;
	private String managingFlowering;
	private String managingHarvesting;
	private String managingNutrientSupplement;
	private String managingNewGrowth;
	private String managingDormancy;
	
	
	public Calendar() {
		super();
	
	}


	public Calendar(String memberNo, String petPlantNo, Date calendarDate, int diaryNo, String calendarMemo,
			String managingPruningTrimming, String managingFertilization, String managingPestDisease,
			String managingWatering, String managingVentilation, String managingPottingTransplant,
			String managingSoilReplacement, String managingRemovalDeadplants, String managingWaterReplacement,
			String managingRelocation, String managingFlowering, String managingHarvesting,
			String managingNutrientSupplement, String managingNewGrowth, String managingDormancy) {
		super();
		this.memberNo = memberNo;
		this.petPlantNo = petPlantNo;
		this.calendarDate = calendarDate;
		this.diaryNo = diaryNo;
		this.calendarMemo = calendarMemo;
		this.managingPruningTrimming = managingPruningTrimming;
		this.managingFertilization = managingFertilization;
		this.managingPestDisease = managingPestDisease;
		this.managingWatering = managingWatering;
		this.managingVentilation = managingVentilation;
		this.managingPottingTransplant = managingPottingTransplant;
		this.managingSoilReplacement = managingSoilReplacement;
		this.managingRemovalDeadplants = managingRemovalDeadplants;
		this.managingWaterReplacement = managingWaterReplacement;
		this.managingRelocation = managingRelocation;
		this.managingFlowering = managingFlowering;
		this.managingHarvesting = managingHarvesting;
		this.managingNutrientSupplement = managingNutrientSupplement;
		this.managingNewGrowth = managingNewGrowth;
		this.managingDormancy = managingDormancy;
	}


	@Override
	public String toString() {
		return "calendar [memberNo=" + memberNo + ", petPlantNo=" + petPlantNo + ", calendarDate=" + calendarDate
				+ ", diaryNo=" + diaryNo + ", calendarMemo=" + calendarMemo + ", managingPruningTrimming="
				+ managingPruningTrimming + ", managingFertilization=" + managingFertilization
				+ ", managingPestDisease=" + managingPestDisease + ", managingWatering=" + managingWatering
				+ ", managingVentilation=" + managingVentilation + ", managingPottingTransplant="
				+ managingPottingTransplant + ", managingSoilReplacement=" + managingSoilReplacement
				+ ", managingRemovalDeadplants=" + managingRemovalDeadplants + ", managingWaterReplacement="
				+ managingWaterReplacement + ", managingRelocation=" + managingRelocation + ", managingFlowering="
				+ managingFlowering + ", managingHarvesting=" + managingHarvesting + ", managingNutrientSupplement="
				+ managingNutrientSupplement + ", managingNewGrowth=" + managingNewGrowth + ", managingDormancy="
				+ managingDormancy + "]";
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


	public Date getCalendarDate() {
		return calendarDate;
	}


	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}


	public int getDiaryNo() {
		return diaryNo;
	}


	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}


	public String getCalendarMemo() {
		return calendarMemo;
	}


	public void setCalendarMemo(String calendarMemo) {
		this.calendarMemo = calendarMemo;
	}


	public String getManagingPruningTrimming() {
		return managingPruningTrimming;
	}


	public void setManagingPruningTrimming(String managingPruningTrimming) {
		this.managingPruningTrimming = managingPruningTrimming;
	}


	public String getManagingFertilization() {
		return managingFertilization;
	}


	public void setManagingFertilization(String managingFertilization) {
		this.managingFertilization = managingFertilization;
	}


	public String getManagingPestDisease() {
		return managingPestDisease;
	}


	public void setManagingPestDisease(String managingPestDisease) {
		this.managingPestDisease = managingPestDisease;
	}


	public String getManagingWatering() {
		return managingWatering;
	}


	public void setManagingWatering(String managingWatering) {
		this.managingWatering = managingWatering;
	}


	public String getManagingVentilation() {
		return managingVentilation;
	}


	public void setManagingVentilation(String managingVentilation) {
		this.managingVentilation = managingVentilation;
	}


	public String getManagingPottingTransplant() {
		return managingPottingTransplant;
	}


	public void setManagingPottingTransplant(String managingPottingTransplant) {
		this.managingPottingTransplant = managingPottingTransplant;
	}


	public String getManagingSoilReplacement() {
		return managingSoilReplacement;
	}


	public void setManagingSoilReplacement(String managingSoilReplacement) {
		this.managingSoilReplacement = managingSoilReplacement;
	}


	public String getManagingRemovalDeadplants() {
		return managingRemovalDeadplants;
	}


	public void setManagingRemovalDeadplants(String managingRemovalDeadplants) {
		this.managingRemovalDeadplants = managingRemovalDeadplants;
	}


	public String getManagingWaterReplacement() {
		return managingWaterReplacement;
	}


	public void setManagingWaterReplacement(String managingWaterReplacement) {
		this.managingWaterReplacement = managingWaterReplacement;
	}


	public String getManagingRelocation() {
		return managingRelocation;
	}


	public void setManagingRelocation(String managingRelocation) {
		this.managingRelocation = managingRelocation;
	}


	public String getManagingFlowering() {
		return managingFlowering;
	}


	public void setManagingFlowering(String managingFlowering) {
		this.managingFlowering = managingFlowering;
	}


	public String getManagingHarvesting() {
		return managingHarvesting;
	}


	public void setManagingHarvesting(String managingHarvesting) {
		this.managingHarvesting = managingHarvesting;
	}


	public String getManagingNutrientSupplement() {
		return managingNutrientSupplement;
	}


	public void setManagingNutrientSupplement(String managingNutrientSupplement) {
		this.managingNutrientSupplement = managingNutrientSupplement;
	}


	public String getManagingNewGrowth() {
		return managingNewGrowth;
	}


	public void setManagingNewGrowth(String managingNewGrowth) {
		this.managingNewGrowth = managingNewGrowth;
	}


	public String getManagingDormancy() {
		return managingDormancy;
	}


	public void setManagingDormancy(String managingDormancy) {
		this.managingDormancy = managingDormancy;
	}
	
	
	
	
	
}
