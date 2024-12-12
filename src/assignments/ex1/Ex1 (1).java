package assignments.ex1;

public class Ex1 {
    public static int number2Int(String num) {
        if (num == null || !num.contains("b")) {
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        String[] parts = num.split("b");
        if (parts.length != 2) {
            return -1;
        }

        String numberPart = parts[0];
        String basePart = parts[1];

        int base;
        try {
            base = Integer.parseInt(basePart, 17);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (base < 2 || base > 16) {
            return -1;
        }

        try {
            return Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false;
        }

        if (!a.contains("b")) {
            try {
                Integer.parseInt(a);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        String[] parts = a.split("b");
        if (parts.length != 2) {
            return false;
        }

        String numberPart = parts[0];
        String basePart = parts[1];

        int base;
        try {
            base = Integer.parseInt(basePart, 17);
        } catch (NumberFormatException e) {
            return false;
        }

        if (base < 2 || base > 16) {
            return false;
        }

        try {
            Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }

        String digits = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        do {
            result.insert(0, digits.charAt(num % base));
            num /= base;
        } while (num > 0);

        return result.toString();
    }

    public static boolean equals(String n1, String n2) {
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);

        return num1 == num2;
    }

    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value != -1 && value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
