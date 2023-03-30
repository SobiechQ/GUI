package W03.Z02;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        class Test{
            private static <T,R> void transform(T[] in, R[] out, Transform<T,R> transform){
                if(in.length != out.length)
                    throw new IllegalArgumentException("Arrays have to have same length");
                for (int i = 0; i < in.length; i++)
                    out[i]=transform.apply(in[i]);
                System.out.println(Arrays.toString(out));
            }
        }

        String[] sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) + '\n');
        class StrToInt implements Transform<String, Integer>{
            @Override
            public Integer apply(String toBeTransformed) {
                return toBeTransformed.length();
            }
        }
        Test.transform(sin, new Integer[sin.length], new StrToInt());
        Test.transform(sin, new Character[sin.length], (String s) -> s.charAt(0));
        Test.transform(sin, new String[sin.length], String::toUpperCase);


    }
}
