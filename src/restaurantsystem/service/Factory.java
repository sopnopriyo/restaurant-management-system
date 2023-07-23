/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantsystem.service;

/**
 *
 * @author melis
 */
public abstract class Factory {
    public abstract ManageService createService(ServiceType type);
}
