import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //ArrayBag<Building> ar=new ArrayBag<>();
        LinkedBag<Building> ar=new LinkedBag<>();
        //ArrayList<Building> ar=new ArrayList<>();
        //LinkedList<Building> ar=new LinkedList<>();
        File file=new File("src/main/java/buildings.txt");
        Scanner sc=new Scanner(file);

        while(sc.hasNext()){
            String line=sc.nextLine();
            String[] tokens=line.split("\\|");
            String type = tokens[0];
            String owner = tokens[1];
            String address = tokens[2];

            switch (type) {
                case "H":
                    int rooms = Integer.parseInt(tokens[3]);
                    boolean hasGarage = Boolean.parseBoolean(tokens[4]);
                    House h1=new House(owner, address, rooms, hasGarage);
                    ar.add(h1);
                    break;
                case "S":
                    int employees = Integer.parseInt(tokens[3]);
                    double turnover = Double.parseDouble(tokens[4]);
                    Shop s1=new Shop(owner, address, employees, turnover);
                    ar.add(s1);
                    break;
                case "B":
                default:
                    Building b1=new Building(owner, address);
                    ar.add(b1);
                    break;
            }
        }
        sc.close();
        for(int i=0;i<ar.size();i++){
            System.out.print("Building:"+i+"\n");
            System.out.println(ar.get(i));
        }
    }
}
