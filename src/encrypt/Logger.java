package encrypt;

import java.util.LinkedList;

public class Logger {

    private static LinkedList<String> detailedMessages = new LinkedList<String>();
    private static LinkedList<String> basicMessages = new LinkedList<String>();
    private static int counter = 0;

    public static int count(){
        counter++;
        return counter-1;
    }
    public static void Log(String msg){
        System.out.println(msg);
    }

    public static void Detailed(String msg){
        Logger.detailedMessages.addLast(msg);
    }

    public static void Basic(String msg){
        Logger.basicMessages.addLast(msg);
    }

    public static void DetailedLog(){
        System.out.println("Basic messages: ");
        Logger.basicMessages.stream().forEach(System.out::println);
        System.out.println("Detailed messages: ");
        Logger.detailedMessages.stream().forEach(System.out::println);
    }
    public static void BasicLog(){
        Logger.basicMessages.stream().forEach(System.out::println);
    }


}
