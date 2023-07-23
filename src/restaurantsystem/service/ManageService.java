/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurantsystem.service;

import java.util.List;

/**
 *
 * @author melis
 */
public interface ManageService<E> {
    public List<E> getAll();
    public void create(E type);
    public boolean update(String id, E type);
    public boolean delete(String type);
}
