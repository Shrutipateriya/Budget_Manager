import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String name;
    private double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

class Income {
    private String source;
    private double amount;

    public Income(String source, double amount) {
        this.source = source;
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }
}

class RecurringCost {
    private String name;
    private double amount;

    public RecurringCost(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

public class BudgetTracker {
    private List<Expense> expenses = new ArrayList<>();
    private List<Income> incomes = new ArrayList<>();
    private List<RecurringCost> recurringCosts = new ArrayList<>();

    public void addExpense(String name, double amount) {
        expenses.add(new Expense(name, amount));
    }

    public void addIncome(String source, double amount) {
        incomes.add(new Income(source, amount));
    }

    public void addRecurringCost(String name, double amount) {
        recurringCosts.add(new RecurringCost(name, amount));
    }

    public double calculateTotalIncome() {
        double total = 0;
        for (Income income : incomes) {
            total += income.getAmount();
        }
        return total;
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public double calculateTotalRecurringCosts() {
        double total = 0;
        for (RecurringCost cost : recurringCosts) {
            total += cost.getAmount();
        }
        return total;
    }

    public void printReport() {
        System.out.println("Budget Report:");
        System.out.println("Total Income: $" + calculateTotalIncome());
        System.out.println("Total Expenses: $" + calculateTotalExpenses());
        System.out.println("Total Recurring Costs: $" + calculateTotalRecurringCosts());
        System.out.println("Net Balance: $" + (calculateTotalIncome() - calculateTotalExpenses() - calculateTotalRecurringCosts()));
    }

    public static void main(String[] args) {
        BudgetTracker tracker = new BudgetTracker();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Household Budget Tracker!");
        do {
            System.out.println("Choose an action: add_expense, add_income, add_recurring, report, exit");
            command = scanner.nextLine();

            switch (command) {
                case "add_expense":
                    System.out.print("Enter expense name: ");
                    String expenseName = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    tracker.addExpense(expenseName, expenseAmount);
                    break;

                case "add_income":
                    System.out.print("Enter income source: ");
                    String incomeSource = scanner.nextLine();
                    System.out.print("Enter income amount: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    tracker.addIncome(incomeSource, incomeAmount);
                    break;

                case "add_recurring":
                    System.out.print("Enter recurring cost name: ");
                    String recurringName = scanner.nextLine();
                    System.out.print("Enter recurring cost amount: ");
                    double recurringAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    tracker.addRecurringCost(recurringName, recurringAmount);
                    break;

                case "report":
                    tracker.printReport();
                    break;

                case "exit":
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
