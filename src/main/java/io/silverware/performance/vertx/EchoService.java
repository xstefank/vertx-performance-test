package io.silverware.performance.vertx;

import io.silverware.microservices.annotations.Gateway;
import io.silverware.microservices.annotations.Microservice;
import io.silverware.microservices.annotations.MicroserviceReference;
import io.silverware.microservices.providers.cdi.MicroservicesStartedEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
@Microservice
public class EchoService {

   private static final Logger log = LogManager.getLogger(EchoService.class);

   //inject this class to use all required CDI code
   @Inject
   @MicroserviceReference
   private EchoService echoServiceInjected;

   //save the injected instance into static field
   private static EchoService echoService;

   @PostConstruct
   private void postConstruct() {
      echoService = echoServiceInjected;
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
