package student;

import com.example.grpc.Student;
import com.example.grpc.studentGrpc;
import io.grpc.stub.StreamObserver;

public class StudentService extends studentGrpc.studentImplBase {

    @Override
    public void searchByID(Student.StudentId request, StreamObserver<Student.StudentInfo> responseObserver) {

        System.out.println("Hello");

        String studentId = request.getId();
        Student.StudentInfo.Builder response = Student.StudentInfo.newBuilder();

        System.out.println("The studentID is " + studentId);

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
