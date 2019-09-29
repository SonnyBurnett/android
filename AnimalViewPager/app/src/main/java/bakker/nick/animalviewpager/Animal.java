package bakker.nick.animalviewpager;

public class Animal {
    public int id;
    public int imageRes;
    public Animal(int id, int imageRes) {
        this.id = id;
        this.imageRes = imageRes;
    }
    private int getId() {
        return id;
    }
    public int getImageRes() {
        return imageRes;
    }
}
