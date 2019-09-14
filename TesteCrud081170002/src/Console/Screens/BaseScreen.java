package Console.Screens;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseScreen {

    public String backMessage = "Sair";
    public static boolean Exit = false;
    public  boolean Run() throws IOException {

        ClearConsole();
        WriteOptions();
        int x = ReadOptions();
        NextScreenChoose(x);
        return  Exit;
    }

    public void WriteOptions(){
        System.out.println("Indique a opção desejada!");
        System.out.println("0 - "+backMessage);
    }

    public int ReadOptions(){
        Scanner scan = new Scanner(System.in);
        try {
            var x = scan.nextInt();
            return x;
        }catch (InputMismatchException ex){
            return -1;
        }

    }

    public  void ClearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public abstract void NextScreenChoose(int x);

}
