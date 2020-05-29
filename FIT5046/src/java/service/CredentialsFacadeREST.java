/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.registry.infomodel.User;
import username.Credentials;
 /**
 *
 * @author LiJinFeng
 */
@Stateless
@Path("username.credentials")
public class CredentialsFacadeREST extends AbstractFacade<Credentials> {

    @PersistenceContext(unitName = "FIT5046PU")
    private EntityManager em;

    public CredentialsFacadeREST() {
        super(Credentials.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credentials entity) {
        super.create(entity);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Credentials entity) {
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
    public Credentials find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credentials> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentials> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
         @GET
    @Path("findByUsername/{username}")
    @Produces({"application/json"})
    public List<Credentials> findByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Credentials.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPasswordHash/{passwordHash}")
    @Produces({"application/json"})
    public List<Credentials> findByPasswordHash(@PathParam("passwordHash") String passwordHash) {
        
        Query query = em.createNamedQuery("Credentials.findByPasswordHash");
        query.setParameter("passwordHash",passwordHash);
        return query.getResultList();
    }
    
    @GET
    @Path("findBySignUpDate/{findBySignUpDate}")
    @Produces({"application/json"})
    public List<Credentials> findBySignUpDate(@PathParam("findBySignUpDate") String signUpDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sign = sdf.parse(signUpDate);
        Query query = em.createNamedQuery("Credentials.findBySignUpDate");
        query.setParameter("signUpDate",sign);
        return query.getResultList();

    }
    
         @GET
    @Path("findPasswordByUsername/{username}")
    public String findPasswordByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Credentials.findByUsername");
        query.setParameter("username", username);
        if(query.getResultList().isEmpty()){
            return "not exist";
        }
        return ((Credentials)query.getResultList().get(0)).getPasswordHash();
    }
    @GET
        @Path("findFirstNameByUsername/{username}")
    public String findFirstNameByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Credentials.findByUsername");
        query.setParameter("username", username);   
        return ((Credentials)query.getResultList().get(0)).getUserId().getUsername();
    }
//    @GET
//    @Path("SignUp/{information}")
//    public String SignUp(@PathParam("information") String information) {
//        String[] inf_arr = information.split("-");
//         if (inf_arr[0].isEmpty() || inf_arr[0].length() > 10) {
//            return "PLEASE INPUT CORRECT FIRSTNAME!";
//        } else if (inf_arr[1].isEmpty() || inf_arr[1].length() > 10) {
//           return "PLEASE INPUT CORRECT SURNAME!";
//        }else if (inf_arr[2] == null){
//            return "PLEASE CHOOSE GENDER FIRST!";
//        } else if (inf_arr[3] == null){
//            return "PLEASE CHOOSE CORRECT DOB";
//        } else if (inf_arr[6].isEmpty() || inf_arr[4].length() > 30) {
//            return "PLEASE INPUT CORRECT ADDRESS!";
//        }else if (inf_arr[7].isEmpty()) {
//            return "PLEASE INPUT CORRECT STATE!";
//        } else if (inf_arr[8].isEmpty()) {
//            return "PLEASE INPUT CORRECT POSTCODE!";
//        } else if (inf_arr[9].isEmpty()
////                || !inf_arr[7].contains("@")
////                || !inf_arr[7].contains(".")
////                || inf_arr[7].lastIndexOf(".") < inf_arr[7].lastIndexOf("@")
//                || inf_arr[9].length() > 40) {
//            return "PLEASE INPUT CORRECT E_MAIL!";
//        } else if (inf_arr[10].isEmpty()) {
//            return "PLEASE INPUT CORRECT PASSWORD!";
//        }
//        Query query = em.createNamedQuery("Credentials.findByUsername");
//        query.setParameter("username", inf_arr[9]);
//        if(!query.getResultList().isEmpty()){
//            return "THE E-MAIL HAS SIGNED UP!";
//        }else{
//           int count = super.count()+1;
//           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//           Date date = new Date(System.currentTimeMillis());
//           String dateString = simpleDateFormat.format(date);
////           
//           String sql1 = "INSERT INTO USERNAME.USERTABLE (ID, SURNAME, USERNAME, GENDER, DOB, ADDRESS, STATE, POSTCODE) " +
//                   "VALUES (?1,\'"+ inf_arr[1]+"\',\'"+inf_arr[0]+"\',\'"+inf_arr[2]+"\',\'"+inf_arr[3] + "-"+ inf_arr[4] + "-" +inf_arr[5]+ "\',\'"+inf_arr[6]+"\',\'"+inf_arr[7]+"\',?2)";
//           Query query2 = em.createNativeQuery(sql1);
//           query2.setParameter(1, count);
//           query2.setParameter(2, Integer.valueOf(inf_arr[8]));    
//           query2.executeUpdate();
//////           
//           String sql2 = "INSERT INTO USERNAME.CREDENTIALS (ID, USERNAME, PASSWORD_HASH, SIGN_UP_DATE, USER_ID) " +
//        "VALUES (?1,\'" + inf_arr[9] + "\',\'" + inf_arr[10]+ "\',\'"+ dateString +"\',?2)";
//           Query query3 = em.createNativeQuery(sql2);
//           query3.setParameter(1, count);
//            query3.setParameter(2, count);
//           query3.executeUpdate();
//        } 
//        return "SIGN UP SUCCESSFULLY"  ;
//    }
    
    
    @POST
    @Path("/SignUp")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String SignUp(Credentials cre) {
         if (cre.getUserId().getUsername().isEmpty() || cre.getUserId().getUsername().length() > 10) {
            return "PLEASE INPUT CORRECT FIRSTNAME!";
        } else if (cre.getUserId().getSurname().isEmpty() || cre.getUserId().getSurname().length() > 10) {
           return "PLEASE INPUT CORRECT SURNAME!";
        }else if (cre.getUserId().getGender() == null){
            return "PLEASE CHOOSE GENDER FIRST!";
        }else if (cre.getUserId().getAddress().isEmpty() || cre.getUserId().getAddress().length() > 30) {
            return "PLEASE INPUT CORRECT ADDRESS!";
        }else if (cre.getUserId().getState().isEmpty()) {
            return "PLEASE INPUT CORRECT STATE!";
        } else if (cre.getUsername().isEmpty()
//                || !inf_arr[7].contains("@")
//                || !inf_arr[7].contains(".")
//                || inf_arr[7].lastIndexOf(".") < inf_arr[7].lastIndexOf("@")
                || cre.getUsername().length()> 40) {
            return "PLEASE INPUT CORRECT E_MAIL!";
        } 
        Query query = em.createNamedQuery("Credentials.findByUsername");
        query.setParameter("username", cre.getUsername());
        if(!query.getResultList().isEmpty()){
            return "PLEASE RE-ENTER THE E-MAIL!";
        }else{
            
           java.sql.Date sqlDate1 = new java.sql.Date(cre.getUserId().getDob().getTime());
           java.sql.Date sqlDate2 = new java.sql.Date(cre.getSignUpDate().getTime());
//           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//           String dateString1 = simpleDateFormat.format(sqlDate1);
//           String dateString2 = simpleDateFormat.format(sqlDate2);

//////      
           String sql1 = "INSERT INTO USERNAME.USERTABLE (ID, SURNAME, USERNAME, GENDER, DOB, ADDRESS, STATE, POSTCODE) " +
                   "VALUES (?1,\'"+ cre.getUserId().getSurname()+"\',\'"+cre.getUserId().getUsername()+"\',\'"+ cre.getUserId().getGender()+"\',\'"+ sqlDate1+ "\',\'"+ cre.getUserId().getAddress()+"\',\'"+cre.getUserId().getState()+"\',?2)";
           Query query2 = em.createNativeQuery(sql1);
           query2.setParameter(1, String.valueOf(cre.getId()));
           query2.setParameter(2, String.valueOf(cre.getUserId().getPostcode()));    
           query2.executeUpdate();
        
////           
           String sql2 = "INSERT INTO USERNAME.CREDENTIALS (ID, USERNAME, PASSWORD_HASH, SIGN_UP_DATE, USER_ID) " +
        "VALUES (?1,\'" + cre.getUsername() + "\',\'" + cre.getPasswordHash()+ "\',\'"+ sqlDate2 +"\',?2)";
           Query query3 = em.createNativeQuery(sql2);
           query3.setParameter(1,cre.getId());
            query3.setParameter(2, cre.getId());
           query3.executeUpdate();
        } 
    return "SIGN UP SUCCESSFULLY" ;
}
    @GET
        @Path("findIdyUsername/{username}")
    public int findIdyUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Credentials.findByUsername");
        query.setParameter("username", username);   
        return ((Credentials)query.getResultList().get(0)).getUserId().getId();
    }

    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
