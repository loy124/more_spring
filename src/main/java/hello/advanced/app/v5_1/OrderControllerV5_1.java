package hello.advanced.app.v5_1;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.callback.TraceTemplateV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5_1 {

    private final OrderServiceV5_1 orderService;
    private final TraceTemplateV2 traceTemplate;

//    @Autowired
//    public OrderControllerV5_1(OrderServiceV5_1 orderService, LogTrace trace) {
//        this.orderService = orderService;
//        this.traceTemplate = new TraceTemplate(trace);
//    }

    @GetMapping("/v5_1/request")
    public String request(String itemId){
        return traceTemplate.execute("OrderController.request()",
                new TraceCallback<>() {
                    @Override
                    public String call() {
                        orderService.orderItem(itemId);
                        return "ok";
                    }
                });
    }



}
