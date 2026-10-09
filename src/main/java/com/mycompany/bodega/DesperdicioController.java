package com.mycompany.bodega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/desperdicios")
public class DesperdicioController {

    @Autowired
    private DesperdicioRepository desperdicioRepository;

    @Autowired
    private DesperdicioService desperdicioService;

    @GetMapping
    public List<Desperdicio> obtenerTodos() {
        return desperdicioRepository.findAll();
    }

    // Actualizado: Ahora procesa la merma y actualiza los lotes al mismo tiempo
    @PostMapping
    public Desperdicio guardar(@RequestBody Desperdicio desperdicio) {
        return desperdicioService.registrarDesperdicio(desperdicio);
    }
}
