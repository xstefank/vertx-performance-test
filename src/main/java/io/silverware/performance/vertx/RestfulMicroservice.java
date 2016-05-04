package io.silverware.performance.vertx;

import io.silverware.microservices.annotations.Gateway;
import io.silverware.microservices.annotations.Microservice;
import io.silverware.microservices.annotations.MicroserviceReference;
import io.silverware.microservices.annotations.ParamName;
import io.silverware.microservices.providers.cdi.MicroservicesStartedEvent;
import io.silverware.performance.vertx.verticle.HttpVerticle;

import io.vertx.core.Vertx;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
@Gateway
@Microservice
public class RestfulMicroservice {

   @Inject
   @MicroserviceReference
   private Vertx vertx;

   @Inject
   @MicroserviceReference
   private EchoService echoService;

   public String hello() {
      return echoService.hello();
   }

   public String sayHello(@ParamName("msg") String msg) {
      return echoService.sayHello(msg);
   }

   public void observer(@Observes MicroservicesStartedEvent event) {
      //invoke PostConstruct to initialize static echo instance
      echoService.hello();

      //deploy the verticle which will use the initialized static instance
      vertx.deployVerticle(HttpVerticle.class.getName());
   }
}
