package java8practice.customAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class ObjectToJsonConverter {
    public String convertToJson(Object object) throws CustomJsonSerializationException {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new CustomJsonSerializationException(e.getMessage());
        }
    }
    
    private void checkIfSerializable(Object object) throws CustomJsonSerializationException {
        if (Objects.isNull(object)) {
            throw new CustomJsonSerializationException("The object to serialize is null");
        }
             
        Class<?> clazz = object.getClass();
        System.out.println("Class"+clazz);
        if(!clazz.isAnnotationPresent(CustomJsonSerializable.class))
        {
        	throw new CustomJsonSerializationException("This class "+clazz.getSimpleName()+" is not annotated with CustomJsonSerializable");
        }
    }
    
    private void initializeObject(Object object) throws Exception {
	    Class<?> clazz = object.getClass();
	    for(Method method:clazz.getDeclaredMethods())
	    {
	    	if(method.isAnnotationPresent(CustomInit.class))
	    	{
	    		method.setAccessible(true);
	    		method.invoke(object);
	    	}
	    }
	}
    
    private String getJsonString(Object object) throws Exception 
    {  
	    Class<?> clazz = object.getClass();
	    Map<String, String> jsonElementsMap = new HashMap<>();
	    for (Field field : clazz.getDeclaredFields()) {
	        field.setAccessible(true);
	        if (field.isAnnotationPresent(CustomJsonElement.class)) {
	            jsonElementsMap.put(getKey(field), (String) field.get(object));
	        }
	    }
	      
	    String jsonString = jsonElementsMap.entrySet()
	        .stream()
	        .map(entry -> "\"" + entry.getKey() + "\":\""
	          + entry.getValue() + "\"")
	        .collect(Collectors.joining(","));
	    return "{" + jsonString + "}";
	}
    
    private String getKey(Field field) {
        String value = field.getAnnotation(CustomJsonElement.class)
            .key();
        return value.isEmpty() ? field.getName() : value;
    }
}