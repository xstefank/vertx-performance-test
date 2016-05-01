package io.silverware.performance.vertx.verticle;

import io.silverware.performance.vertx.EchoService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

/**
 * @author <a href="mailto:stefankomartin6@gmail.com">Martin Štefanko</a>
 */
public class HttpVerticle extends AbstractVerticle {

   private HttpServer server;

   @Override
   public void start() throws Exception {
      server = vertx.createHttpServer().requestHandler(req -> {
         req.response().end(EchoService.hello());
      }).listen(8082, "localhost");
   }

   @Override
   public void stop() throws Exception {
      server.close();
   }
}
