package iuh.fit;


import java.util.*;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "Khanh", "HCM", 20),
                new Student(2, "Hoa", "HCM", 20),
                new Student(3, "Hieu", "HCM", 25),
                new Student(4, "Hieu", "HCM", 25),
                new Student(5, "Hai", "HCM", 21),
                new Student(6, "Hieu", "HCM", 20));

        //        Trich ds ten khong trung nhau

        List<String> result = students
                .stream()
                .map(x -> x.getName())
                .distinct()
                .toList();
        System.out.println(result);

//        Tìm ds sinh viên có tuổi lớn hơn 20

//        List<Student> result = students
//                .stream()
//                .filter(x -> x.getAge() > 20)
//                .toList();
//
//        result.stream().forEach(System.out::println);

//        List<Student> result = new ArrayList<>();
//
//        for(Student student : students) {
//            if(student.getAge() > 20) {
//                result.add(student);
//            }
//        }
//
//        for (Student student : result) {
//            System.out.println(student);
//        }




//
//        int [] a = {1,4,5,6,8, 1, 2, 2, 1, 5};
////        int count = 0;
////        for (int i = 0; i < a.length; i++) {
////            if(a[i] >= 10)
////                count++;
////        }
//
//        long count = Arrays
//                .stream(a)
//                .filter(x -> x >= 10)
//                .findFirst()
//                .orElse(0);
//
//        System.out.println("Count: " + count);

//        int sum = Arrays.stream(a).sum();
//
//        System.out.println(sum);
    }
}