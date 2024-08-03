package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	public String getFakeFirstName() {
		
		Faker faker = new Faker();
		return faker.name().firstName();
		
	}

	
public String getFakeLasttName() {
		
		Faker faker = new Faker();
		return faker.name().lastName();
		
	}
}
