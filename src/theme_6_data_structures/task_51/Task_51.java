package theme_6_data_structures.task_51;

import java.util.*;


public class Task_51 {
    public static void main(String[] args) {
//  Необходимо используя HushMap написать базу данных студентов, реализовать бесконечный цикл,
        // пользователь вводит имя студента и оценку и в случае если студент уже внесен в данную базу данных,
        // вводимая оценка должна сохраняться в списке и после каждого ввода необходимо осуществлять
        // вывод на экран средней оценки всех студентов.
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put("Ivan Ivanov", new ArrayList<>());
        hashMap.put("Petr Kozlov", new ArrayList<>());
        hashMap.put("Ivan Sokolov", new ArrayList<>());
        System.out.println(hashMap);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name of student and grade: ");
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter grade: ");
            int grade = scanner.nextInt();

            addGradeForName(hashMap, name, grade);
        }
    }

    private static void addGradeForName(HashMap<String, ArrayList<Integer>> hashMap, String name, int grade) {
        if (hashMap.containsKey(name)) {
            hashMap.get(name).add(grade);
            getAvgAllStudents(hashMap);
        } else {
            hashMap.put(name, new ArrayList<>());
        }
    }

    private static void getAvgAllStudents(HashMap<String, ArrayList<Integer>> hashMap) {
        for (Map.Entry<String, ArrayList<Integer>> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":  average grade = " + getAvgOfGrades(entry.getValue()));
        }
    }

    private static double getAvgOfGrades(ArrayList<Integer> grades) {
        double sum = 0;
        if (!grades.isEmpty()) {
            for (Integer grade : grades) {
                sum += grade;
            }
        }
        return sum/grades.size();
    }
}
