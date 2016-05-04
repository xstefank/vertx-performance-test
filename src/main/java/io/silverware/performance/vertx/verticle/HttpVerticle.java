package io.silverware.performance.vertx.verticle;

import io.silverware.performance.vertx.EchoService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
public class HttpVerticle extends AbstractVerticle {

   private EchoService echoService;
   private HttpServer server;

   @Override
   public void start() throws Exception {
      echoService = EchoService.getEchoService();

      server = vertx.createHttpServer().requestHandler(req -> {
         req.response().end(echoService.hello());
      }).listen(8082, "localhost");
   }

   @Override
   public void stop() throws Exception {
      server.close();
   }
}
