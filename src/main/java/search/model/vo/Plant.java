package search.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Plant implements Serializable {

	private static final long serialVersionUID = -4570280134544732042L;

	private int plantNo;
	private String plantName;
	private String scientificName;
	private String englishName;
	private String familyName;
	private String originalHabitat;
	private String plantImg;
	private String plantThumbnail;
	private String usecase;
	private int growthWidth;
	private int growthHeight;
	private String leafShape;
	private String leafPattern;
	private String leafColor;
	private String rootShape;
	private String growthForm;
	private String flowerColor;
	private String fruitColor;
	private String ecology;
	private String viewType;
	private String smell;
	private String toxicity;
	private String difficulty;
	private String requiredManagement;
	private String growthRate;
	private String temperature;
	private String winterTemperature;
	private String light;
	private String humidity;
	private String fertilizer;
	private String soil;
	private String wateringSpring;
	private String wateringSummer;
	private String wateringAutumn;
	private String wateringWinter;
	private String effectPurification;
	private String placement;
	private String seasonBlooming;
	private String seasonFruiting;
	private String seasonPropagation;
	private String propagationMethod;
	private String managingDiseasesPests;
	private String usefulInfo;
	private String managingTips;
	private Date createdDate;
	private Date updateDate;
	private int viewCount;
	
	public Plant() {
	}

	public Plant(int plantNo, String plantName) {
		this.plantNo = plantNo;
		this.plantName = plantName;
	}

	public Plant(int plantNo, String plantName, String scientificName, String englishName, String familyName,
			String originalHabitat, String plantImg, String plantThumbnail, String usecase, int growthWidth,
			int growthHeight, String leafShape, String leafPattern, String leafColor, String rootShape,
			String growthForm, String flowerColor, String fruitColor, String ecology, String viewType, String smell,
			String toxicity, String difficulty, String requiredManagement, String growthRate, String temperature,
			String winterTemperature, String light, String humidity, String fertilizer, String soil,
			String wateringSpring, String wateringSummer, String wateringAutumn, String wateringWinter,
			String effectPurification, String placement, String seasonBlooming, String seasonFruiting,
			String seasonPropagation, String propagationMethod, String managingDiseasesPests, String usefulInfo,
			String managingTips, Date createdDate, Date updateDate, int viewCount) {
		this.plantNo = plantNo;
		this.plantName = plantName;
		this.scientificName = scientificName;
		this.englishName = englishName;
		this.familyName = familyName;
		this.originalHabitat = originalHabitat;
		this.plantImg = plantImg;
		this.plantThumbnail = plantThumbnail;
		this.usecase = usecase;
		this.growthWidth = growthWidth;
		this.growthHeight = growthHeight;
		this.leafShape = leafShape;
		this.leafPattern = leafPattern;
		this.leafColor = leafColor;
		this.rootShape = rootShape;
		this.growthForm = growthForm;
		this.flowerColor = flowerColor;
		this.fruitColor = fruitColor;
		this.ecology = ecology;
		this.viewType = viewType;
		this.smell = smell;
		this.toxicity = toxicity;
		this.difficulty = difficulty;
		this.requiredManagement = requiredManagement;
		this.growthRate = growthRate;
		this.temperature = temperature;
		this.winterTemperature = winterTemperature;
		this.light = light;
		this.humidity = humidity;
		this.fertilizer = fertilizer;
		this.soil = soil;
		this.wateringSpring = wateringSpring;
		this.wateringSummer = wateringSummer;
		this.wateringAutumn = wateringAutumn;
		this.wateringWinter = wateringWinter;
		this.effectPurification = effectPurification;
		this.placement = placement;
		this.seasonBlooming = seasonBlooming;
		this.seasonFruiting = seasonFruiting;
		this.seasonPropagation = seasonPropagation;
		this.propagationMethod = propagationMethod;
		this.managingDiseasesPests = managingDiseasesPests;
		this.usefulInfo = usefulInfo;
		this.managingTips = managingTips;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.viewCount = viewCount;
	}

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getOriginalHabitat() {
		return originalHabitat;
	}

	public void setOriginalHabitat(String originalHabitat) {
		this.originalHabitat = originalHabitat;
	}

	public String getPlantImg() {
		return plantImg;
	}

	public void setPlantImg(String plantImg) {
		this.plantImg = plantImg;
	}

	public String getPlantThumbnail() {
		return plantThumbnail;
	}

	public void setPlantThumbnail(String plantThumbnail) {
		this.plantThumbnail = plantThumbnail;
	}

	public String getUsecase() {
		return usecase;
	}

	public void setUsecase(String usecase) {
		this.usecase = usecase;
	}

	public int getGrowthWidth() {
		return growthWidth;
	}

	public void setGrowthWidth(int growthWidth) {
		this.growthWidth = growthWidth;
	}

	public int getGrowthHeight() {
		return growthHeight;
	}

	public void setGrowthHeight(int growthHeight) {
		this.growthHeight = growthHeight;
	}

	public String getLeafShape() {
		return leafShape;
	}

	public void setLeafShape(String leafShape) {
		this.leafShape = leafShape;
	}

	public String getLeafPattern() {
		return leafPattern;
	}

	public void setLeafPattern(String leafPattern) {
		this.leafPattern = leafPattern;
	}

	public String getLeafColor() {
		return leafColor;
	}

	public void setLeafColor(String leafColor) {
		this.leafColor = leafColor;
	}

	public String getRootShape() {
		return rootShape;
	}

	public void setRootShape(String rootShape) {
		this.rootShape = rootShape;
	}

	public String getGrowthForm() {
		return growthForm;
	}

	public void setGrowthForm(String growthForm) {
		this.growthForm = growthForm;
	}

	public String getFlowerColor() {
		return flowerColor;
	}

	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

	public String getFruitColor() {
		return fruitColor;
	}

	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}

	public String getEcology() {
		return ecology;
	}

	public void setEcology(String ecology) {
		this.ecology = ecology;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}

	public String getToxicity() {
		return toxicity;
	}

	public void setToxicity(String toxicity) {
		this.toxicity = toxicity;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getRequiredManagement() {
		return requiredManagement;
	}

	public void setRequiredManagement(String requiredManagement) {
		this.requiredManagement = requiredManagement;
	}

	public String getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(String growthRate) {
		this.growthRate = growthRate;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWinterTemperature() {
		return winterTemperature;
	}

	public void setWinterTemperature(String winterTemperature) {
		this.winterTemperature = winterTemperature;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getWateringSpring() {
		return wateringSpring;
	}

	public void setWateringSpring(String wateringSpring) {
		this.wateringSpring = wateringSpring;
	}

	public String getWateringSummer() {
		return wateringSummer;
	}

	public void setWateringSummer(String wateringSummer) {
		this.wateringSummer = wateringSummer;
	}

	public String getWateringAutumn() {
		return wateringAutumn;
	}

	public void setWateringAutumn(String wateringAutumn) {
		this.wateringAutumn = wateringAutumn;
	}

	public String getWateringWinter() {
		return wateringWinter;
	}

	public void setWateringWinter(String wateringWinter) {
		this.wateringWinter = wateringWinter;
	}

	public String getEffectPurification() {
		return effectPurification;
	}

	public void setEffectPurification(String effectPurification) {
		this.effectPurification = effectPurification;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public String getSeasonBlooming() {
		return seasonBlooming;
	}

	public void setSeasonBlooming(String seasonBlooming) {
		this.seasonBlooming = seasonBlooming;
	}

	public String getSeasonFruiting() {
		return seasonFruiting;
	}

	public void setSeasonFruiting(String seasonFruiting) {
		this.seasonFruiting = seasonFruiting;
	}

	public String getSeasonPropagation() {
		return seasonPropagation;
	}

	public void setSeasonPropagation(String seasonPropagation) {
		this.seasonPropagation = seasonPropagation;
	}

	public String getPropagationMethod() {
		return propagationMethod;
	}

	public void setPropagationMethod(String propagationMethod) {
		this.propagationMethod = propagationMethod;
	}

	public String getManagingDiseasesPests() {
		return managingDiseasesPests;
	}

	public void setManagingDiseasesPests(String managingDiseasesPests) {
		this.managingDiseasesPests = managingDiseasesPests;
	}

	public String getUsefulInfo() {
		return usefulInfo;
	}

	public void setUsefulInfo(String usefulInfo) {
		this.usefulInfo = usefulInfo;
	}

	public String getManagingTips() {
		return managingTips;
	}

	public void setManagingTips(String managingTips) {
		this.managingTips = managingTips;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Plant [plantNo=" + plantNo + ", plantName=" + plantName + ", scientificName=" + scientificName
				+ ", englishName=" + englishName + ", familyName=" + familyName + ", originalHabitat=" + originalHabitat
				+ ", plantImg=" + plantImg + ", plantThumbnail=" + plantThumbnail + ", usecase=" + usecase
				+ ", growthWidth=" + growthWidth + ", growthHeight=" + growthHeight + ", leafShape=" + leafShape
				+ ", leafPattern=" + leafPattern + ", leafColor=" + leafColor + ", rootShape=" + rootShape
				+ ", growthForm=" + growthForm + ", flowerColor=" + flowerColor + ", fruitColor=" + fruitColor
				+ ", ecology=" + ecology + ", viewType=" + viewType + ", smell=" + smell + ", toxicity=" + toxicity
				+ ", difficulty=" + difficulty + ", requiredManagement=" + requiredManagement + ", growthRate="
				+ growthRate + ", temperature=" + temperature + ", winterTemperature=" + winterTemperature + ", light="
				+ light + ", humidity=" + humidity + ", fertilizer=" + fertilizer + ", soil=" + soil
				+ ", wateringSpring=" + wateringSpring + ", wateringSummer=" + wateringSummer + ", wateringAutumn="
				+ wateringAutumn + ", wateringWinter=" + wateringWinter + ", effectPurification=" + effectPurification
				+ ", placement=" + placement + ", seasonBlooming=" + seasonBlooming + ", seasonFruiting="
				+ seasonFruiting + ", seasonPropagation=" + seasonPropagation + ", propagationMethod="
				+ propagationMethod + ", managingDiseasesPests=" + managingDiseasesPests + ", usefulInfo=" + usefulInfo
				+ ", managingTips=" + managingTips + ", createdDate=" + createdDate + ", updateDate=" + updateDate
				+ ", viewCount=" + viewCount + "]";
	}
	
}
