/*
 * @ (#) Student.java       25/12/2023
 *
 * Copyright (c) 2023 IUH. All rights reserved.
 */

package iuh.fit;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   25/12/2023
 */
public class Student {
    private long id;
    private String name;
    private String address;
    private int age;

    public Student() {
    }

    public Student(long id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("|%-5d|%-20s|%-20s|%-5d|", id, name, address, age);
    }
}
