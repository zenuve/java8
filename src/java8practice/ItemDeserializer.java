package java8practice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

public class ItemDeserializer extends StdDeserializer<Map> { 
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemDeserializer() { 
        this(null); 
 	} 
 
    public ItemDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public Map deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Map map=new HashMap();
        int id = (Integer) ((IntNode) node.get("id")).numberValue();
        
        String itemName = node.get("itemName").asText();
        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
 
        return (Map) map.put(id, new Item(id, itemName, new User(userId, null)));
    }
}