public enum Color {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    ORANGE,
    PINK;

    public static Color randomColor(){
        int rnd=((int)(Math.random()*100))%6;
        return switch (rnd) {
            case 0 -> RED;
            case 1 -> GREEN;
            case 2 -> BLUE;
            case 3 -> YELLOW;
            case 4 -> ORANGE;
            case 5 -> PINK;
            default -> PINK;
        };
    }
}
