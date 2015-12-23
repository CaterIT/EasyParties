package com.cater.tos.beans;
// Generated Dec 24, 2015 12:22:57 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * MasterCountry generated by hbm2java
 */
public class MasterCountry  implements java.io.Serializable {


     private Long countryId;
     private String countryName;
     private boolean visible;
     private Set masterStates = new HashSet(0);

    public MasterCountry() {
    }

	
    public MasterCountry(String countryName, boolean visible) {
        this.countryName = countryName;
        this.visible = visible;
    }
    public MasterCountry(String countryName, boolean visible, Set masterStates) {
       this.countryName = countryName;
       this.visible = visible;
       this.masterStates = masterStates;
    }
   
    public Long getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
    public String getCountryName() {
        return this.countryName;
    }
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public boolean isVisible() {
        return this.visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public Set getMasterStates() {
        return this.masterStates;
    }
    
    public void setMasterStates(Set masterStates) {
        this.masterStates = masterStates;
    }




}


