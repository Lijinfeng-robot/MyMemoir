package com.example.mymemoir.datastructure;

import java.util.Date;

/**
 * @author LiJinFeng
 */
public class Credentials {
  private int id;
  private String username;
  private String passwordHash;
  private Date signUpDate;
  public Usertable userId;

  public Credentials() {}

  public  Credentials(int id, String username, String passwordHash, Date signUpDate) {
    this.id = id;
    this.username = username;
    this.passwordHash = passwordHash;
    this.signUpDate = signUpDate;
  }
  public void setUserId(int id,String surname,String username,String gender,Date dob,String address,String state,int postcode){
    userId = new Usertable(id,surname,username,gender,dob,address,state,postcode);
  }
  public void setUserId2(Usertable userId){
    this.userId =  userId;
  }
  public void setUserId(int Id) { userId = new Usertable(Id); }
  public int getUserId() { return userId.getId(); }

  public void setId(int id) { this.id = id; }
  public int getId() { return id; }

  public void setUsername(String username) { this.username = username; }
  public String getUsername() { return username; }


  public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
  public String getPasswordHash() { return passwordHash; }

  public void setSignUpDate(Date signUpDate) { this.signUpDate = signUpDate; }
  public Date getSignUpDate() { return signUpDate; }

}
