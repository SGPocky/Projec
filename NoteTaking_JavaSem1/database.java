

import java.util.*;
import java.io.*;

public class database implements Serializable {

    ArrayList<String> note_title = new ArrayList<>();
    ArrayList<String> note_contents = new ArrayList<>();
    int note_counter = 0;
    int i;

    public void printAllNotes(){
        if (note_counter <= 0){
            System.out.println("you don't work bro");
            return;
        }
        
        System.out.println("Your Notes");
        for (i = 0; i < note_counter; i++){
            System.out.printf("%d. %s\n", i+1, note_title.get(i));
        }
    }

    ArrayList<String> todo_task = new ArrayList<>();
    ArrayList<Integer> month_onTODO = new ArrayList<>();
    ArrayList<Integer> year_onTODO = new ArrayList<>();
    ArrayList<Integer> day_onTODO = new ArrayList<>();

    int todo_counter = 0;

    public void printAllToDo(){
        if (todo_counter <= 0){
            System.out.println("You don't work bro");
            return;
        }

        System.out.println("Your Todo");
        for (i = 0; i < todo_counter; i++){
            System.out.printf("%d. %s\n", i+1, todo_task.get(i));
        }
    }
    
}

    