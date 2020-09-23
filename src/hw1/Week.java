package hw1;

public enum Week {
    Monday(120), tuesday(96), Wednesday(72), Thursday(48), Friday(24), Saturday(0), Sunday(0);

    private int hoursLeft;

    Week(int hoursLeft) {
        this.hoursLeft = hoursLeft;
    }

    public int getWorkingHours() {
        if (this == Saturday || this == Sunday) {
            System.out.println("Сегодня выходной");
        }
        return this.hoursLeft;
    }
}
