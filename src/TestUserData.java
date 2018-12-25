import java.lang.reflect.Array;
import java.util.Arrays;

public class TestUserData {
    public static void main(String args[]) {
    }

    //public static String AllNames= "";

    public static boolean Access(String Login, String Password) {
        //GetLogin(Login,Password,);
        return Array(Login, Password);
    }

    private static boolean Array(String ALogin, String APassword) {
        String[] Logins = {"Bylly", "Bara", "Rosogi", "Sergo"};
        String[] Passwords = {"ba04fadec3d42962dd4335843fc7e3432d13759b211c96cf6a7f8ab243280336",
                "32da12b7e29224e8154a1406bf3f05d16586a129475522235810f6d080d14632",
                "6402a49fbe89f471d9c3c3443f92668d6a32fdec27814f6decca131fa4de04c8",
                "3737a2245bc30d3b06ea320cd9bf240c162be267a056ba5625a5497545ef1ef4"};
        //123123123 | 84963365158 | abczxcqwe123321 | 1111zyh369abz
        return GetLogin(ALogin, APassword, Logins, Passwords);

    }

    private static boolean GetLogin(String Login, String Password, String[] Logins, String[] Passwords) {
        boolean CompleateAuntification = false;
        if (Arrays.asList(Logins).contains(Login)) {
            //System.out.println("Login is good");
            int IndexOfUserLogin = Arrays.asList(Logins).indexOf(Login);
            //System.out.println("Index in Logins Array that's contains " + Login + " : " + IndexOfUserLogin);
            if (Passwords[IndexOfUserLogin].contentEquals(Password)) {
                return CompleateAuntification = true;
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("Such login does not exist!");//Auntification.ExeptionHanlde();}
            return CompleateAuntification;
        }


        return CompleateAuntification;
    }
}