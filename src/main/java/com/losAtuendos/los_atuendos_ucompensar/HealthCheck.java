package com.losAtuendos.los_atuendos_ucompensar;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthCheck {

    @GetMapping()
    public String healthCheck() {
        return "OK";
    }
}
