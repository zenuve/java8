package java8practice;

public class User {
	public int id;
    public String name;
    public User(int userId, Object object) {
		this.id=userId;
		this.name=(String) object;
	}
	
}
