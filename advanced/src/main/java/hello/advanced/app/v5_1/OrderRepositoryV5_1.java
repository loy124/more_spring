package hello.advanced.app.v5_1;


import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.callback.TraceTemplateV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5_1 {

    private final TraceTemplateV2 traceTemplate;


    public void save(String itemId){
        traceTemplate.execute("OrderRepository.save()", ()-> {
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
