package com.example.mymemoir.datastructure;

import java.util.Date;

/**
 * @author LiJinFeng
 */
public class Usertable {
    private int id;
    private String surname;
    private String username;
    private String gender;
    private Date dob;
    private String address;
    private String state;
    private int postcode;

    public Usertable(int id){ this.id = id; }

    public Usertable(int id,String surname,String username,String gender,Date dob,String address,String state,int postcode){
        this.id = id;
        this.surname = surname;
        this.username = username;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.postcode = postcode;
    }
    public void setId(int id){ this.id = id; }
    public int getId(){ return id; }

    public void setSurname(String surname){ this.surname = surname; }
    public String getSurname(){ return surname; }

    public void setUsername(String username){ this.username = username; }
    public String getsername(){ return username; }

    public void setGender(String gender){ this.gender = gender; }
    public String getGender(){ return gender; }

    public void setDOB(Date dob){ this.dob = dob; }
    public Date getDOB(){ return dob; }

    public void setAddress(String address){ this.address = address; }
    public String getAddress(){ return address; }

    public void setState(String state){ this.state = state; }
    public String getState(){ return state; }

    public void setPostcode(int postcode){ this.postcode = postcode; }
    public int getPostcode(){ return postcode; }

}
