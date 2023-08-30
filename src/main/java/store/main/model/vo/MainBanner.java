package store.main.model.vo;

import java.sql.Date;

public class MainBanner implements java.io.Serializable {

	private static final long serialVersionUID = -3419475723523027584L;
	
	// 배너관련
	private String bannerImage;
	private int bannerPrority;
	private String bannerLink;
	private Date bannerStart;
	private Date bannerEnd;
	private int viewcount;
	
	
	public MainBanner() {
		super();
	}


	public MainBanner(String bannerImage, int bannerPrority, String bannerLink, Date bannerStart, Date bannerEnd,
			int viewcount) {
		super();
		this.bannerImage = bannerImage;
		this.bannerPrority = bannerPrority;
		this.bannerLink = bannerLink;
		this.bannerStart = bannerStart;
		this.bannerEnd = bannerEnd;
		this.viewcount = viewcount;
	}


	public String getBannerImage() {
		return bannerImage;
	}


	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}


	public int getBannerPrority() {
		return bannerPrority;
	}


	public void setBannerPrority(int bannerPrority) {
		this.bannerPrority = bannerPrority;
	}


	public String getBannerLink() {
		return bannerLink;
	}


	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}


	public Date getBannerStart() {
		return bannerStart;
	}


	public void setBannerStart(Date bannerStart) {
		this.bannerStart = bannerStart;
	}


	public Date getBannerEnd() {
		return bannerEnd;
	}


	public void setBannerEnd(Date bannerEnd) {
		this.bannerEnd = bannerEnd;
	}


	public int getViewcount() {
		return viewcount;
	}


	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "MainBanner [bannerImage=" + bannerImage + ", bannerPrority=" + bannerPrority + ", bannerLink="
				+ bannerLink + ", bannerStart=" + bannerStart + ", bannerEnd=" + bannerEnd + ", viewcount=" + viewcount
				+ "]";
	}
}
