/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.controllers;

import edu.eci.cosw.samples.model.Producto;
import edu.eci.cosw.services.ServicesFacade;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    ServicesFacade services;
    
    
    @RequestMapping(value="/check",method = RequestMethod.GET)        
    public String check() {
        return "REST API OK";        
    }
    
    @RequestMapping(method = RequestMethod.POST)        
    public ResponseEntity<?> addProduct(@RequestBody Producto p) {       
        services.addNewProduct(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    
    @RequestMapping(method = RequestMethod.GET)     
    @PreAuthorize("#oauth2.isUser() and #oauth2.clientHasRole('ROLE_XXXUSER') and #oauth2.hasScope('read')")
    public List<Producto> allProducts() {       
        return services.getAllProducts();
    }
    

    
    
}

