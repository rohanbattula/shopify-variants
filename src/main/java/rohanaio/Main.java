package rohanaio;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String url =
		"https://shopnicekicks.com/collections/new-arrivals-1/products/waffle-racer-crater-womens-lifestyle-shoe-black" + ".json";
		
		ShopifyVariants x = new ShopifyVariants();
		System.out.println(x.run(url));
		
	}

}
