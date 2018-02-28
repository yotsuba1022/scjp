package idv.carl.scjp.io;

import java.io.*;

/**
 * @author Carl Lu
 */
public class Member implements Serializable {

    private String number;
    private String name;
    private int age;

    public Member(String number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public static Member load(String number) throws IOException {
        Member member;
        try (DataInputStream input = new DataInputStream(new FileInputStream(number))) {
            member = new Member(input.readUTF(), input.readUTF(), input.readInt());
        }
        return member;
    }

    public static Member serializeLoad(String number) throws IOException, ClassNotFoundException {
        Member member;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(number))) {
            member = (Member) input.readObject();
        }
        return member;
    }

    public void save() throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(number))) {
            output.writeUTF(number);
            output.writeUTF(name);
            output.writeInt(age);
        }
    }

    public void serializeSave() throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(number))) {
            output.writeObject(this);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" + "number='" + number + '\'' + ", name='" + name + '\'' + ", age=" + age + '}';
    }

}
