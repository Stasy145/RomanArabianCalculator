
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your expression: ");
        String userExpression = scanner.nextLine().trim();

        calculateResult(userExpression);

    }




        public static void calculateResult(String userInput){

            String[] mathOperators = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};

            try {

                int mathOperatorsIndex = -1;

                for (int i = 0; i < mathOperators.length; i++) {
                    if (userInput.contains(mathOperators[i])) {
                        mathOperatorsIndex = i;
                        break;
                    }
                }


                String[] splittedUserExpression = userInput.split(regexActions[mathOperatorsIndex]);
                String firstNumber = splittedUserExpression[0].trim();
                String secondNumber = splittedUserExpression[splittedUserExpression.length - 1].trim();


                int secondNum;
                int firstNum;


                boolean firstIsRoman = RomanToArabianConverter.isRoman(firstNumber);
                boolean secondIsRoman = RomanToArabianConverter.isRoman(secondNumber);

                firstNum = firstIsRoman
                        ? RomanToArabianConverter.romanToArabian(firstNumber)
                        : Integer.parseInt(firstNumber);

                secondNum = secondIsRoman
                        ? RomanToArabianConverter.romanToArabian(secondNumber)
                        : Integer.parseInt(secondNumber);

                int result;
                switch (mathOperators[mathOperatorsIndex]) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    default:
                        if (secondNum == 0) { // Проверяем деление на ноль
                            throw new ArithmeticException("Division by zero.");
                        }
                        result = firstNum / secondNum;
                        break;
                }

                System.out.println(result);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid syntax");
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format.");
            }
        }
    }
















