package com.cater.dto.beans;
// Generated Dec 24, 2015 12:22:57 AM by Hibernate Tools 4.3.1



/**
 * CatererLineContact generated by hbm2java
 */
public class CatererLineContact  implements java.io.Serializable {


     private Long id;
     private Caterer caterer;
     private String type;
     private String contact;
     private boolean isDeleted;

    public CatererLineContact() {
    }

    public CatererLineContact(Caterer caterer, String type, String contact, boolean isDeleted) {
       this.caterer = caterer;
       this.type = type;
       this.contact = contact;
       this.isDeleted = isDeleted;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Caterer getCaterer() {
        return this.caterer;
    }
    
    public void setCaterer(Caterer caterer) {
        this.caterer = caterer;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    public boolean isIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }




}


