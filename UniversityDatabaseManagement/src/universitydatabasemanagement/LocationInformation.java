/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class LocationInformation {
    private StringProperty full_address,town,district,state,country;
    public LocationInformation(String full_address,String town,String district,String state,String country){
        this.full_address=new SimpleStringProperty(full_address);
        this.town=new SimpleStringProperty(town);
        this.district=new SimpleStringProperty(district);
        this.state=new SimpleStringProperty(state);
        this.country=new SimpleStringProperty(country);
    }

    /**
     *
     * @return
     */
    public String getFull_address(){
        return full_address.get();
    }
    public String getTown(){
        return town.get();
    }
    public String getDistrict(){
        return district.get();
    }
    public String getState(){
        return state.get();
    }
    public String getCountry(){
        return country.get();
    }
}
