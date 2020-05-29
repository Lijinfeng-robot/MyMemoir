/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package username;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LiJinFeng
 */
@Entity
@Table(name = "USERTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertable.findAll", query = "SELECT u FROM Usertable u")
    , @NamedQuery(name = "Usertable.findById", query = "SELECT u FROM Usertable u WHERE u.id = :id")
    , @NamedQuery(name = "Usertable.findBySurname", query = "SELECT u FROM Usertable u WHERE u.surname = :surname")
    , @NamedQuery(name = "Usertable.findByUsername", query = "SELECT u FROM Usertable u WHERE u.username = :username")
    , @NamedQuery(name = "Usertable.findByGender", query = "SELECT u FROM Usertable u WHERE u.gender = :gender")
    , @NamedQuery(name = "Usertable.findByDob", query = "SELECT u FROM Usertable u WHERE u.dob = :dob")
    , @NamedQuery(name = "Usertable.findByAddress", query = "SELECT u FROM Usertable u WHERE u.address = :address")
    , @NamedQuery(name = "Usertable.findByState", query = "SELECT u FROM Usertable u WHERE u.state = :state")
    , @NamedQuery(name = "Usertable.findByPostcode", query = "SELECT u FROM Usertable u WHERE u.postcode = :postcode")})
public class Usertable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SURNAME")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTCODE")
    private int postcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Credentials> credentialsCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Memoir> memoirCollection;

    public Usertable() {
    }

    public Usertable(Integer id) {
        this.id = id;
    }

    public Usertable(Integer id, String surname, String username, String gender, Date dob, String address, String state, int postcode) {
        this.id = id;
        this.surname = surname;
        this.username = username;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.postcode = postcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @XmlTransient
    public Collection<Credentials> getCredentialsCollection() {
        return credentialsCollection;
    }

    public void setCredentialsCollection(Collection<Credentials> credentialsCollection) {
        this.credentialsCollection = credentialsCollection;
    }

    @XmlTransient
    public Collection<Memoir> getMemoirCollection() {
        return memoirCollection;
    }

    public void setMemoirCollection(Collection<Memoir> memoirCollection) {
        this.memoirCollection = memoirCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertable)) {
            return false;
        }
        Usertable other = (Usertable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "username.Usertable[ id=" + id + " ]";
    }
    
}
