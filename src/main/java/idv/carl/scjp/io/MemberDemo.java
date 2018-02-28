package idv.carl.scjp.io;

import java.io.IOException;

/**
 * @author Carl Lu
 */
public class MemberDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Member[] members = {new Member("A1234", "Ruru", 27), new Member("B1234", "Irene", 25)};

        //saveLoad(members);
        serializeSaveLoad(members);
    }

    private static void saveLoad(Member[] members) throws IOException {
        for (Member member : members) {
            member.save();
        }

        System.out.println(Member.load("A1234"));
        System.out.println(Member.load("B1234"));
    }

    private static void serializeSaveLoad(Member[] members) throws IOException, ClassNotFoundException {
        for (Member member : members) {
            member.serializeSave();
        }

        System.out.println(Member.serializeLoad("A1234"));
        System.out.println(Member.serializeLoad("B1234"));
    }

}
