package hw2;

public class Main {

    public static void main(String[] args) {
        String[][] arr = {{"1", "56", "-90", "89"}, {"45", "-5", "12", "7"}, {"12", "12345", "-11", "7"}, {"98", "-1000", "76", "56я"}};

        try {
            System.out.println("Сумма элементов массива: " + arrSum(arr));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("Не получилось посчитать сумму элементов массива: \n" + e.getMessage());
        }

    }

    public static int arrSum(String[][] arr) {

        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива не 4x4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива не 4x4");
            }
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Не удалось преобразовать элемент [%d][%d] в число", i, j));
                }
            }
        }

        return sum;

    }
}
