/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.services;

import edu.eci.cosw.samples.model.Producto;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class ServicesFacade {
   
    private static final List<Producto> dummyProductsData=new LinkedList<>();
    
    static{
        dummyProductsData.add(new Producto(1,"producto 1",100));
        dummyProductsData.add(new Producto(2,"producto 2",200));
        dummyProductsData.add(new Producto(3,"producto 3",300));
        dummyProductsData.add(new Producto(4,"producto 4",400));
    }
    
    public void addNewProduct(Producto p){
        dummyProductsData.add(p);
    }
    
    public List<Producto> getAllProducts(){
        return dummyProductsData;
    }
    
}
