package io.silverware.performance.vertx;

import io.silverware.microservices.annotations.Gateway;
import io.silverware.microservices.annotations.Microservice;
import io.silverware.microservices.annotations.MicroserviceReference;
import io.silverware.microservices.annotations.ParamName;

import javax.inject.Inject;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
@Gateway
@Microservice
public class RestfulMicroservice {

   @Inject
   @MicroserviceReference
   private EchoService echoService;

   public String hello() {
      return echoService.hello();
   }

   public String sayHello(@ParamName("msg") String msg) {
      return echoService.sayHello(msg);
   }
}
