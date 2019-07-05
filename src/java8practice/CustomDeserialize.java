package java8practice;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomDeserialize {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Item.class, new ItemDeserializer());
		mapper.registerModule(module);
		
		String json="{" + 
				"\"id\": 1," + 
				"\"itemName\": \"theItem\"," + 
				"\"createdBy\": 2" + 
				"}";
		Item readValue = mapper.readValue(json, Item.class);
		System.out.println(readValue.id);
	}

}
