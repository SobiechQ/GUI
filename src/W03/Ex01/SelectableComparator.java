package W03.Ex01;

import java.util.Comparator;


public class SelectableComparator implements Comparator<Student> {
//    public SelectableComparator(String typPoString) {
//        this.mode = switch (String typPoString){
//            case SORT_BY_NAME -> 0;
//        };
//    }




    int mode; //poprzez int wybieram rodzaj sortowania.
    //lepiej zrobic to enumem

    public SelectableComparator(int mode) {
        this.mode = mode;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return switch (mode){
            case 0 -> o1.index - o2.index;
            default -> 0;
        };
    }
}
