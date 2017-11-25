package cz.expertkom.ju.L07HomeWorkProduts.Api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

@CrossOriginResourceSharing(allowAllOrigins = true)
public interface ApplicationApi {
	
	/* papoušek*/
	@GET
	@Path("Papousek/Variable/{ValueVariable}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response serviceApiMethod (@PathParam(value = "ValueVariable") String param);

	
	

}
