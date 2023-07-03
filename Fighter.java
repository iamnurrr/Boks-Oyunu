public class Fighter {
    String name ;
    int damage;// hasar verme miktarı
    int  health;
    int weight;
    int dodge;//blok yapabilme saldırıyı engelleme yeteneği


    Fighter(String name,int damage,int health,int weight,int dodge){
        this.damage=damage;
        this.name=name;
        this.health=health;
        this.weight=weight;
        if(dodge<=100&&dodge>=0){
        this.dodge=dodge;}
        else {
            this.dodge=0;
        }
    }
    int hit(Fighter foe){
        System.out.println(this.name+" => "+foe.name+" "+this.damage+" hasar verdi! ");
        if(foe.isDodge()){
            System.out.println(foe.name+" gelen hasarı blokladı");
            return foe.health;
        }
        if(foe.health-this.damage<0){
            return 0;
        }
        return foe.health-this.damage;

    }
    boolean isDodge(){

        double random=Math.random()*100;
        return random<=this.dodge ;
    }
}
