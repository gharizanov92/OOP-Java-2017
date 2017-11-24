/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author gharizanov
 */
public class CompanyUtils {
    final static String[] names = {"Neda", "Jamel", "Kendrick", "Classie", "Karrie", "Jeffie", "Milo", "Rod", "Mazie", "Reina", "Lorrine", "Ricki", "Wyatt", "Dara", "Jackie", "Luise", "Janna", "Ammie", "Gaynelle", "Clint"};

    public static int randomNumber(int lower, int higher) {
        return (int) (Math.random() * (higher - lower)) + lower;
    }

    public static int randomIndex(Object[] arr) {
        return (int) (Math.random() * (arr.length));
    }

    public static String randomName() {
        return names[randomIndex(names)];
    }

    public static Sex randomSex() {
        Sex[] values = Sex.values();
        return values[randomIndex(values)];
    }

    public static Position randomPosition() {
        Position[] values = Position.values();
        return values[randomIndex(values)];
    }

    public static SkillLevel randomSkillLevel() {
        SkillLevel[] levels = SkillLevel.values();
        return levels[randomIndex(levels)];
    }

    public static Employee[] generateRandomEmployees(final int numberOfEmployees) {
        final Employee[] employees = new Employee[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            employees[i] = (new Employee(
                    randomName(),
                    randomSex(),
                    randomPosition(),
                    randomSkillLevel(),
                    randomNumber(0, 5),
                    randomNumber(500, 5000)));
        }
        return employees;
    }
}
