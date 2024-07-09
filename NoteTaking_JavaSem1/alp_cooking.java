
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class alp_cooking {

    public static Integer error_handlingINT(String title, int the_num) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(title);
            if (sc.hasNextInt()) {
                the_num = sc.nextInt();
                return the_num;
            } else {
                System.out.println("wrong, try again");
               sc.next();
            }
        }
    }

    // This thing just prints the indicators for the calendar
    public static void CalendarColorIndicator(String Month_names[], int month_input, int year_input,
            boolean greenCondition) {

        if (greenCondition == false) {
            System.out.println("\u001B[33m■ \u001B[00m: Current Day");
            System.out.println("\u001B[35m■ \u001B[00m: Current Day and Task due\n" + // purple
                    "\u001B[34m■ \u001B[00m: You have a Task due");
            System.out.println("\u001B[31m■ \u001B[00m: You have a Task Overdue");
        } else {
            System.out.println("\u001B[32m■ \u001B[00m: Your task Date");
        }
        // Prints the day, month, and year
        System.out.println("\n\t" + Month_names[month_input - 1] + " " + year_input
                + "\n --------------------------");
        System.out.printf(" Su  Mo  Tu  We  Th  Fr  Sa\n");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("database.ser");
        if (!(file.exists())) {
            System.out.println("your database is broken lmao, please link the right serializer");
            System.exit(0);
        }

        Scanner sc = new Scanner(System.in);
        Calendar cal = new GregorianCalendar();

        // database readed_data = new database(); // access the database file

        // FileInputStream file_read = new FileInputStream(
        // "database.ser");
        // ObjectInputStream obj_read = new ObjectInputStream(file_read);
        // database readed_data = (database) obj_read.readObject();
        // file_read.close();
        // obj_read.close();

        // Menu List
        String menu, note_menu, to_do_Menu;

        int search_function = 0;
        int delete_function = 0;
        String confirmation_bias = "";
        Boolean Duplicate_r_Not = false;
        boolean exit = false;
        // int month_inputter[] = new int[100];
        boolean green = false;
        int todo_remover = 0;

        int j = -1;

        // Calendar Setup
        int month_Yes = 1;
        LocalDate date = LocalDate.of(2023, month_Yes, 1);
        YearMonth yearMonth = YearMonth.from(date);
        int lengthOfMonth = yearMonth.lengthOfMonth();
        int firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek().getValue();
        String Month_names[] = { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        int day = 1;
        int the_today = LocalDate.now().getDayOfMonth();
        int store_c = 0;
        boolean dueNtoday_same = false;

        int coun = 0;

        String exit_from_titleORsearch = "";


        // Calendar Vars Needed
        int calendar[][] = new int[8][7];
        int month_input_calendar = 0;
        int year_input_calendar = 0;

        int day_placeholder = 0;

        int temp_dayStorer[] = new int[100];
        int temp2_dayStorer[] = new int[100];

        int temp_YearStorer[] = new int[100];
        int temp2_YearStorer[] = new int[100];

        String temp_todo_task[] = new String[100];
        String temp2_todo_task[] = new String[100];

        String temp3_task[] = new String[100];
        int temp3_day[] = new int[100];
        int temp3_year[] = new int[100];

        // String temp4_task[] = new String[100];
        // int temp4_day[] = new int[100];

        // int day_temp[] = new int[100];
        // String tempTask[] = new String[100];

        int day_red[] = new int[100];
        int day_blue[] = new int[100];
        int day_purple[] = new int[100];

        int temp_storer = 0;
        for (int i = 0; i < 100; i++) {
            temp2_YearStorer[i] = 9999;
            temp2_dayStorer[i] = 9999;
        }

        int this_year = 0;
        int moona = 0;

        while (true) {
            FileInputStream file_read = new FileInputStream(
                    "database.ser");
            ObjectInputStream obj_read = new ObjectInputStream(file_read);
            database readed_data = (database) obj_read.readObject();
            file_read.close();
            obj_read.close();
            exit = false;
            green = false;
            System.out.print("==Welcome to FUNCOM==\n" +
                    "1. Note taking\n" +
                    "2. To do list\n" +
                    "3. Calendar\n" +
                    "6. Exit\n\n" +
                    "Your input: ");
            menu = sc.next().toLowerCase() + sc.nextLine().toLowerCase();
            if (menu.equalsIgnoreCase("exit") || menu.equalsIgnoreCase("6")) {
                System.exit(0);
            } // its out of the Switch Case to prevent it from randomly Triggering
            switch (menu) {
                // if 1
                case "1":
                case "note taking":
                    System.out.print("==Note Section==\n" +
                            "1. Create new note\n" +
                            "2. Delete Note\n" +
                            "3. Search\n" +
                            "4. Exit\n\n" +
                            "Your input: \n");
                    note_menu = sc.next().toLowerCase() + sc.nextLine().toLowerCase();

                    switch (note_menu) {
                        // case "new file":
                        // FileOutputStream file_save1 = new FileOutputStream(
                        // "database.ser");
                        // ObjectOutputStream obj_save1 = new ObjectOutputStream(file_save1);
                        // for (int i = 0; i < readed_data.note_counter; i++) {
                        // readed_data.note_title.remove(0);
                        // readed_data.note_contents.remove(0);
                        // }
                        // for (int i = 0; i < readed_data.todo_counter; i++) {
                        // readed_data.day_onTODO.remove(0);
                        // readed_data.month_onTODO.remove(0);
                        // readed_data.year_onTODO.remove(0);
                        // readed_data.todo_task.remove(0);
                        // }
                        // readed_data.todo_counter = 0;
                        // readed_data.note_counter = 0;
                        // obj_save1.writeObject(readed_data);
                        // file_save1.close();
                        // obj_save1.close();
                        // System.out.println("All TODO Deleted");
                        // // System.exit(0);

                        // break;

                        case "1":
                        case "create new note":
                            Duplicate_r_Not = false;
                            if (readed_data.note_counter == 0) {
                                System.out.println("==What is the title of your note==");
                                readed_data.note_title.add(sc.next() + sc.nextLine());

                                System.out.println("==Type what you want to type below==");
                                readed_data.note_contents.add(sc.next() + sc.nextLine());
                                System.out.println("Your note has been saved\n");
                                readed_data.note_counter++;
                                FileOutputStream file_save = new FileOutputStream(
                                        "database.ser");
                                ObjectOutputStream obj_save = new ObjectOutputStream(file_save);
                                obj_save.writeObject(readed_data);
                                file_save.close();
                                obj_save.close();
                            } else {
                                while (true) {
                                    System.out.println("==What is the title of your note==");
                                    readed_data.note_title.add(sc.next() + sc.nextLine());
                                    // readed_data.note_counter++;
                                    for (int i = 0; i < readed_data.note_counter; i++) {
                                        for (j = 0; j < readed_data.note_counter; j++) {
                                            if (readed_data.note_title.get(j)
                                                    .equalsIgnoreCase(
                                                            readed_data.note_title.get(readed_data.note_counter - i))
                                                    && j != readed_data.note_counter - i) {
                                                // coun = 999;
                                                Duplicate_r_Not = true;
                                                System.out.println("     \u001B[31m--You had a duplicate--\t\u001B[0m");
                                                readed_data.note_title.remove(readed_data.note_title.size() - 1);
                                                readed_data.note_contents.remove(readed_data.note_contents.size() - 1);
                                                // readed_data.note_counter--;
                                                break;
                                            }
                                        }
                                        if (Duplicate_r_Not == true) {
                                            break;
                                        }
                                    }

                                    if (Duplicate_r_Not == false) {
                                        // True stellar stellar
                                        System.out.println("==Type what you want to type below==");
                                        readed_data.note_contents.add(sc.next() + sc.nextLine());
                                        System.out.println("your note has been saved");
                                        readed_data.note_counter++;

                                        FileOutputStream file_save = new FileOutputStream(
                                                "database.ser");
                                        ObjectOutputStream obj_save = new ObjectOutputStream(file_save);
                                        obj_save.writeObject(readed_data);
                                        file_save.close();
                                        obj_save.close();
                                        break;
                                    } else {
                                        Duplicate_r_Not = false;
                                        break;
                                    }
                                }
                                break;
                            }
                            break;

                        case "3":
                        case "Search":
                            FileInputStream baca_file = new FileInputStream(
                                    "database.ser");
                            ObjectInputStream baca_obj = new ObjectInputStream(baca_file);
                            readed_data = (database) baca_obj.readObject();
                            baca_file.close();
                            baca_obj.close();
                            if (readed_data.note_counter <= 0) {
                                System.out.println("no notes shoo");
                                break;
                            }

                            readed_data.printAllNotes();

                            search_function = -1;
                            while (true) {
                                search_function = error_handlingINT(
                                        "Now Which do you want to search(By number)\n0 for exit\n Your input: ",
                                        search_function);
                                if (search_function > readed_data.note_counter) {
                                    System.out.println("too much");
                                } else if (search_function < 0) {
                                    System.out.println("too little");
                                } else if (search_function == 0) {
                                    System.out.println("you Exitted");
                                    break;
                                } else {
                                    break;
                                }
                            }
                            if (search_function == 0) {
                                break;
                            }
                            search_function--;

                            System.out.printf("\nThe contents of the note\n" +
                                    "===%s===\n" +
                                    "%s\n\n", readed_data.note_title.get(search_function),
                                    readed_data.note_contents.get(search_function));
                            search_function = -1;
                            break;

                        case "2":
                        case "delete note":
                            if (readed_data.note_counter <= 0) {
                                System.out.println("you dont have any notes, shoo shoo");
                                break;
                            }
                            readed_data.printAllNotes();
                            delete_function = -1;
                            while (true) {
                                delete_function = error_handlingINT(
                                        "Now Which do you want to search(By number)\n" +
                                                "0 for exit\n",
                                        delete_function);
                                if (delete_function == 0) {
                                    break;
                                }
                                if (delete_function > readed_data.note_counter) {
                                    System.out.println("TOO MUCH");
                                } else if (delete_function < 0) {
                                    System.out.println("Too little");
                                } else {
                                    break;
                                }
                            }
                            if (delete_function == 0) {
                                break;
                            }
                            delete_function--;
                            System.out.printf("Are you sure you would like to delete this?(Y/N)\n" +
                                    "===%s===\n" +
                                    "%s\n", readed_data.note_title.get(delete_function),
                                    readed_data.note_contents.get(delete_function));
                            confirmation_bias = sc.next() + sc.nextLine();

                            if (confirmation_bias.equalsIgnoreCase("Y")) {
                                readed_data.note_title.remove(delete_function);
                                readed_data.note_contents.remove(delete_function);
                                System.out.println("\u001B[41mDelete Succesful\u001B[0m");
                                readed_data.note_counter--;
                                FileOutputStream file_save = new FileOutputStream(
                                        "database.ser");
                                ObjectOutputStream obj_save = new ObjectOutputStream(file_save);
                                obj_save.writeObject(readed_data);
                                file_save.close();
                                obj_save.close();
                                break;
                            } else {
                                System.out.println("Delete Aborted");
                                break;
                            }

                    }
                    break;

                case "2":
                case "to do list":
                    System.out.println("==Welcome to do List==\n" +
                            "1. Add TO-DO\n" +
                            "2. Remove TO-DO\n" +
                            "3. Show TO-DO\n" +
                            "4. Exit\n\n" +
                            "Your Input:");
                    to_do_Menu = sc.next().toLowerCase() + sc.nextLine().toLowerCase();
                    if (exit == true) {
                        break;
                    }

                    switch (to_do_Menu) {
                        case "1":
                        case "add to-do":
                        case "add todo":
                        case "add to do":
                            coun = 0;
                            System.out.println("==Add TO-DO list==");

                            if (readed_data.todo_counter == 0) {
                                System.out.println("==What is on your TO-DO list?==");
                                readed_data.todo_task.add(sc.next() + sc.nextLine());
                                System.out.println("your todo has been saved");
                            } else {
                                System.out.println("==What is on your TO-DO list?==");
                                readed_data.todo_task.add(sc.next() + sc.nextLine());
                                for (int i = 0; i < readed_data.todo_counter; i++) {
                                    for (j = 0; j < readed_data.todo_counter; j++) {
                                        if (readed_data.todo_task.get(j)
                                                .equalsIgnoreCase(
                                                        readed_data.todo_task.get(readed_data.todo_counter - i))
                                                && j != readed_data.todo_counter - i) {
                                            coun = 999;
                                            i = 999;
                                            System.out.println("\u001B[31m--You had a duplicate--\t\u001B[0m");
                                            readed_data.todo_task.remove(readed_data.todo_counter);
                                            break;
                                        }
                                    }
                                }
                                if (coun == 999) {
                                    break;
                                }
                                coun = 0;
                            }
                            int placeholder = 0;
                            int month_placeholder = 0;
                            while (!(placeholder <= 12 && placeholder > 0)) {
                                placeholder = error_handlingINT("Month of the Task Due: ", placeholder);
                            }
                            month_placeholder = placeholder;
                            readed_data.month_onTODO.add(placeholder);

                            placeholder = 0;
                            int year_placeholder = 0;
                            while (!(placeholder <= 3000 && placeholder > 1970)) {
                                placeholder = error_handlingINT("Year of the Task Due: ", placeholder);
                            }

                            year_placeholder = placeholder;
                            readed_data.year_onTODO.add(placeholder);
                            placeholder = 0;

                            date = LocalDate.of(year_placeholder, month_placeholder, 1);
                            the_today = LocalDate.now().getDayOfMonth();

                            day = 1;
                            yearMonth = YearMonth.from(date);
                            firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek().getValue();
                            lengthOfMonth = yearMonth.lengthOfMonth();
                            this_year = cal.get(Calendar.YEAR);
                            moona = cal.get(Calendar.MONTH); // checking the current month in INT
                            moona++; // to make it 1-12 not 0-11

                            while (!(placeholder <= lengthOfMonth && placeholder >= 1)) {
                                placeholder = error_handlingINT("Date of the Task Due: ", placeholder);
                            }

                            day_placeholder = placeholder;
                            readed_data.day_onTODO.add(placeholder);
                            placeholder = 0;

                            green = true;
                            CalendarColorIndicator(Month_names, month_placeholder, year_placeholder, green);
                            green = false;

                            for (int i = 0; i < 6; i++) { // 6
                                for (j = 0; j < 7; j++) { // x 7
                                    if (i == 0 && j < firstDayOfMonth) { // If awalnya or the j is less than the
                                                                         // firstdaymonth spacing then it is 0
                                        calendar[i][j] = 0; // there is now 0
                                    } else if (day <= lengthOfMonth) { // if passes the above it check the day from
                                                                       // the
                                                                       // month amount, and +1 each
                                        calendar[i][j] = day++;
                                    } else { // if not all of those like the end of the months it just kosongin
                                        calendar[i][j] = 0;
                                    }

                                    if ((i == 0 && j < firstDayOfMonth)) { // this again
                                        System.out.print("    ");
                                    } else if (day_placeholder == calendar[i][j]) {
                                        System.out.printf("\u001B[32m%3d \u001B[00m", calendar[i][j]);
                                    } else if (calendar[i][j] != 0) {
                                        System.out.printf("%3d ", calendar[i][j]);
                                    } else { // ya if not all of those it just print like 0 but ilang
                                        System.out.print(" ");
                                    }
                                    if (j == 6) { // if sudah 1 minggu it go down
                                        System.out.println();
                                    }
                                }
                            }

                            System.out.println("");
                            readed_data.todo_counter++;
                            FileOutputStream file_save = new FileOutputStream(
                                    "database.ser");
                            ObjectOutputStream obj_save = new ObjectOutputStream(file_save);
                            obj_save.writeObject(readed_data);
                            file_save.close();
                            obj_save.close();

                            break;

                        // break;

                        case "2":
                        case "remove todo":
                            if (exit_from_titleORsearch.equalsIgnoreCase("Y")) {
                                break; // i think ini so that it breaks something
                            } else if (readed_data.todo_counter <= 0) {
                                System.out.println("there are no todo for now");
                            }

                            readed_data.printAllToDo();

                            while (true) {
                                todo_remover = error_handlingINT(
                                        "Now Which do you want to search(By number)\n" +
                                                "write 0 for exit\n",
                                        todo_remover);
                                if (todo_remover > readed_data.todo_counter) {
                                    System.out.println("too much");
                                } else if (todo_remover < 0) {
                                    System.out.println("too little");
                                } else if (todo_remover == 0) {
                                    System.out.println("you exitted");
                                    break;
                                } else {
                                    break;
                                }
                            }
                            if (todo_remover == 0) {
                                break;
                            }
                            todo_remover--; // so that it start at 0
                            System.out.printf("Are you sure you would like to delete this?(Y/N)\n" +
                                    "%s\n", readed_data.todo_task.get(todo_remover));
                            confirmation_bias = sc.next() + sc.nextLine();

                            if (confirmation_bias.equalsIgnoreCase("Y")) {
                                readed_data.todo_task.remove(todo_remover);
                                readed_data.month_onTODO.remove(todo_remover);
                                readed_data.year_onTODO.remove(todo_remover);
                                readed_data.day_onTODO.remove(todo_remover);
                                System.out.println("\u001B[41mDelete Succesful\u001B[0m");

                                readed_data.todo_counter--;

                                FileOutputStream file_save1 = new FileOutputStream(
                                        "database.ser");
                                ObjectOutputStream obj_save1 = new ObjectOutputStream(file_save1);
                                obj_save1.writeObject(readed_data);
                                file_save1.close();
                                obj_save1.close();
                                break;
                            } else {
                                System.out.println("Delete Aborted");
                                break;
                            }

                        case "3":
                        case "show to-do":
                        case "show todo":
                            if (exit_from_titleORsearch.equalsIgnoreCase("Y")) {
                                break; // i think ini so that it breaks something
                            } else if (readed_data.todo_counter <= 0) {
                                System.out.println("there are no todo for now");
                                break;
                            }
                            readed_data.printAllToDo();

                            int todo_selector = -1;
                            while (true) {
                                todo_selector = error_handlingINT(
                                        "Check a due date by selecting a TO-DO: \n 0 for exit\n",
                                        todo_selector);
                                if (todo_selector < 0) {
                                    System.out.println("too low");
                                } else if (todo_selector > readed_data.todo_counter) {
                                    System.out.println("too high");
                                } else if (todo_selector == 0) {
                                    System.out.println("you exitted");
                                    break;
                                } else {
                                    break;
                                }
                            }
                            if (todo_selector == 0) {
                                break;
                            }
                            todo_selector--;
                            int todo_comparison = 0;
                            todo_comparison = readed_data.month_onTODO.get(todo_selector);
                            System.out.printf("The Due date for task |%s| is : %d %s %d\n",
                                    readed_data.todo_task.get(todo_selector), readed_data.day_onTODO.get(todo_selector), //
                                    Month_names[todo_comparison-1],
                                    readed_data.year_onTODO.get(todo_selector));

                            break;

                        case "4":
                        case "exit":
                            exit = true;
                            break;
                    }
                    break;

                case "3":
                case "calendar":

                    FileInputStream baca_file = new FileInputStream(
                            "database.ser");
                    ObjectInputStream baca_obj = new ObjectInputStream(baca_file);
                    readed_data = (database) baca_obj.readObject();
                    baca_file.close();
                    baca_obj.close();
                    if (readed_data.todo_counter == 0) {
                        System.out.println("there are no todo for now");
                        break;
                    }

                    month_input_calendar = 0;
                    System.out.println("==Calendar Section==\n");
                    while (month_input_calendar > 12 || month_input_calendar < 1) {
                        month_input_calendar = error_handlingINT("Input Month : ", month_input_calendar);
                    }

                    year_input_calendar = 0;
                    while (year_input_calendar > 3000 || year_input_calendar < 1970) {
                        year_input_calendar = error_handlingINT("Input Year : ", year_input_calendar);
                    }

                    date = LocalDate.of(year_input_calendar, month_input_calendar, 1);
                    yearMonth = YearMonth.from(date);
                    lengthOfMonth = yearMonth.lengthOfMonth();
                    firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek().getValue();
                    moona = cal.get(Calendar.MONTH); // checking the current month in INT
                    moona++; // to make it 1-12 not 0-11
                    day = 1;
                    the_today = LocalDate.now().getDayOfMonth();
                    this_year = cal.get(Calendar.YEAR);

                    for (int h = 0; h < 6; h++) {
                        for (j = 0; j < 7; j++) {
                            if (h == 0 && j < firstDayOfMonth) {
                                calendar[h][j] = 0;
                            } else if (day <= lengthOfMonth) {
                                calendar[h][j] = day++;
                            } else {
                                calendar[h][j] = 0;
                            }
                        }
                    }
                    store_c = 0; // Reset the amount of temp var same month

                    // checker for which ones have the same month
                    for (int f = 0; f < readed_data.todo_counter; f++) {
                        if (readed_data.month_onTODO.get(f) == month_input_calendar
                                && readed_data.month_onTODO.get(f) != 0) {
                            temp_YearStorer[store_c] = readed_data.year_onTODO.get(f);
                            temp_dayStorer[store_c] = readed_data.day_onTODO.get(f);
                            temp_todo_task[store_c] = readed_data.todo_task.get(f);
                            if (temp_dayStorer[store_c] == the_today
                                    && year_input_calendar == temp_YearStorer[store_c]) {
                                dueNtoday_same = true;
                            }
                            store_c++; // adding the array
                        }
                    }

                    store_c = 0; // put back the array from index 0 for loop checking

                    for (int i = 0; i < readed_data.todo_counter; i++) {
                        if (temp_YearStorer[i] == year_input_calendar) { // this again but to check if the temp tadi itu
                                                                         // same
                            // year or not
                            temp2_dayStorer[store_c] = temp_dayStorer[i];
                            temp2_YearStorer[store_c] = temp_YearStorer[i];
                            temp2_todo_task[store_c] = temp_todo_task[i];

                            temp3_day[store_c] = temp2_dayStorer[store_c];
                            temp3_year[store_c] = temp2_YearStorer[store_c];
                            temp3_task[store_c] = temp2_todo_task[store_c];

                            store_c++;
                            temp_storer++;
                        }
                    }

                    Arrays.sort(temp2_YearStorer); // sort from low to high
                    Arrays.sort(temp2_dayStorer); // same shid

                    for (j = 0; j < temp_storer; j++) {
                        for (int i = 0; i < temp_storer; i++) {
                            if (temp3_day[i] == temp2_dayStorer[j]) {
                                temp3_task[j] = temp2_todo_task[i];
                            }
                        }
                    }

                    store_c = 0; // again so nanti pas di loop mulai dri 0
                    green = false;
                    CalendarColorIndicator(Month_names, month_input_calendar, year_input_calendar, green);

                    for (int h = 0; h < 6; h++) {
                        for (j = 0; j < 7; j++) {
                            if ((h == 0 && j < firstDayOfMonth)) {
                                System.out.print("    ");
                            } else if (temp2_dayStorer[store_c] == calendar[h][j] && temp2_dayStorer[store_c] != 0
                                    && temp2_dayStorer[store_c] != 9999
                                    && calendar[h][j] == the_today && month_input_calendar == moona
                                    && temp2_YearStorer[store_c] == this_year) { // Same month same day
                                System.out.printf("\u001B[35m%3d \u001B[00m", calendar[h][j]); // Purple
                                day_purple[store_c] = temp2_dayStorer[store_c];
                                temp3_day[store_c] = day;
                                temp3_day[store_c] = temp2_dayStorer[store_c];

                                store_c++; // checks the other days
                            } else if (temp2_dayStorer[store_c] == calendar[h][j] && temp2_dayStorer[store_c] != 0
                                    && temp2_dayStorer[store_c] != 9999) {
                                if (temp2_YearStorer[store_c] < this_year) {
                                    System.out.printf("\u001B[31m%3d \u001B[00m", calendar[h][j]); // RED
                                    // RED = true;
                                    day_red[store_c] = temp2_dayStorer[store_c];
                                    temp3_day[store_c] = temp2_dayStorer[store_c];

                                } else if (temp2_YearStorer[store_c] > this_year) {
                                    System.out.printf("\u001B[34m%3d \u001B[00m", calendar[h][j]); // BLUE
                                    day_blue[store_c] = temp2_dayStorer[store_c];
                                    temp3_day[store_c] = temp2_dayStorer[store_c];

                                } else if (temp2_YearStorer[store_c] == this_year) {
                                    if (month_input_calendar <= moona) {
                                        if (temp2_dayStorer[store_c] >= the_today) {
                                            System.out.printf("\u001B[34m%3d \u001B[00m", calendar[h][j]); // BLUE
                                            day_blue[store_c] = temp2_dayStorer[store_c];
                                            temp3_day[store_c] = temp2_dayStorer[store_c];

                                        } else if (temp2_dayStorer[store_c] < the_today) {
                                            System.out.printf("\u001B[31m%3d \u001B[00m", calendar[h][j]);
                                            day_red[store_c] = temp2_dayStorer[store_c];
                                            temp3_day[store_c] = temp2_dayStorer[store_c];
                                        }

                                    } else {
                                        System.out.printf("\u001B[34m%3d \u001B[00m", calendar[h][j]); // BLUE
                                        day_blue[store_c] = temp2_dayStorer[store_c];
                                        temp3_day[store_c] = temp2_dayStorer[store_c];

                                    }
                                }
                                store_c++; // checks the other days
                            } else if (calendar[h][j] == the_today && month_input_calendar == moona &&
                                    year_input_calendar == this_year) { // month same, year same, day same
                                System.out.printf("\u001B[33m%3d \u001B[00m", calendar[h][j]); // YELLOW
                            } else if (calendar[h][j] != 0) {
                                System.out.printf("%3d ", calendar[h][j]);
                            } else {
                                System.out.print(" ");
                            }
                            if (j == 6) {
                                System.out.println();
                            }
                        }
                    }
                    // temp_storer = 0;
                    System.out.println("List of tasks");
                    for (j = 0; j < temp_storer; j++) {
                        for (int i = 0; i < temp_storer; i++) {
                            if (day_purple[j] == temp3_day[i]) {
                                System.out.printf("The task's due :\u001B[35m%3d \u001B[00m %s %d\n",
                                        temp3_day[i],
                                        Month_names[month_input_calendar - 1], temp3_year[j]);
                                System.out.printf("Task Contents : %s\n", temp3_task[j]);
                            } else if (day_blue[j] == temp3_day[i]) {
                                System.out.printf("The task's due :\u001B[34m%3d \u001B[00m %s %d\n",
                                        temp3_day[i],
                                        Month_names[month_input_calendar - 1], temp3_year[j]);
                                System.out.printf("Task Contents : %s\n", temp3_task[j]);
                            } else if (day_red[j] == temp3_day[i]) {
                                System.out.printf("The task's due :\u001B[31m%3d \u001B[00m %s %d\n",
                                        temp3_day[i],
                                        Month_names[month_input_calendar - 1], temp3_year[j]);
                                System.out.printf("Task Contents : %s\n", temp3_task[j]);
                            }

                        }
                    }

                    for (int i = 0; i < 100; i++) {
                        temp2_dayStorer[i] = 9999;
                        temp2_YearStorer[i] = 9999;
                        temp_YearStorer[i] = 0;
                        temp_dayStorer[i] = 0;
                        temp3_task[i] = "";
                        temp3_day[i] = 0;
                    }
                    dueNtoday_same = false; // reset the same day same due boolean
                    store_c = 0;
                    temp_storer = 0;
                    break;
            }
        }
    }
}
