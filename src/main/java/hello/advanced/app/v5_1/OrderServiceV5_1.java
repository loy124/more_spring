package hello.advanced.app.v5_1;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.callback.TraceTemplateV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5_1 {

    private final OrderRepositoryV5_1 orderRepository;
    private final TraceTemplateV2 traceTemplate;


    public void orderItem(String itemId){

         traceTemplate.execute("OrderService.orderItem()",
                new TraceCallback<String>() {
                    @Override
                    public String call() {
                        orderRepository.save(itemId);
                        return null;
                    }
                });




    }
}
