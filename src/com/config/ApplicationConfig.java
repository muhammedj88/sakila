package com.config;

import org.glassfish.jersey.server.ResourceConfig;

import controller.ActorController;


public class ApplicationConfig extends ResourceConfig {

public ApplicationConfig() {
register(ActorController.class);

register(da.ActorFacadeREST.class);

}
}
