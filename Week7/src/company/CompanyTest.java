package company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CompanyTest {

    public static void main(String[] args) {
        Employee[] employees = CompanyUtils.generateRandomEmployees(10);
        
        System.out.println("Your company has the following employees: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        
        System.out.println("-----------");
        System.out.println("Sarch over the employees by typing in queries in the following format: ");
        System.out.println("<keyword> <operator> <value>");
        System.out.println("For example: ");
        System.out.println("skill = JUNIOR");
        System.out.println("skill = MID service > 1 position = DEVELOPER");
        System.out.print("Enter your query: ");

        SearchCriteria isJunior = new SearchCriteria() {
            @Override
            public boolean matches(Employee employee) {
                return employee.getSkillLevel() == SkillLevel.JUNIOR;
            }
        };

        SearchCriteria hasAtleastOneYear = new SearchCriteria() {
            @Override
            public boolean matches(Employee employee) {
                return employee.getYearsOfService() >= 1;
            }
        };

        Scanner in = new Scanner(System.in);
        String[] searchQuery = in.nextLine().split(" "); // i.e. skill JUNIOR service 1

        // there are only 6 fields in Employee
        // so we can search by a maximum of 6 criterias
        SearchCriteria[] criteria = new SearchCriteria[searchQuery.length / 3];
        int index = 0;

        // iterate over the split-up search criteria, taking groups of size 3
        for (int i = 0; i < searchQuery.length; i += 3) {
            final String searchKeyword = searchQuery[i];
            final String operator = searchQuery[i + 1];
            final String searchValue = searchQuery[i + 2];

            switch (searchKeyword) {
                case "skillLevel": {
                    criteria[index++] = (new SearchCriteria() {
                        @Override
                        public boolean matches(Employee employee) {
                            return employee.getSkillLevel() == SkillLevel.valueOf(searchValue);
                        }
                    });
                    break;
                }
                case "sex":
                    if (operator.equals("=")) {
                        criteria[index++] = (new SearchCriteria() {
                            @Override
                            public boolean matches(Employee employee) {
                                return employee.getSex() == Sex.valueOf(searchValue);
                            }
                        });
                    } else {
                        throw new IllegalArgumentException(
                                String.format("Operator %s not applicable for sex", operator));
                    }
                    break;
                case "position":
                    if (operator.equals("=")) {
                        criteria[index++] = new SearchCriteria() {
                            @Override
                            public boolean matches(Employee employee) {
                                return employee.getPosition() == Position.valueOf(searchValue);
                            }
                        };
                    } else {
                        throw new IllegalArgumentException(
                                String.format("Operator %s not applicable for psotion", operator));
                    }
                    break;

                case "name":
                    if (operator.equals("=")) {
                        criteria[index++] = new SearchCriteria() {
                            @Override
                            public boolean matches(Employee employee) {
                                return employee.getName().equals(searchValue);
                            }
                        };
                    } else {
                        throw new IllegalArgumentException(
                                String.format("Operator %s not applicable for name", operator));
                    }
                    break;

                case "salary":
                    switch (operator) {
                        case "=":
                            criteria[index++] = new SearchCriteria() {
                                @Override
                                public boolean matches(Employee employee) {
                                    return employee.getSalary() == Integer.parseInt(searchValue);
                                }
                            };
                            break;
                        case ">":
                            criteria[index++] = new SearchCriteria() {
                                @Override
                                public boolean matches(Employee employee) {
                                    return employee.getSalary() > Integer.parseInt(searchValue);
                                }
                            };
                            break;
                        case "<":
                            criteria[index++] = new SearchCriteria() {
                                @Override
                                public boolean matches(Employee employee) {
                                    return employee.getSalary() < Integer.parseInt(searchValue);
                                }
                            };
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    String.format("Operator %s not applicable for salary", operator));
                    }
                    break;
                case "yearsOfService":
                    switch (operator) {
                        case "=":
                            criteria[index++] = new SearchCriteria() {
                                @Override
                                public boolean matches(Employee employee) {
                                    return employee.getYearsOfService() == Integer.parseInt(searchValue);
                                }
                            };
                            break;
                        case ">":
                            criteria[index++] = new SearchCriteria() {
                                @Override
                                public boolean matches(Employee employee) {
                                    return employee.getYearsOfService() > Integer.parseInt(searchValue);
                                }
                            };
                            break;
                        case "<":
                            criteria[index++] = new SearchCriteria() {
                                @Override
                                public boolean matches(Employee employee) {
                                    return employee.getYearsOfService() < Integer.parseInt(searchValue);
                                }
                            };
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    String.format("Operator %s not applicable for salary", operator));
                    }
            }
        }

        Employee[] matchingEmployees = Query.and(employees, criteria);

        for (Employee matchingEmployee : matchingEmployees) {
            System.out.println(matchingEmployee);
        }
    }
}
