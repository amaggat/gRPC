/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.grpc.examples.helloworld;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class StudentServer {
  private static final Logger logger = Logger.getLogger(StudentServer.class.getName());

  private Server server;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50051;
    server = ServerBuilder.forPort(port)
        .addService(new StudentProtoImpl())
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
          StudentServer.this.stop();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final StudentServer server = new StudentServer();
    server.start();
    server.blockUntilShutdown();
  }

  static class StudentProtoImpl extends StudentProtoGrpc.StudentProtoImplBase {

    @Override
    public void getStudentInfo(StudentInfoRequest request, StreamObserver<StudentInfoReply> responseObserver) {
        StudentInfoReply reply1 = StudentInfoReply.newBuilder()
                .setName("Nguyen Tien Trong")
                .setDob("08/10/2000")
                .setStudentId(18020056)
                .setGender("Male")
                .setEmail("18020056@vnu.edu.vn")
                .addContacts(StudentInfoReply.Contacts.newBuilder().setName("Nguyen Tien A").setAddress("346 Kim Nguu, Hai Ba Trung, Hanoi").build())
                .addContacts(StudentInfoReply.Contacts.newBuilder().setName("Nguyen Tien B").setAddress("Hiep Hoa, Bac Giang").build())
                .build();
      StudentInfoReply reply2 = StudentInfoReply.newBuilder()
              .setName("Tran Trung Thanh")
              .setDob("18/09/2020")
              .setStudentId(18021174)
              .setGender("Male")
              .setEmail("18021174@vnu.edu.vn")
              .addContacts(StudentInfoReply.Contacts.newBuilder().setName("Tran Van ABC").setAddress("Dong Anh, Ha Noi").build())
              .addContacts(StudentInfoReply.Contacts.newBuilder().setName("Nguyen Thi XYZ").setAddress("Dong Anh, Ha Noi").build())
              .build();
      if ("18020056".equals(request.getMssv())) {
        responseObserver.onNext(reply1);
      } else if ("18021174".equals(request.getMssv())) {
        responseObserver.onNext(reply2);
      }

      responseObserver.onCompleted();
    }
  }
}
