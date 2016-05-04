package io.silverware.performance.vertx;

import io.silverware.microservices.annotations.Microservice;

import java.io.Serializable;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
@Microservice
public class EchoService implements Serializable {

   //save the injected instance into static field
   private static EchoService echoService;

   @PostConstruct
   private void postConstruct() {
      echoService = this;
   }

   public static EchoService getEchoService() {
      return echoService;
   }

   public String hello() {
      return "EchoService hello";
   }

   public String sayHello(final String msg) {
      return "Answering '" + msg + "' with 'How do you do!'";
   }

}
