package rohanaio;

import java.io.IOException;
import java.text.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ShopifyVariants {
	private class Variant {
		private String id;
		private String title; 
	}
	private class Product {}
	
	private String url; 
	private int stockTotal = 0; 
	private String[] variants;
	private OkHttpClient client = new OkHttpClient();
	private Settings settings = new Settings();
	/* Sends a GET request to shopify site, grabs JSON from response
	 * Parse thru json to find vars 
	 */
	public void run() throws IOException {
		  Request request = new Request.Builder()
		      .url(settings.getUrl() + ".json")
		      .build();

		  try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
			String jsonString = response.body().string();
			
			JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
			JsonArray vars = jsonObject.getAsJsonObject("product").getAsJsonArray("variants");
			String title = jsonObject.getAsJsonObject("product").get("title").toString();
			
			variants = new String[vars.size()];
			for(int i =0; i < vars.size(); i++) {
				variants[i] = vars.get(i).getAsJsonObject().get("id").toString();
				stockTotal += (-1* vars.get(i).getAsJsonObject().get("inventory_quantity").getAsInt());
			}
			System.out.println(stockTotal);
			sendToDiscord(title, variants, Integer.toString(stockTotal));
		  }
	}
	
	public void sendToDiscord(String title, String[] variants, String stockTotal) throws IOException {
		String varstr = "";
		for(int i =0; i <variants.length; i++) {
			varstr += variants[i];
			varstr += "\n";
		}
		Settings settings = new Settings();
		String content = varstr + "\nStock Total:\n" + stockTotal;
		//content = "title here";
		//String embeds = "[{\"title\": \"Variants\", \"description\": \"" + stockTotal + "\"}]";
		String embeds = null;
        String str2 = "{\"content\": \"" + content + "\", \"embeds\" : null, \"avatar_url\" : \"https://static.wikia.nocookie.net/paw-patrol/images/4/4d/Roughbough_puhp.png/revision/latest?cb=20140204033607\"}";
		JsonObject jsonObject = new JsonParser().parse(str2).getAsJsonObject();

		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
		Request request = new Request.Builder()
				.url(settings.getWebhook())
				.post(body)
				.build();
		try(Response response = client.newCall(request).execute()){

		}
		
	}
	
	
}
