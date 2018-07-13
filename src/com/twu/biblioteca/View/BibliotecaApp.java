package com.twu.biblioteca.View;

import com.twu.biblioteca.Controller.BibliotecaManager;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome!\nType the number of the option you want:\n\n1. List Books\n2. Quit");

        Scanner reader = new Scanner(System.in);
        int option = reader.nextInt();

        BibliotecaManager bibliotecaManager = new BibliotecaManager(option);

    }
}
