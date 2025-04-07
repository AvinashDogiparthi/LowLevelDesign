package B_DesignPatterns.K_BuilderDesignPattern;

import B_DesignPatterns.K_BuilderDesignPattern.builders.EngineeringStudentBuilder;
import B_DesignPatterns.K_BuilderDesignPattern.builders.MBAStudentBuilder;
import B_DesignPatterns.K_BuilderDesignPattern.builders.Student;

public class Main {
    public static void main(String[] args) {
        Director directorObj1 = new Director(new EngineeringStudentBuilder());
        Director directorObj2 = new Director(new MBAStudentBuilder());

        Student engineerStudent = directorObj1.createStudent();
        Student mbaStudent =directorObj2.createStudent();

        System.out.println(engineerStudent.toString());
        System.out.println(mbaStudent.toString());

    }
}
