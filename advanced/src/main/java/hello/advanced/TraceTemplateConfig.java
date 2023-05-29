package hello.advanced;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.callback.TraceTemplateV2;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TraceTemplateConfig {

    private final LogTrace trace;

    @Bean
    public TraceTemplateV2 traceTemplateV2(){

        return new TraceTemplateV2(trace);
    }

}
