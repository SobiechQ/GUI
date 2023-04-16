package W06.Z05;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class MyMath {
    public static BigDecimal piGeneration(long complexity){
        BigDecimal output = BigDecimal.valueOf(0);
        for (long i = 0; i < complexity; i++) {
            output = output.add(BigDecimal.valueOf(i%2==0? 1:-1)
                    .divide(BigDecimal.valueOf((2*i)+1), MathContext.DECIMAL128)
                    .multiply(BigDecimal.valueOf(4)));
        }
        return output;
    }
    public static BigDecimal piGenerationMultiThread(long complexity, int coreCount){
        class MathThread
            extends Thread{
            private static int coreCount;
            private static long complexity;
            private int coreId;
            private BigDecimal segmentSelf = BigDecimal.valueOf(0);


            private MathThread(int coreId){
                this.coreId=coreId;
            }
            public static ArrayList<MathThread> getListOfTreads(long complexity, int coreCount){
                MathThread.coreCount=coreCount;
                MathThread.complexity=complexity;
                ArrayList<MathThread> mathThreadArrayList = new ArrayList<>();
                for (int i = 0; i < coreCount; i++)
                    mathThreadArrayList.add(new MathThread(i));
                return mathThreadArrayList;
            }

            @Override
            public void run() {
                long complexityFrom = (this.coreId * complexity/coreCount)+1;
                long complexityTo = (1+this.coreId) * complexity/coreCount;
                if(this.coreId == 0)
                    complexityFrom--;
                if(this.coreId == coreCount-1)
                    complexityTo--;
                System.out.println("Core ID: "+this.coreId+" started. running from: "+complexityFrom+", to: "+complexityTo);
                for (long i = complexityFrom; i <= complexityTo; i++) {
                    segmentSelf = segmentSelf.add(BigDecimal.valueOf(i%2==0? 1:-1)
                            .divide(BigDecimal.valueOf((2*i)+1), MathContext.DECIMAL128)
                            .multiply(BigDecimal.valueOf(4)));
                }
            }
            public BigDecimal getSegmentSelf() {
                return segmentSelf;
            }
        }
        ArrayList<MathThread> mathThreads = MathThread.getListOfTreads(complexity, coreCount);
        for (MathThread mathThread : mathThreads) {
            mathThread.start();
        }
        //wait till all finished
        while (!(mathThreads.stream().allMatch(t->t.getState()==Thread.State.TERMINATED)))
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        //sum all threads
        return mathThreads.stream()
                .map(MathThread::getSegmentSelf)
                .reduce(BigDecimal.valueOf(0),
                        (BigDecimal::add));
    }
}
