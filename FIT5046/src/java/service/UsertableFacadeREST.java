/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
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
import username.Usertable;

/**
 *
 * @author LiJinFeng
 */
@Stateless
@Path("username.usertable")
public class UsertableFacadeREST extends AbstractFacade<Usertable> {

    @PersistenceContext(unitName = "FIT5046PU")
    private EntityManager em;

    public UsertableFacadeREST() {
        super(Usertable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usertable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usertable entity) {
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
    public Usertable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usertable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usertable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
           @GET
    @Path("findBySurname/{surname}")
    @Produces({"application/json"})
    public List<Usertable> findBySurname(@PathParam("surname") String surname) {
        Query query = em.createNamedQuery("Usertable.findBySurname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }
    
    @GET
    @Path("findByUsername/{username}")
    @Produces({"application/json"})
    public List<Usertable> findByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Usertable.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<Usertable> findByGender(@PathParam("gender") String gender) {
        Query query = em.createNamedQuery("Usertable.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<Usertable> findByDob(@PathParam("dob") String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dobDate = sdf.parse(dob);
        Query query = em.createNamedQuery("Usertable.findByDob");
         query.setParameter("dob", dobDate);
          return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Usertable> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Usertable.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    @GET
    @Path("findByState/{state}")
    @Produces({"application/json"})
    public List<Usertable> findByState(@PathParam("state") String state) {
        Query query = em.createNamedQuery("Usertable.findByState");
        query.setParameter("state", state);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<Usertable> findByPostcode(@PathParam("postcode") int postcode) {
        Query query = em.createNamedQuery("Usertable.findByPostcode");
        query.setParameter("postcode",postcode);
        return query.getResultList();
    }
        @GET
    @Path("findBynCombination/{address}/{state}/{postcode}")
    @Produces({"application/json"})
    public List<Usertable> findBynCombination(@PathParam("address") String address, @PathParam("state")String state, @PathParam("postcode")int postcode) {
        TypedQuery<Usertable> query = em.createQuery("SELECT u FROM Usertable u WHERE u.address = :address AND u.state= :state AND u.postcode = :postcode", Usertable.class);
        query.setParameter("address", address);
        query.setParameter("state", state);
        query.setParameter("postcode", postcode);
         return query.getResultList();
}
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
