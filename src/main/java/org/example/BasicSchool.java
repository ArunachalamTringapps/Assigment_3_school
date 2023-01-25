package org.example;
import java.util.*;
class BasicSchool {
    private final String name;
    private double credittot;
    private String[] gra;
    private double tot;
    private double gpa;
    static Scanner sc = new Scanner(System.in);

    BasicSchool(String name, Double creditot, String[] gra, double tot, double gpa) {
        this.name = name;
        this.credittot = creditot;
        this.gra = gra;
        this.tot = tot;
        this.gpa = gpa;
    }

    public void update() {
        System.out.println("Enter the subject grade to add:");
        String temp = sc.nextLine();
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(gra));
        myList.add(temp);
        gra = myList.toArray(gra);
        System.out.println("Enter the credit points");
        double credit = sc.nextDouble();
        credittot += credit;
        Grade g = new Grade(temp);
        double gradetemp = g.gradeing();
        tot = tot + (gradetemp * credit);
        gpa = tot / credittot;

    }

    public String display() {
        return "Student Name " + this.name + " has a " + gpa + " GPA";
    }

    public static void main(String[] args) {

        String temp;
        System.out.println("Welcome to RRR School");
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter no of Subjects:");
        int n = sc.nextInt();
        String[] gra = new String[n];
        double credit;
        double tot = 0.00;
        double credittot = 0.00;
        sc.nextLine();
        for (int i = 0; i < n; i++) {

            System.out.println("Enter the Subject grade in Capital letter:");
            temp = sc.nextLine();
            System.out.println("Enter the credit points");
            credit = sc.nextDouble();
            sc.nextLine();
            credittot += credit;
            gra[i] = temp;
            Grade g = new Grade(temp);
            double gradetemp = g.gradeing();
            tot = tot + (gradetemp * credit);

        }


        double gpa = tot / credittot;
        BasicSchool sh = new BasicSchool(name, credittot, gra, tot, gpa);

        int ch;
        do {
            System.out.println("1.update your GPA\n2.display your GPA\n3.exit");
            System.out.println("Enter the choice ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> sh.update();
                case 2 -> {
                    String dis = sh.display();
                    System.out.println(dis);
                }
                default -> System.out.println("Enter the correct choice:");
            }
        } while (ch != 3);

    }
}

class Grade {
    private final String temp;

    Grade(String temp) {
        this.temp = temp;
    }

    public double gradeing() {
        double gradetemp = 0;
        switch (temp) {
            case "A" -> gradetemp = 4;
            case "B" -> gradetemp = 3;
            case "C" -> gradetemp = 2;
            case "D" -> gradetemp = 1;
            case "F" -> gradetemp = 0;
            default -> System.out.println("Enter the correct Grade");
        }

        return gradetemp;

    }
}