package com.scp.controller;

import java.util.List;

/**
 * 
 * get
 * http://localhost:8090/restws/rest/products/{id}  -- getProduct
 *
 * PUT
 * http://localhost:8090/restws/rest/products  -- addProduct
 * 
 * 
 */


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.scp.bean.Product;
import com.scp.exception.ProductNFound;
import com.scp.service.ProductService;
import com.scp.service.ProductServiceImpl;




@Path("/products")

public class ProductController {

	ProductService pService = new ProductServiceImpl();
	
	@GET
    @Produces(MediaType.TEXT_HTML)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public /*Product*/ Response getProduct(@PathParam("id") int id ){
		System.out.println("rest get prod by id "+id);
		Response rs = Response.status(200).header("My Header",pService.getProduct(id)).build();
		
		return rs;
	//	return  pService.getProduct(id);
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	//@Path("/myprod")
	public Product addMyProduct(Product p){
		System.out.println("Adding product :"+p);
		return  pService.addProduct(p);
	}
	
	
	
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	//@Produces(MediaType.)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductInfo(){
		/*if(true)
			throw new ProductNFound("Products are not available...");*/
		return pService.getAllProducts();
		
	}
	
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public int deleteProduct(@PathParam("id") int id){
		return pService.deleteProduct(id);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	public Product updateProductInfo(Product product){
		return pService.updateProduct(product);
	}
	
	/*@POST
	@Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	@Consumes(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	public Product addProductInfo(Product product){

		System.out.println("Received product through web service");
		return pService.addProduct(product);
		
	}
	*/
	
	
}
