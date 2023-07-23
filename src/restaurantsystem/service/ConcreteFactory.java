/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantsystem.service;

/**
 *
 * @author melis
 */
public class ConcreteFactory extends Factory{

    @Override
    public ManageService createService(ServiceType type) {
        switch(type){
            case ITEM_SERVICE:
                return new ItemService();
            case LABOUR_SERVICE:
                return new LabourService();
            default:
                return null;
        }
    }
    
}
