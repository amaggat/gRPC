import io.grpc.Server;
import io.grpc.ServerBuilder;
import student.StudentService;

import java.io.IOException;

public class gRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090).addService(new StudentService()).build();
        server.start();

        System.out.println("Server has started");

        server.awaitTermination();
    }

}
