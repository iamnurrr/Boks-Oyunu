import java.util.Random;
public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    Fighter randomFighter;
    Fighter otherFighter;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public void chooseRandomFighter() {
        Random random = new Random();
        boolean selectFighter = random.nextBoolean();

        if (selectFighter) {
            // f1'yi seç
            System.out.println("Kuraya göre " + this.f1.name + " başlayacak: ");
            randomFighter = f1;
            otherFighter = f2;
        } else {
            // f2'yi seç
            System.out.println("Kuraya göre " + this.f2.name + " başlayacak: ");
            randomFighter = f2;
            otherFighter = f1;
        }
    }

    void run() {
        chooseRandomFighter();
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=== START ROUND ===");
                otherFighter.health = randomFighter.hit(otherFighter);
                if(isWin()){
                    break;
                }
                System.out.println(this.otherFighter.name +" Kalan Can : " + otherFighter.health);
                randomFighter.health = otherFighter.hit(randomFighter);
                if (isWin()){
                    break;
                }
                System.out.println(this.randomFighter.name+" Kalan Can : " + randomFighter.health);
            }
        } else {
            System.out.println("Sporcuların sikletleri uymuyor !");
        }
    }

    boolean isWin() {

        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " Kazandı!  ");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " Kazandı! ");
            return true;
        }
        return false;
    }
    boolean isCheck(){
        return( this.f1.weight>=minWeight && this.f1.weight<=maxWeight)&&(this.f2.weight>=minWeight && this.f2.weight<=maxWeight);
    }

}
