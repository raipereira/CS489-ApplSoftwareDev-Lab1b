package edu.miu.cs.cs489;

import com.google.gson.*;
import edu.miu.cs.cs489.model.Employee;
import edu.miu.cs.cs489.model.PensionPlan;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        PensionPlan p1 = new PensionPlan("EX1089",
                LocalDate.of(2023,01,17), 100.00 );

        PensionPlan p2 = new PensionPlan("SM2307",
                LocalDate.of(2019,11,04), 1555.50 );




        employees.add(new Employee(1,"Daniel", "Agar",
                LocalDate.of(2018,01,17), 100.00, p1));


        employees.add(new Employee(2,"Benard", "Shaw",
                LocalDate.of(2018,10,03), 197750.00, null));

employees.add(new Employee(3,"Carly", "Agar",
                LocalDate.of(2014,05,16), 842000.75, p2));

employees.add(new Employee(4,"Wesley", "Schneider",
                LocalDate.of(2018,11,02), 74500.00 , p2));


            Main app = new Main();
            app.printEmployee(employees);

    }



    public void printEmployee(List<Employee> employees) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        Gson gson = gsonBuilder.create();

        //JSON-formatted list of all Products:
       // System.out.println("JSON-formatted list of all Products: ");
        for (Employee p : employees) {
            System.out.println(gson.toJson(p));
        }
    }

    class LocalDateSerializer implements JsonSerializer<LocalDate> {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(formatter.format(localDate));
        }
    }
}