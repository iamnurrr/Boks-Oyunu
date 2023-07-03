public class Main {
    public static void main(String[] args) {
Fighter f1=new Fighter("Merve",100,650,60,50);
Fighter f2=new Fighter("Toso",120,500,70,50);
        Match m1=new Match(f1,f2,10,120);
        m1.run();

    }
}