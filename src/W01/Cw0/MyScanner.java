package W01.Cw0;

import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
    InputStream inputStream;
    public MyScanner(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    public String readWord(){

        StringBuffer sb = new StringBuffer();
        char tmpChar=' ';
        do {
            try {
                tmpChar = (char) inputStream.read();
                sb.append(tmpChar);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!(tmpChar==' '||tmpChar=='\n'));



        return sb.toString();
    }

    /**
     * Cała linijka
     */
    public String readLine(){
        StringBuffer sb = new StringBuffer();
        char tmpChar=' ';
        do {
            try {
                tmpChar = (char) inputStream.read();
                if(tmpChar!='\n')
                    sb.append(tmpChar);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (tmpChar!='\n');
        return sb.toString();
    }
    public int readInt(){
        StringBuffer sb = new StringBuffer();
        char tmpChar=' ';
        boolean isNegative=false;
        do {
            try {
                tmpChar = (char) inputStream.read();
                if(tmpChar=='-')
                    isNegative=true;
                if(isNumber(tmpChar))
                    sb.append(tmpChar);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!(tmpChar==' '||tmpChar=='\n'));
        return isNegative?-1*Integer.parseInt(sb.toString()):Integer.parseInt(sb.toString());
    }
    public int readPosInt() throws Exception{
        int toTest=readInt();
        if(toTest<0)
            throw new Exception("Liczba nie jest dodatnia");
        return toTest;
    }
    private boolean isNumber(char toTest){
        return toTest>='0'&&toTest<='9';
    }
}
