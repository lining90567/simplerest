package com.ln.simplerest.resource;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ln.simplerest.model.OrderItem;
import com.ln.simplerest.service.OrderItemService;

@Singleton
@Path("orderItems")
public class OrderItemResource extends AbstractResource {

	@Inject
	private OrderItemService orderItemService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderItemsByOrderId(String orderId) {
		try {
			List<OrderItem> itemList = orderItemService.listByOrderId(orderId);
			return Response.ok(itemList).build();
		} catch (Exception e) {
			Map<String, String> errorEntity = getResponseEntity("error", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
		}
	}

}
