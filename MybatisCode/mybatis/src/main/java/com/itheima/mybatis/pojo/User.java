package com.itheima.mybatis.pojo;
import lombok.*;



//@Getter        )
//@Setter            )   ==   @Data
//@ToString     )
//@EqualsAndHashCode

@Data
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //全参构造
public class User {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;

//    public User() {}
//
//    public User(String name, int age, String gender, String phoneNumber, int id) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.phoneNumber = phoneNumber;
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", gender='" + gender + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", id=" + id +
//                '}';
//    }
}