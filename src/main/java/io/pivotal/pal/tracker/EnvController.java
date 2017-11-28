package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private static final String PORT_KEY = "PORT";
    private static final String MEMORY_LIMIT_KEY = "MEMORY_LIMIT";
    private static final String INSTANCE_INDEX_KEY = "CF_INSTANCE_INDEX";
    private static final String INSTANCE_ADDRESS_KEY = "CF_INSTANCE_ADDR";

    private String port;
    private String memoryLimit;
    private String instanceIndex;
    private String instanceAddress;

    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,@Value("${CF_INSTANCE_INDEX:NOT SET}") String instanceIndex,@Value("${CF_INSTANCE_ADDR:NOT SET}") String instnaceAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.instanceIndex = instanceIndex;
        this.instanceAddress = instnaceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> result = new HashMap<>();
        result.put(PORT_KEY, port);
        result.put(MEMORY_LIMIT_KEY, memoryLimit);
        result.put(INSTANCE_INDEX_KEY, instanceIndex);
        result.put(INSTANCE_ADDRESS_KEY, instanceAddress);
        return result;
    }

}
