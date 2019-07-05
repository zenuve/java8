package java8practice.customAnnotation;

public class CustomMain {

	public static void main(String[] args) {
		Person p=new Person();
		p.setFirstName("abhishek");
		p.setLastName("chaurasia");
		p.setAge("30");
		ObjectToJsonConverter obj=new ObjectToJsonConverter();
		try {
			System.out.println(obj.convertToJson(p));
		} catch (CustomJsonSerializationException e) {
			e.printStackTrace();
		}
	}

}
