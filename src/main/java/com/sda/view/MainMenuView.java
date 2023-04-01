package com.sda.view;

public class MainMenuView implements View {

    @Override
    public void display() {
        System.out.println("Main Menu");
    }

    Integer getData(){
        System.out.println();
        System.out.println("podaj cyfre");
        Integer option = scanner.nextInt();
        return option;
    }

}
