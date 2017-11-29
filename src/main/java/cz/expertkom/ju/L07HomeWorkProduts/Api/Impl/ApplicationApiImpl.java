package cz.expertkom.ju.L07HomeWorkProduts.Api.Impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;

import cz.expertkom.ju.Papousek;
import cz.expertkom.ju.PriceProductDb;
import cz.expertkom.ju.L07HomeWorkProduts.Api.ApplicationApi;
import cz.expertkom.ju.entity.PriceProductDto;
import cz.expertkom.ju.entity.PriceProducts;

public class ApplicationApiImpl implements ApplicationApi {
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	
	@Autowired
	Papousek papousek;
	
	@Autowired
	PriceProductDb priceProductDb;
	
	private static final Gson GSON= new Gson(); 
	
	public Response papousek(String parametr1, String parametr2) {
		String outputString = papousek.papouskovani(parametr1, parametr2);
		return Response.ok(outputString).build();
	}

	@Override
	public Response viewOneProduct(Long id) {
		PriceProducts pps = new PriceProducts();
		pps = priceProductDb.getOneProductToList(id);
		String s = GSON.toJson(pps);
		System.out.println(s);
		return Response.ok(s).build() ;
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
