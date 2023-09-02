package search.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import search.model.vo.Plant;

public class SearchDao {

	public ArrayList<Plant> selectPlantList(Connection conn, String keyword) {
		ArrayList<Plant> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String[] keywords = keyword.split(" ");
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select * from plant ");
		queryBuilder.append("where 1=1 ");
		
		for(int i = 0; i < keywords.length; i++) {
			queryBuilder.append("and regexp_like(plant_name, ?) ");
		}
		queryBuilder.append("union ");
		queryBuilder.append("select * from plant ")
					.append("where regexp_like(plant_name, '")
					.append(String.join("|", keywords))
					.append("')");
		
		String query = queryBuilder.toString();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			for(int i = 0; i < keywords.length; i++) {
				pstmt.setString(i + 1, keywords[i]);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Plant plant = new Plant();
				
				plant.setEcology(rset.getString("ecology"));
				plant.setViewType(rset.getString("view_type"));
				plant.setSmell(rset.getString("smell"));
				plant.setToxicity(rset.getString("toxicity"));
				plant.setDifficulty(rset.getString("difficulty"));
				plant.setRequiredManagement(rset.getString("required_management"));
				plant.setGrowthRate(rset.getString("growth_rate"));
				plant.setTemperature(rset.getString("temperature"));
				plant.setWinterTemperature(rset.getString("winter_temperature"));
				plant.setLight(rset.getString("light"));
				plant.setHumidity(rset.getString("humidity"));
				plant.setFertilizer(rset.getString("fertilizer"));
				plant.setSoil(rset.getString("soil"));
				plant.setWateringSpring(rset.getString("watering_spring"));
				plant.setWateringSummer(rset.getString("watering_summer"));
				plant.setWateringAutumn(rset.getString("watering_autumn"));
				plant.setWateringWinter(rset.getString("watering_winter"));
				plant.setEffectPurification(rset.getString("effect_purification"));
				plant.setPlacement(rset.getString("placement"));
				plant.setSeasonBlooming(rset.getString("season_blooming"));
				plant.setSeasonFruiting(rset.getString("season_fruiting"));
				plant.setSeasonPropagation(rset.getString("season_propagation"));
				plant.setPropagationMethod(rset.getString("propagation_method"));
				plant.setManagingDiseasesPests(rset.getString("managing_diseases_pests"));
				plant.setUsefulInfo(rset.getString("useful_info"));
				plant.setManagingTips(rset.getString("managing_tips"));
				plant.setCreatedDate(rset.getDate("created_date"));
				plant.setUpdateDate(rset.getDate("update_date"));
				plant.setViewCount(rset.getInt("view_count"));
				plant.setPlantNo(rset.getInt("plant_no"));
				plant.setPlantName(rset.getString("plant_name"));
				plant.setScientificName(rset.getString("scientific_name"));
				plant.setEnglishName(rset.getString("english_name"));
				plant.setFamilyName(rset.getString("family_name"));
				plant.setOriginalHabitat(rset.getString("original_habitat"));
				plant.setPlantImg(rset.getString("plant_img"));
				plant.setPlantThumbnail(rset.getString("plant_thumbnail"));
				plant.setUsecase(rset.getString("usecase"));
				plant.setGrowthWidth(rset.getInt("growth_width"));
				plant.setGrowthHeight(rset.getInt("growth_height"));
				plant.setLeafShape(rset.getString("leaf_shape"));
				plant.setLeafPattern(rset.getString("leaf_pattern"));
				plant.setLeafColor(rset.getString("leaf_color"));
				plant.setRootShape(rset.getString("root_shape"));
				plant.setGrowthForm(rset.getString("growth_form"));
				plant.setFlowerColor(rset.getString("flower_color"));
				plant.setFruitColor(rset.getString("fruit_color"));
				
				System.out.println(plant);
				
				list.add(plant);
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
