package com.first.first.sample;


import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class HateOasSampleController {

	@GetMapping("hello_HateOas")
	public EntityModel<HateOas> hello() {
		HateOas hateOas = new HateOas();
		hateOas.setPrefix("hey,");
		hateOas.setName("ds");
		
		
		EntityModel<HateOas> helloResource = new EntityModel<>(hateOas);
		helloResource.add(linkTo(methodOn(HateOasSampleController.class).hello()).withSelfRel());

		return helloResource;
	}
}
