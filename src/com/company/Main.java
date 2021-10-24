package com.company;

import java.util.*;
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
        p.setTotal_point(p.getTotal_point()+1);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached an Empty Floor");
        System.out.println("Total points "+p.getTotal_point());
    }
    public void move(Player p,int n){
        p.setCurrent_level(p.getCurrent_level()+n);
        p.setTotal_point(p.getTotal_point()+1);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached an Empty Floor");
        System.out.println("Total points "+p.getTotal_point());

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
        p.setTotal_point(p.getTotal_point()+2);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a Ladder Floor");
        System.out.println("Total points "+p.getTotal_point());
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
        p.setTotal_point(p.getTotal_point()+4);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a Elevator Floor");
        System.out.println("Total points "+p.getTotal_point());
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
        p.setTotal_point(p.getTotal_point()-2);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a Normal Snake Floor");
        System.out.println("Total points "+p.getTotal_point());
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
        p.setTotal_point(p.getTotal_point()-4);
        System.out.println("Player position Floor - "+p.getCurrent_level());
        System.out.println(p.getName()+" has reached a King Cobra Floor");
        System.out.println("Total points "+p.getTotal_point());
        Empty_Floor floor=new Empty_Floor();
        floor.move(p,-8);
    }
}
public class Main {
    public static void main(String[] args) {
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
        System.out.println("++++++++++++++++++");
        System.out.println("+   FINISH       +");
        System.out.println("+   Level 12     +");
        System.out.println("+   King Cobra   +");
        System.out.println("+   Level 10     +");
        System.out.println("+   Level 9      +");
        System.out.println("+   Ladder       +");
        System.out.println("+   Level 7      +");
        System.out.println("+   Level 6      +");
        System.out.println("+   Snake        +");
        System.out.println("+   Level 4      +");
        System.out.println("+   Level 3      +");
        System.out.println("+   Elevator     +");
        System.out.println("+   Level 1      +");
        System.out.println("+   START        +");
        System.out.println("++++++++++++++++++");
        System.out.println("Enter the player name and hit enter:- ");
        Scanner sc=new Scanner(System.in);
        String t= sc.nextLine();
        Player player=new Player(t);
        int j = 0;
        boolean bool=false;
        System.out.println("The game setup is ready");
        System.out.println("----------------------------------------");
        outerloop:
        while(true){
            System.out.print("Hit enter to roll the dice");
            String enter=sc.nextLine();
            Dice dice_roll=new Dice();
            System.out.println("Dice gave "+dice_roll.getFace_value());
            if(dice_roll.getFace_value()==1){
                Empty_Floor empty_floor1=new Empty_Floor();
                empty_floor1.move(player);
                player.setTotal_point(1);
                System.out.println("----------------------------------------");
                outerloop1:
                while (player.getCurrent_level()<12){
                    System.out.print("Hit enter to roll the dice");
                    String enter1=sc.nextLine();
                    dice_roll.Roll();
                    System.out.println("Dice gave "+dice_roll.getFace_value());
                    j=j+ dice_roll.getFace_value();
                    if(dice_roll.getFace_value()==1){
                        if(arr.get(j).getClass()==Empty_Floor.class){
                            Empty_Floor empty_floor2=(Empty_Floor) arr.get(j);
                            empty_floor2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");

                        }
                        else if(arr.get(j).getClass()==Ladder_Floor.class){
                            Ladder_Floor ladder_floor2=(Ladder_Floor) arr.get(j);
                            ladder_floor2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Elevator.class){
                            Elevator elevator2= (Elevator) arr.get(j);
                            elevator2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Normal_Snake.class){
                            Normal_Snake normal_snake2= (Normal_Snake) arr.get(j);
                            normal_snake2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==King_Cobra.class){
                            King_Cobra king_cobra2 =(King_Cobra) arr.get(j);
                            king_cobra2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                    }
                    else {
                        if(arr.get(j).getClass()==Empty_Floor.class){
                            Empty_Floor empty_floor2=(Empty_Floor) arr.get(j);
                            empty_floor2.move(player, dice_roll.getFace_value());
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Ladder_Floor.class){
                            Ladder_Floor ladder_floor2=(Ladder_Floor) arr.get(j);
                            ladder_floor2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Elevator.class){
                            Elevator elevator2= (Elevator) arr.get(j);
                            elevator2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==Normal_Snake.class){
                            Normal_Snake normal_snake2= (Normal_Snake) arr.get(j);
                            normal_snake2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }
                        else if(arr.get(j).getClass()==King_Cobra.class){
                            King_Cobra king_cobra2 =(King_Cobra) arr.get(j);
                            king_cobra2.move(player);
                            j= player.getCurrent_level();
                            System.out.println("----------------------------------------");
                        }

                    }
                    if(player.getCurrent_level()==12){
                        bool=true;
                        break outerloop1;
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
                        System.out.print("Hit enter to roll the dice");
                        enter=sc.nextLine();
                        dice_roll=new Dice();
                        System.out.println("Dice gave "+dice_roll.getFace_value());
                        if(dice_roll.getFace_value()==1){
                            Empty_Floor empty_floor2=(Empty_Floor) arr.get(j);
                            empty_floor2.move(player);
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
//                else{
//                    while (true){
//
//                    }
//                }
            }
            else {
                System.out.println("Game cannot start until you get 1");
                System.out.println("----------------------------------------");
            }
        }



    }
}