package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;


@Entity
public class User extends Model{

	@Id
	Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	
	public User(String firstName,String lastName, String email, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	public static Find<Integer, User> find = new Find<Integer,User>(){
		
	};
	
	public static PagedList<User> page(int page, int pageSize, String sortBy, String orderBy, String filter){
		return find.where().like("first_name","%" + filter + "%").orderBy(sortBy+""+orderBy).findPagedList(page, pageSize);
	}
	
	public static List<User> getAllUser(){
		return find.findList();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
