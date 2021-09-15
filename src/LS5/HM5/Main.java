package LS5.HM5;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<Person, List<Pet>> map = new HashMap<>();
        ZooClub zooClub = new ZooClub(map);
        Scanner in = new Scanner(System.in);
        menu();
        int x = 1;
        do {
            switch (in.nextInt()) {
                case 1:
                    System.out.println("Type name:");
                    String name = in.next();
                    if (name.length()>2){
                        map.put(new Person(name), new ArrayList<>());
                        System.out.println("Saved...");
                        TimeUnit.SECONDS.sleep(1);
                        menu();
                        break;
                    }
                    System.out.println("Введіть справжє ім'я");
                    menu();
                    break;
                case 2:
                    System.out.println("Введіть ім'я кому додати тваринку:");
                    String personName = in.next();
                    if(personName!=null && map.get(new Person(personName))!=null){
                        System.out.println("Введіть ім'я тваринки:");
                        String petName = in.next();
                        List<Pet> pet3 = map.get(new Person(personName));
                        pet3.add(new Pet(petName));
                        System.out.println("Saved...");
                        TimeUnit.SECONDS.sleep(1);
                        menu();
                        break;
                    }
                    System.out.println("Немає такого учасника клубу");
                    menu();
                    break;
                case 3:
                    System.out.println("Введіть ім'я в кого видалити:");
                    String personNameDel = in.next();
                    if(personNameDel!=null && map.get(new Person(personNameDel))!= null){
                        System.out.println("Введіть ім'я тваринки для видалення:");
                        String petNameDel = in.next();
                        List<Pet> pet2 = map.get(new Person(personNameDel));
                        pet2.removeIf(pet -> pet.getName().equals(petNameDel));
                        System.out.println("Saved...");
                        TimeUnit.SECONDS.sleep(1);
                        menu();
                        break;
                    }
                    System.out.println("Нема такої персони...");
                    menu();
                    break;
                case 4:
                    System.out.println("Введіть ім'я в кого видалити:");
                    String nameDel = in.next();
                    if (map.get(new Person(nameDel))!= null){
                        map.remove(new Person(nameDel));
                        System.out.println("Saved...");
                        TimeUnit.SECONDS.sleep(1);
                        menu();
                        break;
                    }
                    System.out.println("Нема такої персони...");
                    menu();
                    break;
                case 5:
                    System.out.println("Введіть ім'я тваринки, яку потрібно видалити:");
                    String namePet = in.next();
                    map.forEach((person1, pets4) -> {
                        pets4.removeIf(pet1 -> pet1.getName().equals(namePet));
                    });
                    System.out.println("Saved...");
                    TimeUnit.SECONDS.sleep(1);
                    menu();
                    break;
                case 6:
                    System.out.println(zooClub.getClub());
                    TimeUnit.SECONDS.sleep(2);
                    menu();
                    break;
                case 0:
                    x=0;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (x!=0);

    }
    static public void menu(){
        System.out.println("1) додати учасника в клуб;\n" +
                "2) додати тваринку до учасника клубу.\n" +
                "3) видалити тваринку з власника.\n" +
                "4) видалити учасника клубу.\n" +
                "5) видалити конкретну тваринку з усіх власників.\n" +
                "6) вивести на екран зооклуб.\n"+
                "0) вийти");
    }
}

