import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationStarter {
    private Scanner input;
    private User auth;
    private List<User> users;
    private int allMessages;

    public ApplicationStarter() {
        input = new Scanner(System.in);
        users = new ArrayList<User>();
    }

    public void run(){
        while (true){
            System.out.print("Введите команду: ");
            String command = input.next();
            if (command.equals("exit")){
                exit();
            }
            else if (command.equals("help")){
                help();
            }
            else if (command.equals("all_users")){
                if (auth==null){
                    System.out.println("Вы не авторизировались в системе");
                    return;
                }
                allUsers();
            }
            else if (command.equals("login")){
                login();
            } else if (command.equals("register")) {
                register();
            }
            else if (command.equals("search_user_by_login")){if (auth==null){
                System.out.println("Вы не авторизировались в системе");
                return;
            }
                searchUserByLogin(input.next());
            }
            else if (command.equals("logout")){
                if (auth==null){
                    System.out.println("Вы не авторизировались в системе");
                    return;
                }
                System.out.println("Выход из авторизации");
                auth=null;
            } else if (command.equals("info")) {
                if (auth==null){
                    System.out.println("Вы не авторизировались в системе");
                    return;
                }
                info();
            } else if (command.equals("read_all_message")) {
                if (auth==null){
                    System.out.println("Вы не авторизировались в системе");
                    return;
                }
                readAllMessage();
            } else if (command.equals("send_message")) {
                if (auth==null){
                    System.out.println("Вы не авторизировались в системе");
                    continue;
                }
                sendMessage();
            } else if (command.equals("mail_info")) {
                if (auth==null){
                    System.out.println("Вы не авторизировались в системе");
                    return;
                }
                mailInfo();
            }else if(command.equals("read_message")){
                if (auth==null){
                    System.out.println("нужно авторизироваться");
                }
                System.out.println(auth.getMessages());
                auth.getMessage().setReadMessage(true);
            }
            else{
                System.out.println("Такой команды нет в системе");
            }
        }
    }
    private void mailInfo(){
        System.out.println("Общее количество сообщений "+allMessages);
        System.out.println("Количество сообщений авторизированного пользователя"+auth.getCountMessage());
    }
    private void sendMessage(){
        System.out.println("Введите логин пользователя которому вы хотите отправить сообщение!");
        String login = input.next();
        for (User user : users){
            if (user.getLogin().equals(login)){
                System.out.println("Введите сообщение пользователю "+user.getLogin());
                String message=nextLine();
                user.getCountMessage();
                user.getMessages().add(message);
                allMessages++;
                return;
            }
        }
        System.out.println("Пользователь с таким логином не найден");
    }
    private String nextLine(){
        String line = "";
        while (true) {
            line = input.nextLine();
            if (!line.isEmpty()) {
                return line;
            }
        }
    }
    private void readAllMessage(){
        if(auth==null){
            System.out.println("Вы не авторизовались в системе");
            return;
        }
        System.out.println("Вывод всех сообщений авторизированного пользователя");
        for (String el: auth.getMessages()){
            System.out.println(el);
        }
    }
    private void exit(){
        System.out.println("Завершение программы");
        System.exit(0);
    }
    private void help(){
        if (auth==null){
            System.out.println("exit - Завершение работы программы.");
            System.out.println("help - Вывод списка всех команд системы.");
            System.out.println("all_users - Вывод всех пользователей в системе.");
            System.out.println("login - Аутентификация пользователя.");
            System.out.println("register - Регистрация пользователя в системе.");
            System.out.println("search_user_by_login - Поиск пользователя по логину");
        }
        else{
            System.out.println("exit - Завершение работы программы.");
            System.out.println("help - Вывод списка всех команд системы.");
            System.out.println("all_users - Вывод всех пользователей в системе.");
            System.out.println("search_user_by_login - Поиск пользователя по логину");
            System.out.println("logout - Выход пользователя из системы");
            System.out.println("read_all_message - Вывод всех сообщений авторизированного пользователя");
            System.out.println("send_message - Отправка сообщение пользователю по его логину.");
            System.out.println("mail_info - Информация о количестве полученных сообщений.");
            System.out.println("info - Вывод информации о авторизированном пользователе");
        }
    }
    private void allUsers(){
        System.out.println("Вывод информации о всех пользователях системы");
        for (User user : users){
            System.out.println(user);
        }
    }
    private void login(){
        System.out.print("Введите логин: ");
        String login=input.next();
        System.out.print("Введите пароль: ");
        String password=input.next();
        for (User user:users){
            if(user.getLogin().equals(login)&&user.getPassword().equals(password)){
                System.out.println(user.getLogin()+" вы успешно зашли в систему");
                this.auth=user;
                return;
            }
        }
        System.out.println("Неверный формат ввода логина или пароля.");
    }
    private void register(){
        User user=new User();
        System.out.print("Введите логин: ");
        user.setLogin(input.next());
        System.out.print("Введите пароль: ");
        user.setPassword(input.next());
        System.out.print("Введите свой номер телефона: ");
        user.setPhone(input.next());
        users.add(user);
    }
    private void info(){
        if (auth==null){
            System.out.println("Вы не авторизовались в системе");
            return;
        }
        System.out.println(auth);
    }
    private void searchUserByLogin(String login){
        for (User user:users){
            if(user.getLogin().equals(login)){
                System.out.println(user);
                return;
            }
        }
        System.out.println("пользователь с таким логином не существует");
    }
}
