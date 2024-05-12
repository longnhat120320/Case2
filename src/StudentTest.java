
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StudentTest {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ArrayList<Student> studentsList = new ArrayList<>();
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:

                    int n;
                    System.out.println("Nhập số sinh viên cần thêm");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        Student std = new Student();
                        std.inputInfo();
                        studentsList.add(std);
                    }
                    break;
                case 2:
                    System.out.println("Nhập mã sinh viên cần sửa");
                    String rollNo = sc.nextLine();

                    for (Student student : studentsList){
                        if(student.getRollNo().equals(rollNo)){
                            student.inputInfo();
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập mã sinh viên cần xoá");
                    rollNo = sc.nextLine();

                    for (Student student : studentsList){
                        if(student.getRollNo().equals(rollNo)){
                            studentsList.remove(student);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã sinh viên cần tìm kiếm: ");
                    String rollNoSearch = sc.nextLine();
                    int count =0;
                    for (Student student: studentsList) {
                        if (student.getRollNo().equalsIgnoreCase(rollNoSearch)){
                            student.showInfo();
                            count++;
                        }
                    }
                    if(count==0){
                        System.out.println("Không tìm thấy sinh viên");
                    }
                    break;
                case 5:
                    Collections.sort(studentsList, new Comparator<Student>(){
                        public int compare(Student o1, Student o2){
                            int cmp = o1.getName().compareTo(o2.getName());
                            if(cmp >=0){
                                return 1;
                            }
                            return -1;
                        }
                    });
                    for (int i = 0; i < studentsList.size(); i++) {
                        studentsList.get(i).showInfo();
                    }
                    break;
                case 6:
                    Collections.sort(studentsList, new Comparator<Student>(){
                        public int compare(Student o1, Student o2){
                            return o1.getGpa() >= o2.getGpa()?-1:1;
                        }
                    });
                    for (int i = 0; i < studentsList.size(); i++) {
                        studentsList.get(i).showInfo();
                    }
                    break;
                case 7:
                    for (int i = 0; i < studentsList.size(); i++) {
                        studentsList.get(i).showInfo();
                    }
                    break;
                case 8:
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream("students.txt", true);

                        for (Student student : studentsList) {
                            String line = student.getFileLine();

                            byte[] bytes = line.getBytes();
                            fos.write(bytes);
                        }

                    }catch (FileNotFoundException ex){
                        ex.printStackTrace();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }finally {
                        if (fos != null) {
                            fos.close();
                        }
                    }

                    break;
                case 9:
                    System.out.println("Kết Thúc!!!");
                    break;
                default:
                    System.out.println("Nhập sai!!!");
                    break;
            }
        }while (choose !=9);

    }


    static void showMenu(){
        System.out.println("1.Thêm sinh viên: ");
        System.out.println("2.Sửa sinh viên theo mã sinh viên: ");
        System.out.println("3.Xoá sinh viên theo mã sinh viên: ");
        System.out.println("4.Tìm kiếm sinh viên theo mã sinh viên: ");
        System.out.println("5.Sắp xếp sinh viên theo tên từ A-Z: ");
        System.out.println("6.Sắp xếp sinh viên có điểm trung bình từ cao đến thấp:");
        System.out.println("7.Hiển thị thông tin sinh viên");
        System.out.println("8.Lưu vào file student.txt:");
        System.out.println("9.Thoát");
        System.out.println("Chọn: ");
    }
}
