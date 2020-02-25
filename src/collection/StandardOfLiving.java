package collection;

public enum StandardOfLiving {
    ULTRA_HIGH(2),
    LOW(1),
    NIGHTMARE(0);

    private final int level;

    StandardOfLiving(int level){
        this.level=level;
    }

    public int getLevel() {
        return level;
    }
}
