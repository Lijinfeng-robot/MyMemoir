/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import username.Cinema;
import username.Memoir;

/**
 *
 * @author LiJinFeng
 */
@Stateless
@Path("username.memoir")
public class MemoirFacadeREST extends AbstractFacade<Memoir> {

    @PersistenceContext(unitName = "FIT5046PU")
    private EntityManager em;

    public MemoirFacadeREST() {
        super(Memoir.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Memoir entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Memoir entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Memoir find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Memoir> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Memoir> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
           
    @GET
    @Path("findByMemoirId/{memoirId}")
    @Produces({"application/json"})
    public List<Memoir> findByMemoirId(@PathParam("memoirId") int memoirId) {
        Query query = em.createNamedQuery("Memoir.findByMemoirId");
        query.setParameter("memoirId", memoirId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByUserId/{userId}")
    @Produces({"application/json"})
    public List<Memoir> findByUserId(@PathParam("userId") int userId) {
        Query query = em.createNamedQuery("Memoir.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCinemaId/{cinemaId}")
    @Produces({"application/json"})
    public List<Memoir> findByCinemaId(@PathParam("cinemaId") int cinemaId) {
        Query query = em.createNamedQuery("Memoir.findByCinemaId");
        query.setParameter("cinemaId", cinemaId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByMovieName/{movieName}")
    @Produces({"application/json"})
    public List<Memoir> findByMovieName(@PathParam("movieName") String movieName) {
        Query query = em.createNamedQuery("Memoir.findByMovieName");
        query.setParameter("movieName", movieName);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDateTime/{dateTime}")
    @Produces({"application/json"})
    public List<Memoir> findByDateTime(@PathParam("dateTime") String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateTime);
        Query query = em.createNamedQuery("Memoir.findByDateTime");
        query.setParameter("dateTime", date);
        return query.getResultList();
    }
    
    @GET
    @Path("findByMovieReleaseDate/{movieReleaseDate}")
    @Produces({"application/json"})
    public List<Memoir> findByMovieReleaseDate(@PathParam("movieReleaseDate") String movieReleaseDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(movieReleaseDate);
        Query query = em.createNamedQuery("Memoir.findByMovieReleaseDate");
        query.setParameter("movieReleaseDate",date);
        return query.getResultList();
    }
    
    @GET
    @Path("findByComment/{comment}")
    @Produces({"application/json"})
    public List<Memoir> findByComment(@PathParam("comment") String comment) {
        Query query = em.createNamedQuery("Memoir.findByComment");
        query.setParameter("comment", comment);
        return query.getResultList();
    }
    
    @GET
    @Path("findByScore/{score}")
    @Produces({"application/json"})
    public List<Memoir> findByScore(@PathParam("score") int score) {
        Query query = em.createNamedQuery("Memoir.findByScore");
        query.setParameter("score", score);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCombination2/{movieName}/{location}")
    @Produces({"application/json"})
    public List<Memoir> findByCombination2( @PathParam("movieName") String movieName,@PathParam("location") String location){
    TypedQuery<Memoir> q = em.createQuery("SELECT m FROM Memoir m WHERE m.cinemaId.location = ?1 AND m.movieName = ?2", Memoir.class);
        q.setParameter(1, movieName);
        q.setParameter(2, location);
        return q.getResultList();
    }
    @GET
    @Path("findByCombination3/{movieName}/{cinemaname}")
    @Produces({"application/json"})
    public List<Memoir> findByCombination3( @PathParam("movieName") String movieName,@PathParam("cinemaname") String name){
        Query query = em.createNamedQuery("Memoir.findByCombination");
        query.setParameter("movieName", movieName);
        query.setParameter("name", name);
        return query.getResultList();
    }
    @GET 
    @Path("Advanced1/{userid}/{startingdate}/{endingdate}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object Advanced1( @PathParam("userid") int userid, @PathParam("startingdate")String date1, @PathParam("endingdate")String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = sdf.parse(date1);
        Date enddate = sdf.parse(date2); 
        TypedQuery<Object[]> query = em.createQuery("SELECT m.cinemaId.location,count(m.memoirId) From Memoir m WHERE (m.dateTime BETWEEN :startingdate AND :endingdate) and m.userId.id = :userid Group BY m.cinemaId.location",Object[].class);
        query.setParameter("userid", userid);
        query.setParameter("startingdate", startdate);
        query.setParameter("endingdate", enddate);
        
        List<Object[]> queryList = query.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//        Map<String,Integer> exist = new HashMap<>();
        for(Object[] row : queryList){
           JsonObject personObject = Json.createObjectBuilder()
                   .add("suburbs",(String)row[0])
                   .add("number",(long)row[1]).build();
            arrayBuilder.add(personObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }


    
      @GET 
    @Path("Advanced2/{userid}/{year}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object Advanced2( @PathParam("userid") int userid, @PathParam("year")String year) throws ParseException {
        Map<Integer,String> pre = new HashMap<>();
        pre.put(1,"January");
        pre.put(2,"February");
        pre.put(3,"March");
        pre.put(4,"April");
        pre.put(5,"May");
        pre.put(6,"June");
        pre.put(7,"July");
        pre.put(8,"August");
        pre.put(9,"September");
        pre.put(10,"October");
        pre.put(11,"November");
        pre.put(12,"December");
        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
         SimpleDateFormat sdf = new SimpleDateFormat("Y");
         SimpleDateFormat sdf2 = new SimpleDateFormat("M");
        for(int i = 1;i<=12;i++){
              TypedQuery<Object[]> query = em.createQuery("Select m.memoirId,m.dateTime From Memoir m WHERE m.userId.id  = :userid ",Object[].class);
              query.setParameter("userid", userid);
              List<Object[]> queryList = query.getResultList();
              int number = 0;
              for(Object[] row : queryList){
                  String cur_year = sdf.format(row[1]);
                  String cur_month = sdf2.format(row[1]);
                  String temp = i + "";
                  if(cur_year.equals(year) && cur_month.equals(temp)){
                      number++;
                  }
              }
              JsonObject advanced2 = Json.createObjectBuilder()
                   .add("month",pre.get(i))
                   .add("number",number).build();
              arrayBuilder.add(advanced2);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
      
      
        }
        @GET 
    @Path("Advanced3/{userid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object Advanced3( @PathParam("userid") int userid) throws ParseException {
        TypedQuery<Object[]> query = em.createQuery("SELECT m.movieName,m.score,m.movieReleaseDate FROM Memoir m where m.userId.id = :userid ORDER BY m.score desc",Object[].class);
        query.setParameter("userid", userid);
        
        List<Object[]> queryList = query.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        int temp = (int)queryList.get(0)[1];
        for(Object[] row : queryList){
           if((int)row[1]!=temp){
               break;
           }
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
           String stringDate = sdf.format(row[2]);
           JsonObject Advanced3 = Json.createObjectBuilder()
                   .add("name",(String)row[0])
                   .add("score",(int)row[1])
                   .add("release date",stringDate).build();
            arrayBuilder.add(Advanced3);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    
    @GET 
    @Path("Advanced4/{userid}")
    @Produces({MediaType.APPLICATION_JSON})
    public String Advanced4( @PathParam("userid") int userid ) throws ParseException {
        TypedQuery<Object[]> query = em.createQuery("Select m.movieName, m.movieReleaseDate,m.dateTime, m.score From Memoir m WHERE m.userId.id = :userid",Object[].class);
        query.setParameter("userid", userid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<Object[]> queryList = query.getResultList();
        if(queryList.isEmpty()){
            return "not exist";
        }
        StringBuilder ans = new StringBuilder();
        for(Object[] row : queryList){
             String stringDate1 = sdf.format(row[1]);
              String stringDate2 = sdf.format(row[2]);
              if(stringDate1.substring(0,5).equals(stringDate2.substring(0,5))){
                  ans.append((String)row[0]);
                  ans.append("-");
                  ans.append(stringDate1);
                  ans.append("-");
                  ans.append(String.valueOf(row[3]));
                  ans.append("-");
              }
        }
        ans.delete(ans.length()-1,ans.length());
        return ans.toString();
    }


        @GET 
    @Path("Advanced5/{userid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object Advanced5( @PathParam("userid") int userid) throws ParseException {

        TypedQuery<Object[]> query = em.createQuery("SELECT m.movieName,m.movieReleaseDate From Memoir m WHERE m.userId.id = :userid",Object[].class);
        query.setParameter("userid", userid);

        List<Object[]> queryList = query.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
         Map<String,String> cur = new HashMap<>();
        for(Object[] row : queryList){
             String stringDate = sdf.format(row[1]);
            if(!cur.containsKey((String)row[0])){
                cur.put((String)row[0],stringDate.substring(0,5));
                continue;
            }
            if(!cur.get((String)row[0]).equals(stringDate.substring(0,5))){
                JsonObject temp1 = Json.createObjectBuilder()
                   .add("movie name",(String)row[0])
                   .add("release year",cur.get((String)row[0])).build();
                   arrayBuilder.add(temp1);
                JsonObject temp2 = Json.createObjectBuilder()
                   .add("movie name",(String)row[0])
                   .add("release year",stringDate.substring(0,5)).build();
                   arrayBuilder.add(temp2);
            }
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    
     @GET 
    @Path("Advanced6/{userid}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object Advanced6( @PathParam("userid") int userid) throws ParseException {
   
        TypedQuery<Object[]> query = em.createQuery("SELECT m.movieName,m.movieReleaseDate,m.score "
                + "From Memoir m " 
                + "WHERE m.userId.id = :userid AND :year = (FUNCTION('YEAR',m.movieReleaseDate))"
                + "Order by m.score desc"
                ,Object[].class);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy");
        Date date = new Date(System.currentTimeMillis());
        int year = Integer.parseInt(formatter.format(date));
        query.setParameter("year",year);  
        query.setParameter("userid",userid);
        query.setMaxResults(5);
   

        List<Object[]> queryList = query.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        for(Object[] row : queryList){
            String stringDate = sdf2.format(row[1]);
           JsonObject Advanced6 = Json.createObjectBuilder()
                   .add("movie name",(String)row[0])
                   .add("movie release date",stringDate)
                   .add("rating scores",(int)row[2]).build();
            arrayBuilder.add(Advanced6);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
