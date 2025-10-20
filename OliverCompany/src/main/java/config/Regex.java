package config;

public class Regex {
	
	public String phoneRegex() {
		return "^09\\d{8}$";
	}

	public String idNumberRegex() {
		return "^[A-Z][12][0-9]{8}$";
	}
}
