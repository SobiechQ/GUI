package W02.Z05;

public interface Speakable {
    String speak();
    static Speakable naglosniej(Speakable[] input){
        Speakable tmp=input[0];
        for (Speakable s : input) {
            if(s.speak().length() > tmp.speak().length()){
                tmp=s;
            }
        }
        return tmp;
    }
}
