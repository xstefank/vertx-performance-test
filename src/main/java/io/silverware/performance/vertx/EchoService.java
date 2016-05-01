package io.silverware.performance.vertx;

import io.silverware.microservices.annotations.Gateway;
import io.silverware.microservices.annotations.Microservice;
import io.silverware.microservices.providers.cdi.MicroservicesStartedEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
@Microservice
public class EchoService {

   private static final Logger log = LogManager.getLogger(EchoService.class);


   public static String hello() {
      return "EchoService hello";
   }

   public static String sayHello(final String msg) {
      return "Answering '" + msg + "' with 'How do you do!'";
   }

}
