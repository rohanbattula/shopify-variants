package rohanaio;

public class Settings {
	private String url = "https://www.shoepalace.com/collections/launches/products/jordan-575441-134-air-jordan-retro-1-high-og-university-blue-grade-school-lifestyle-shoe-white-blue-limit-one-per-customer";
	
	private String webhook_url = "https://discord.com/api/webhooks/813671811418030101/yh15_gXSWx3y-P_N7Ro2jwNgTbLRHIRpSLzmPvLnYmkArpzGWVHei7xxcQqRn_5Hlwbx";
	private int delay = 3500;

	public Settings() {}
	
	public String getWebhook() {
		return webhook_url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public void setWebhook(String newWebhook) {
		webhook_url = newWebhook;
	}
	
	public void setDelay(int newDelay) {
		delay = newDelay;
	}
	
	
	
	
	
	
}