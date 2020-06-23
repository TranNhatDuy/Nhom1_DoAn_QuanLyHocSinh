package DTO;

public class UserDTO {
    private String UserID,userName, password,role;
	public UserDTO(String UserID,String userName, String password,String Role) {
		// TODO Auto-generated constructor stub
        this.UserID = UserID;
		this.userName = userName;
		this.password = password; 
        this.role = Role;       
	}
    public UserDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
