package rohanaio;

public class Webhook {
	private String username;
	private String avatar_url;
	private String content;
	private String[] vars; 
	private String image; 
	private String message;
	//private String[] sizerange; 
	
	public void setMessage(String msg) {
		message = msg;
	}

	public String getMessage() {
		return message; 
	}

	public void setImage(String img) {
		image = img;
	}

	public String getImage() {
		return image; 
	}
	
	public void setVariants(String[] variants) {
		vars = variants;
	}

	public String[] getVariants() {
		return vars; 
	}
	
	
}




