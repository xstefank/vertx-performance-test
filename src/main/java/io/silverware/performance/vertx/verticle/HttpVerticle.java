package io.silverware.performance.vertx.verticle;

import io.silverware.microservices.annotations.Deployment;
import io.silverware.performance.vertx.EchoService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
@Deployment(false)
public class HttpVerticle extends AbstractVerticle {

   private EchoService echoService;
   private HttpServer server;

   @Override
   public void start() throws Exception {
      echoService = EchoService.getEchoService();

      server = vertx.createHttpServer().requestHandler(req -> {
         req.response().end(echoService.hello());
      }).listen(8082, "localhost", res -> {
         if (res.succeeded()) {
            System.out.println("Server is now listening!");
         } else {
            System.out.println("Failed to bind!");
         }
      });
   }

   @Override
   public void stop() throws Exception {
      server.close();
   }
}
