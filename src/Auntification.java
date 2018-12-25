import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
/*
 * @author Rosogi
 */
public class Auntification {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Модуль для аунтификации с использованием закрытого подключения к 
        // базе данный на основе MySQL.
        //System.out.println(SQLconnect.Useк);
        HelloMSG();
    }

    private static void HelloMSG () throws NoSuchAlgorithmException {
        System.out.println("Hello! Sign In[1] or Sign Up[2]?");
        Scanner SignScann = new Scanner(System.in);
        int SignAnwser = SignScann.nextInt();
        switch (SignAnwser) {
            case 1:
                LoginProcces();
                break;
            case 2:
                RegistrationProcces();
                break;
            default:
                ExeptionHanlde();
                break;
        }
    }
    //Вся жизнь - это метод, а ты в ней переопределен
    public static void ExeptionHanlde (){
        System.out.println("Exception! Try again.");
    }
    //Использовать ли отдельные классы для процесса логина и регистрации?
    //Если файл будет слишком нагруженным я вынесу все это безобразие в отдельные классы
    
    private static void LoginProcces() throws NoSuchAlgorithmException {
        boolean LogIsDone = true;
        System.out.print("Login: ");
        Scanner LoginScann = new Scanner(System.in);
        String Login = LoginScann.next();
        System.out.print("Password: ");
        Scanner PassScann = new Scanner (System.in);
        String Password = (Hash(SaltFP(PassScann.next())));
        //TestUserData.Access(Login, Password);
        if ((TestUserData.Access(Login, Password)) == true) {
            System.out.println("Hello, " + Login);
        }
        else {
            System.out.println("Access not granted");
        }
    }

    private static boolean RegistrationProcces(){
       // System.out.println("Test method registration");
       boolean RegIsDone; 
       System.out.print("Firts Name: ");
        Scanner SFName = new Scanner(System.in);
        String FName = SFName.next();
        System.out.print("Second Name: ");
        Scanner SSName = new Scanner(System.in);
        String SName = SSName.next();
        System.out.print("Birthday: ");
        Scanner SBDay = new Scanner(System.in);
        String BDay = SBDay.next();
        System.out.print("Login: ");
        Scanner SLogin = new Scanner(System.in);
        String Login = SLogin.next();
        String TLFBD = "Exest";
        System.out.print("Password: ");
        Scanner SPassword = new Scanner(System.in);
        String Password = SPassword.next();
        System.out.print("Repeat password: ");
        Scanner SPCheck = new Scanner(System.in);
        String PasswordCheck = SPCheck.next();
        if (!Login.equals(TLFBD)){//Что-то вроде имитации проверки логина в БД
            System.out.println("New login is good!");
            if (PasswordCheck.equals(Password)){
                System.out.println("Password is good!");
                RegIsDone = true;
                return RegIsDone;
                //Проверка данных System.out.println(FName+SName+BDay+Login+Password+PasswordCheck);
            }
            else{ExeptionHanlde();System.out.println("Password doesn't match!");}
        }
        else{ExeptionHanlde();System.out.println("You'r login is already exist!");}
        RegIsDone = false;
        return RegIsDone;
    }
    private static String SaltFP(String Password){
        //Тестовый метод для "соления" паролей для сложности их взлома
        String Salt = "1bFhAzq";
        Password = Salt + Password + Salt;
        //System.out.println("Test method for salting password");
        return Password;
    }
    
    private static String Hash(String Password) throws NoSuchAlgorithmException {
        //Тут будет хешироваться пароль перед отправкой в БД или чтением и сравнением из БД
        //Это все магия и я не знаю как это работает)
        //Но оно работает так что норм
        StringBuffer sb = new StringBuffer();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Password.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
   
}
