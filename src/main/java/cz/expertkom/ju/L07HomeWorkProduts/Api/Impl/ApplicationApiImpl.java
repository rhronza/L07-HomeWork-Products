package cz.expertkom.ju.L07HomeWorkProduts.Api.Impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import cz.expertkom.ju.Papousek;
import cz.expertkom.ju.L07HomeWorkProduts.Api.ApplicationApi;

public class ApplicationApiImpl implements ApplicationApi {
	
	@Autowired
	Papousek papousek;

	public Response serviceApiMethod(String parametr) {
		String outputString = papousek.papouskovani(parametr);
		return Response.ok(outputString).build();
	}
}
