/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package username;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LiJinFeng
 */
@Entity
@Table(name = "MEMOIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memoir.findAll", query = "SELECT m FROM Memoir m")
    , @NamedQuery(name = "Memoir.findByMemoirId", query = "SELECT m FROM Memoir m WHERE m.memoirId = :memoirId")
    , @NamedQuery(name = "Memoir.findByMovieName", query = "SELECT m FROM Memoir m WHERE m.movieName = :movieName")
    , @NamedQuery(name = "Memoir.findByDateTime", query = "SELECT m FROM Memoir m WHERE m.dateTime = :dateTime")
    , @NamedQuery(name = "Memoir.findByMovieReleaseDate", query = "SELECT m FROM Memoir m WHERE m.movieReleaseDate = :movieReleaseDate")
    , @NamedQuery(name = "Memoir.findByComment", query = "SELECT m FROM Memoir m WHERE m.comment = :comment")
    , @NamedQuery(name = "Memoir.findByScore", query = "SELECT m FROM Memoir m WHERE m.score = :score")
     , @NamedQuery(name = "Memoir.findByCombination", query = "SELECT m FROM Memoir m WHERE m.cinemaId.name = :name AND m.movieName = :movieName")})
public class Memoir implements Serializable {
    
//    private Integer number;
//    private String suburbs;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMOIR_ID")
    private Integer memoirId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TIME")
    @Temporal(TemporalType.DATE)
    private Date dateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIE_RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date movieReleaseDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "COMMENT")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCORE")
    private int score;
    @JoinColumn(name = "CINEMA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cinema cinemaId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Usertable userId;
////    

////    
    public Memoir() {
    }

    public Memoir(Integer memoirId) {
        this.memoirId = memoirId;
    }

    public Memoir(Integer memoirId, String movieName, Date dateTime, Date movieReleaseDate, String comment, int score) {
        this.memoirId = memoirId;
        this.movieName = movieName;
        this.dateTime = dateTime;
        this.movieReleaseDate = movieReleaseDate;
        this.comment = comment;
        this.score = score;
    }
    
//    public Memoir(String suburbs, Integer number){
//        this.suburbs = suburbs;
//        this.number = number;
//    }
    public Integer getMemoirId() {
        return memoirId;
    }

    public void setMemoirId(Integer memoirId) {
        this.memoirId = memoirId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Cinema getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Cinema cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Usertable getUserId() {
        return userId;
    }

    public void setUserId(Usertable userId) {
        this.userId = userId;
    }
//     public int getNumber() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
//    public String getSuburbs() {
//        return suburbs;
//    }
//
//    public void setSuburbs(String suburbs) {
//        this.suburbs = suburbs;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memoirId != null ? memoirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memoir)) {
            return false;
        }
        Memoir other = (Memoir) object;
        if ((this.memoirId == null && other.memoirId != null) || (this.memoirId != null && !this.memoirId.equals(other.memoirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "username.Memoir[ memoirId=" + memoirId + " ]";
    }
    
}
