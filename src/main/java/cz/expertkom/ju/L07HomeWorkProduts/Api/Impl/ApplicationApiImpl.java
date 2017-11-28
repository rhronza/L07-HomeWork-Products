package cz.expertkom.ju.L07HomeWorkProduts.Api.Impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import cz.expertkom.ju.Papousek;
import cz.expertkom.ju.PriceProductDb;
import cz.expertkom.ju.L07HomeWorkProduts.Api.ApplicationApi;
import cz.expertkom.ju.entity.PriceProductDto;
import cz.expertkom.ju.entity.PriceProducts;

public class ApplicationApiImpl implements ApplicationApi {
	
	@Autowired
	Papousek papousek;
	
	@Autowired
	PriceProductDb priceProductDb;
	
	public Response papousek(String parametr1, String parametr2) {
		String outputString = papousek.papouskovani(parametr1, parametr2);
		return Response.ok(outputString).build();
	}

	@Override
	public Response viewOneProduct(Long id) {
		System.out.println("viewOneProduct");
		//PriceProducts priceProducts = new PriceProducts();
		System.out.println("viewOneProduct2");
		System.out.println("viewOneProduct3");
		//return Response.ok(priceProductDb.getOneProductToList(id)).build() ;
		return Response.ok(priceProductDb.getOneProductToList(id)).build() ;
	}

	@Override
	public Response viewAllProducts() {
		return Response.ok(priceProductDb.getAllProducts()).build() ;
	}

	@Override
	public Response insertProduct(PriceProductDto priceProductDto) {
		priceProductDb.insertPriceproduct(priceProductDto);
		return Response.ok().build();
	}

	@Override
	public Response deleteProduct(Long id) {
		priceProductDb.deletePriceProduct(id);
		return Response.ok().build();
	}

	@Override
	public Response updateProduct(Long id, PriceProductDto priceProductDto) {
		priceProductDb.updatePriceProduct(id, priceProductDto);
		return Response.ok().build();
	}
	
}
