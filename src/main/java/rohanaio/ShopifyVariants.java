package rohanaio;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.*;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ShopifyVariants {
	private String[] variants; 
	private class Variant {
		private String id;
		private String title; 
	}
	private class Product {}
	
	private String url; 
	
	private OkHttpClient client = new OkHttpClient();
	//private final Moshi moshi = new Moshi.Builder().build();
	//private final JsonAdapter<Product> jsonAdapter = moshi.adapter(Product.class);

	String[] run(String url) throws IOException {
		  Request request = new Request.Builder()
		      .url(url)
		      .build();

		  try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
			String jsonString = response.body().string();
			
			JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
			JsonArray vars = jsonObject.getAsJsonObject("product").getAsJsonArray("variants");
			
			variants = new String[vars.size()];
			
			for(int i =0; i < vars.size(); i++) {
				System.out.println(vars.get(i).getAsJsonObject().get("id").toString());
				
			}

			
		    return variants;
		  }
	}
	
	
	
}
