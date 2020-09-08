import myExeption.NotValidEmailException;
import myExeption.NotValidNameException;
import myExeption.NotValidPhoneException;

import javax.swing.plaf.TableHeaderUI;
import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new NotValidNameException("Wrong format.\nCorrect format: " + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722");
//            throw new IllegalArgumentException("Wrong format.\nCorrect format: " + "add Василий Петров " +
//                    "vasily.petrov@gmail.com +79215637722");
        }

        String name = components[0] + " " + components[1];

        if (!mailCheck(components[2])) {
            throw new NotValidEmailException("Введен неверно адрес электронной почты");
//            throw new Exception("Введен неверно адрес электронной почты");
        }
        if (!numberPhoneCheck(components[3])) {
            throw new NotValidPhoneException("Номер телефона введен некорректно");
            //throw new Exception("Номер телефона введен некорректно");
        }

        storage.put(name, new Customer(name, components[3], components[2]));
    }

    private boolean mailCheck(String email) {
        boolean answer = false; // буквы_цифери @ буквы . буквы 2-12
        String strCheck = email.replaceAll("[\\[ \\] \\; \\, \\\\/ ]", "");
        if (email.equals(strCheck) && ((email.indexOf("@") == email.lastIndexOf("@")) && (email.indexOf("@") != -1))) {
            String[] arrFromMail = email.split("@");
            if (arrFromMail[0].matches("[\\D \\d]+")) {
                String[] arrFromMail2 = arrFromMail[1].split("\\.");
                if (arrFromMail2[0].matches("[\\D]+") && (arrFromMail2[1].length() <= 12) && (arrFromMail2[1].matches("[\\D]+"))) {
                    answer = true;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }

    private boolean numberPhoneCheck(String number) {
        boolean answer = false;
        String nStr = number.replaceAll("[^0-9\\+]", "");
        if (number.equals(nStr)) {
            if (nStr.indexOf('+') == 0) {
                answer = true;
            } else if (nStr.indexOf('+') == -1) {
                answer = true;
            } else {
                answer = false;
            }
        } else {
            answer = false;
        }
        return answer;
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}