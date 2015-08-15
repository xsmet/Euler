public class Problem19 {
    public static int daysInMonth(int m, int y) {
        int days = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            days = 30;
        }
        else if (m == 2) {
            if (y % 4 == 0)
                if (y % 100 == 0 && y % 400 != 0)
                    days = 28;
                else
                    days = 29;
            else
                days = 28;
        }
        return days;
    }
    
    public static int sundaysOnFirstUntil(int endYear) {
        //1 jan 1900 is a Monday, 1900 has 365 days
        int currentDay = 0; // Monday
        int sundaysOnFirst = 0;
        for (int y = 1900; y <= endYear; y++) {
            for (int m = 1; m <= 12; m++) {
                int maxD = daysInMonth(m, y);
                for (int d = 1; d <= maxD; d++) {
                    
                    if (currentDay == 6 && d == 1) {
                        sundaysOnFirst++;
                    }

                    currentDay++;
                    currentDay %= 7;
                }
            }
        }
        return sundaysOnFirst;
    }
    
    public static void main(String[] args) {
        // #(1901-2000) = #(1900-2000) - #(1900-1900)
        int nDays = sundaysOnFirstUntil(2000) - sundaysOnFirstUntil(1900);
        System.out.println("Sundays on first of the month: " + nDays);
    }
}

