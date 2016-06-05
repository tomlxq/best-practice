package override;

/**
 * Created by tom on 2016/6/6.
 */
public class Fish extends Animal{
    @Override
    public void eat() {
        System.out.println("fish eat something");
    }

    public static void main(String[] args){
        Fish fish=new Fish();
        fish.eat();
    }
}
