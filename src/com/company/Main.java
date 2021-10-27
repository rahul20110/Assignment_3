package com.company;

import java.util.*;
import java.io.*;
class Dice{
    private int face_value;
    private Random ran=new Random();;
    public Dice(){
        Roll();
    }
    public void Roll(){
        this.face_value=(ran.nextInt(2)+1);
    }
    public int getFace_value() {
        return face_value;
    }
}
class Player{
    private String name;
    private int total_points=0;
    private int Current_level=-1;
    public Player(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getTotal_point() {
        return total_points;
    }
    public void setTotal_point(int total_point) {
        this.total_points = total_point;
    }
    public int getCurrent_level() {
        return Current_level;
    }
    public void setCurrent_level(int current_level) {
        Current_level = current_level;
    }
}
class Empty_Floor{
    protected int point_added_or_deducted;
    public Empty_Floor(){}
    public Empty_Floor(int point){
        this.point_added_or_deducted=point;
    }
    public int getPoint_added_or_deducted() {
        return point_added_or_deducted;
    }
    public void move(Player p){
        p.setCurrent_level(p.getCurrent_level()+1);
        p.setTotal_point(p.getTotal_point()+this.point_added_or_deducted);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached an Empty Floor");
        System.out.println("Total points "+p.getTotal_point());
        display.function(p);
    }
    public void move(Player p,int n){
        p.setCurrent_level(p.getCurrent_level()+n);
        p.setTotal_point(p.getTotal_point()+1);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached an Empty Floor");
        System.out.println("Total points "+p.getTotal_point());
        display.function(p);

    }
}
class Ladder_Floor extends Empty_Floor{
    public Ladder_Floor(){}
    public Ladder_Floor(int point){
        this.point_added_or_deducted=point;
    }

    @Override
    public void move(Player p) {
        p.setCurrent_level(8);
        p.setTotal_point(p.getTotal_point()+this.point_added_or_deducted);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a Ladder Floor");
        System.out.println("Total points "+p.getTotal_point());
        display.function(p);
        Empty_Floor floor=new Empty_Floor();
        floor.move(p,4);
    }
}
class Elevator extends Empty_Floor{
    public Elevator(){}
    public Elevator(int point){
        this.point_added_or_deducted=point;
    }

    @Override
    public void move(Player p) {
        p.setCurrent_level(2);
        p.setTotal_point(p.getTotal_point()+this.point_added_or_deducted);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a Elevator Floor");
        System.out.println("Total points "+p.getTotal_point());
        display.function(p);
        Empty_Floor floor=new Empty_Floor();
        floor.move(p,8);

    }
}
class Normal_Snake extends Empty_Floor{
    public Normal_Snake(){}
    public Normal_Snake(int point){
        this.point_added_or_deducted=point;
    }
    @Override
    public void move(Player p){
        p.setCurrent_level(5);
        p.setTotal_point(p.getTotal_point()+this.point_added_or_deducted);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a Normal Snake Floor");
        System.out.println("Total points "+p.getTotal_point());
        display.function(p);
        Empty_Floor floor=new Empty_Floor();
        floor.move(p,-4);
    }
}
class King_Cobra extends Normal_Snake{
    public King_Cobra(){}
    public King_Cobra(int point){
        this.point_added_or_deducted=point;
    }
    @Override
    public void move(Player p) {
        p.setCurrent_level(11);
        p.setTotal_point(p.getTotal_point()+this.point_added_or_deducted);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a King Cobra Floor");
        System.out.println("Total points "+p.getTotal_point());
        display.function(p);
        Empty_Floor floor=new Empty_Floor();
        floor.move(p,-8);
    }
}
class display{

    public static void function(Player p){
            if(p.getCurrent_level()==0){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START       <<---- Your Position   +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");

            }
            else if(p.getCurrent_level()==1){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1     <<---- Your Position   +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==2){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator    <<---- Your Position   + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==3){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3     <<---- Your Position   +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==4){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4     <<---- Your Position   +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==5){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake       <<---- Your Position   +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==6){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6     <<---- Your Position   +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==7){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7     <<---- Your Position   +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==8){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder      <<---- Your Position   + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==9){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9     <<---- Your Position   +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==10){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10    <<---- Your Position   +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==11){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra  <<---- Your Position   +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==12){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH                             +"
                +"\n            +       Level 12    <<---- Your Position   +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
            else if(p.getCurrent_level()==13){
                System.out.println("            ++++++++++++++++++++++++++++++++++++++++++++"
                +"\n            +       FINISH      <<---- Your Position   +"
                +"\n            +       Level 12                           +<<╸╸╸╸╸╸╸╻"
                +"\n    ╻╸╸╸╸╸╸ +       King Cobra                         +         ┃"
                +"\n    ┃       +       Level 10                           +<<╸╸╸╻   ┃"
                +"\n    ┃       +       Level 9                            +     ┃   ┃"
                +"\n    ┃       +       Ladder                             + ╸╸╸╸┃╸╸╸╹ "
                +"\n    ┃       +       Level 7                            +     ┃"
                +"\n    ┃       +       Level 6                            +     ┃"
                +"\n    ┃ ╻╸╸╸╸╸+       Snake                              +     ┃"
                +"\n    ┃ ┃     +       Level 4                            +     ┃"
                +"\n    ╹╸┃╸╸>> +       Level 3                            +     ┃"
                +"\n      ┃     +       Elevator                           + ╸╸╸╸╹"
                +"\n      ╹╸╸>> +       Level 1                            +"
                +"\n            +       START                              +"
                +"\n            ++++++++++++++++++++++++++++++++++++++++++++");
            }
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        final ArrayList<Object> arr=new ArrayList<>();
        Empty_Floor empty_floor=new Empty_Floor(1);
        Ladder_Floor ladder_floor=new Ladder_Floor(2);
        Elevator elevator=new Elevator(4);
        Normal_Snake normal_snake=new Normal_Snake(-2);
        King_Cobra king_cobra=new King_Cobra(-4);
        arr.add(empty_floor);
        arr.add(empty_floor);
        arr.add(elevator);
        arr.add(empty_floor);
        arr.add(empty_floor);
        arr.add(normal_snake);
        arr.add(empty_floor);
        arr.add(empty_floor);
        arr.add(ladder_floor);
        arr.add(empty_floor);
        arr.add(empty_floor);
        arr.add(king_cobra);
        arr.add(empty_floor);
        arr.add(empty_floor);
        System.out.println("Enter the player name and hit enter:- ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String t= reader.readLine();
        Player player=new Player(t);
        int j = 0;
        boolean bool=false;
        System.out.println("The game setup is ready");
        System.out.println("----------------------------------------");
        outerloop:
        while(true){
            System.out.print("Hit enter to roll the dice\n");
            reader.readLine();
            Dice dice_roll=new Dice();
            System.out.println("Dice gave "+dice_roll.getFace_value());
            if(dice_roll.getFace_value()==1){
                empty_floor.move(player);
                System.out.println("----------------------------------------");
                outerloop1:
                while (player.getCurrent_level()<12){
                    System.out.print("Hit enter to roll the dice\n");
                    reader.readLine();
                    dice_roll.Roll();
                    System.out.println("Dice gave "+dice_roll.getFace_value());
                    j=j+ dice_roll.getFace_value();
                    if(dice_roll.getFace_value()==1){
                        if(arr.get(j).getClass()==Empty_Floor.class){
                            empty_floor.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");

                        }
                        else if(arr.get(j).getClass()==Ladder_Floor.class){
                            ladder_floor.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Elevator.class){
                            elevator.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Normal_Snake.class){
                            normal_snake.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");

                        }
                        else if(arr.get(j).getClass()==King_Cobra.class){
                            king_cobra.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                    }
                    else {
                        if(arr.get(j).getClass()==Empty_Floor.class){
                            empty_floor.move(player, dice_roll.getFace_value());
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Ladder_Floor.class){
                            ladder_floor.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Elevator.class){
                            elevator.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Normal_Snake.class){
                            normal_snake.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==King_Cobra.class){
                            king_cobra.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }

                    }
                    if(player.getCurrent_level()==12){
                        bool=true;
                        break;
                    }
                    if(player.getCurrent_level()==13){
                        System.out.println("Game over");
                        System.out.println(player.getName()+" accumulated "+player.getTotal_point()+" points");
                        System.out.println("----------------------------------------");
                        break outerloop;
                    }
                }
                if(bool==true){
                    while(true){
                        System.out.print("Hit enter to roll the dice\n");
                        reader.readLine();
                        dice_roll=new Dice();
                        System.out.println("Dice gave "+dice_roll.getFace_value());
                        if(dice_roll.getFace_value()==1){
                            empty_floor.move(player);
                            System.out.println("Game over");
                            System.out.println(player.getName()+" accumulated "+player.getTotal_point()+" points");
                            System.out.println("----------------------------------------");
                            break outerloop;
                        }
                        else{
                            System.out.println("Player cannot move");
                        }
                    }
                }
            }
            else {
                System.out.println("Game cannot start until you get 1");
                System.out.println("----------------------------------------");
            }
        }
    }
}