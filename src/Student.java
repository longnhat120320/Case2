import java.util.Scanner;

public class Student {

    private String rollNo;
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private float gpa;
    private String email;

    public Student() {
    }

    public Student(String rollNo, String name, String gender, String birthday, String address, float gpa, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.gpa = gpa;
        this.email = email;
    }

    public void inputInfo(){
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập mã sinh viên: ");
        while (true){
            String rollNoInput = input.nextLine();
            boolean check = setRollNo(rollNoInput);
            if(check){
                break;
            }
        }
        System.out.println("Nhập họ và tên: ");
        name = input.nextLine();

        System.out.println("Nhập giới tính: ");
        gender = input.nextLine();

        System.out.println("Nhập ngày sinh: ");
        birthday = input.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = input.nextLine();

        System.out.println("Nhập điểm trung bình của sinh viên");
        while (true){
            float gpsInput = Float.parseFloat(input.nextLine());
            boolean check = setGpa(gpsInput);
            if (check){
                break;
            }
        }

        System.out.println("Nhập email sinh viên: ");
        while (true){
            final String emailInput = input.nextLine();
            boolean check = setEmail(emailInput);
            if (check){
                break;
            }
        }


    }

    public void showInfo(){
        System.out.println("Mã sinh viên: " + rollNo + "; Họ tên: " + name + "; Giới tính: " + gender
                + "; Ngày sinh: " + birthday + "; Địa chỉ: " + address + ";Điểm trung bình: " + gpa + ";Email: " + email);
    }

    // trả về file
    public String getFileLine(){
        return rollNo + " , " + name + " , " + gender + " , " + birthday + " , " + address
                + " , " + gpa + " , " + email + "\n";

    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if(rollNo !=null && rollNo.length() ==4 ){
            this.rollNo = rollNo;
            return true;
        }else {
            System.err.println("Nhập lại mã sinh viên (có 4 ký tự): ");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public boolean setGpa(float gpa) {
        if(gpa >= 0 && gpa <= 10){
            this.gpa = gpa;
            return true;
        }else {
            System.err.println("Nhập lại điểm trung bình ( điểm >=0 hoặc <=10 ): ");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email != null && email.contains("@gmail") && email.contains(".") && !email.contains(" ")){
            this.email = email;
            return true;
        }else {
            System.err.println("Email sai cú pháp vui lòng nhập lại: ");
            return false;
        }
    }

}
