package cz.expertkom.ju.L07HomeWorkProduts.Api;

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
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import cz.expertkom.ju.entity.PriceProductDto;

@CrossOriginResourceSharing(allowAllOrigins = true)
public interface ApplicationApi {
	
	/* papoušek - testovací (dva vstupy přes URI), nepřístupuje do databáze */
	@GET
	@Path("Papousek/Variable/{ValueVariable}/{ValueVariable2}/")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response papousek (@PathParam(value = "ValueVariable") String param, @PathParam(value = "ValueVariable2") String param2);
	
	/* vložení nové hodnoty */
	@POST
	@Path("product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertProduct(PriceProductDto priceProductDto );

	/* zrušení záznamu dle id */
	@DELETE
	@Path("product/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam(value = "param") Long id);
	
	/* aktualizace záznamu dle id a nové hodnoty */
	@PUT
	@Path("product/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduct(@PathParam(value = "param") Long id, PriceProductDto priceProductDto);

	/*  vrátí konkrétní výskyt podle zadaného id */
	@GET
	@Path("productOne/{param}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewOneProduct (@PathParam(value = "param") Long id);
	
	/* zobrazení všech položek */
	@GET
	@Path("products")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewAllProducts();

	

	
	

}
