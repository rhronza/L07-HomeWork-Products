package cz.expertkom.ju.L07HomeWorkProduts.Api.Impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import cz.expertkom.ju.Papousek;
import cz.expertkom.ju.L07HomeWorkProduts.Api.ApplicationApi;
import cz.expertkom.ju.entity.PriceProductDto;

public class ApplicationApiImpl implements ApplicationApi {
	
	@Autowired
	Papousek papousek;
	
	

	public Response papousek(String parametr) {
		String outputString = papousek.papouskovani(parametr);
		return Response.ok(outputString).build();
	}

	@Override
	public Response viewOneProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response viewAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response insertProduct(PriceProductDto priceProductDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateProduct(Long id, PriceProductDto priceProductDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
