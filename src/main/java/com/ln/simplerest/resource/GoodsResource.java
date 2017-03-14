package com.ln.simplerest.resource;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ln.simplerest.model.Goods;
import com.ln.simplerest.service.GoodsService;
import com.ln.simplerest.support.mybatis.data.Page;

@Singleton
@Path("/goods")
public class GoodsResource extends AbstractResource {

	@Inject
	private GoodsService goodsService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGoods() {
		try {
			List<Goods> goodsList = goodsService.listAllGoods();
			return Response.ok(goodsList).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGoodsById(@PathParam("id") String id) {
		try {
			Goods goods = goodsService.getById(id);
			if (goods != null) {
				return Response.ok(goods).build();
			}
			return Response.status(Response.Status.NOT_FOUND).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGoods(Goods goods) {
		try {
			goodsService.saveGoods(goods);
			return Response.ok(goods.getId()).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

	@GET
	@Path("/listPaged")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPagedGoods(@QueryParam("name") String name, @QueryParam("pageIndex") int pageIndex,
			@QueryParam("pageSize") int pageSize, @QueryParam("order") String order) {
		try {
			Page<Goods> page = goodsService.listPagedGoods(pageIndex, pageSize, name, order);
			return Response.ok(page).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGoods(@PathParam("id") String id, Goods goods) {
		goods.setId(id);
		try {
			int rows = goodsService.updateGoods(goods);
			if (rows > 0) {
				return Response.ok().build();
			}
			return Response.status(Response.Status.NOT_FOUND).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeGoods(@PathParam("id") String id) {
		try {
			int rows = goodsService.removeGoods(id);
			if (rows > 0) {
				return Response.ok().build();
			}
			return Response.status(Response.Status.NOT_FOUND).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

}
