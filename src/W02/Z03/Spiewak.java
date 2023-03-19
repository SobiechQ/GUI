package W02.Z03;

public abstract class Spiewak {
    private String nazwisko;
    private int numerStartowy;
    private static int count=0;
    public static Spiewak najglosniej(Spiewak[] input){
        Spiewak tmp = input[0];
        for(Spiewak s : input){
            if(s.getVal() > tmp.getVal()){
                tmp = s;
            }
        }
        return tmp;
    }


    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    private int getVal(){
        //max char value
        int maxNumber=0;
        int maxLetter=0;
        for (int i = 0; i < spiewaj().length(); i++) {
            if(spiewaj().charAt(i)>='0' && spiewaj().charAt(i)<='9'){
                //char na indexie i jest cyfrą.
                if(spiewaj().charAt(i)>maxNumber)
                    maxNumber = spiewaj().charAt(i);
            }
            if(spiewaj().charAt(i)>='a' && spiewaj().charAt(i)<='z'){
                if(spiewaj().charAt(i)>maxLetter)
                    maxLetter = spiewaj().charAt(i);
            }
        }


       return maxNumber+maxLetter;
    }

    @Override
    public String toString() {
        return this.nazwisko + ": " + this.spiewaj();
    }
    public abstract String spiewaj();
}
