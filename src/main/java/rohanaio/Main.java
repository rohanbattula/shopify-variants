package rohanaio;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String url =
		"https://shopnicekicks.com/products/air-jordan-1-high-og-silver-toe-womens-lifestyle-shoe-black-silver" + ".json";
		
		ShopifyVariants x = new ShopifyVariants();
		x.run(url);
		
		
	}

}
