package com.banco.banco_api.controller;

import com.banco.banco_api.dto.*;
import com.banco.banco_api.model.Conta;
import com.banco.banco_api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*")


public class ContaController {
    
    @Autowired
    private ContaService service;

    @PostMapping
    public Conta criar (@RequestBody ContaDTO dto){
        return service.criarConta(dto.titular, dto.tipo);
    }
    @GetMapping
    public List<Conta> listar(){
        return service.listarContas();
    }
    @PostMapping("/depositar")
    public Conta depositar(@RequestBody OperacaoDTO dto){
        return service.depositar(dto.id, dto.valor);
    }
    @PostMapping("/sacar")
    public Conta sacar(@RequestBody OperacaoDTO dto){
        return service.sacar(dto.id, dto.valor);
    }
    @PostMapping("/transferir")
    public void transferir(@RequestBody TransferenciaDTO dto){
        service.transferir(dto.origemId, dto.destinoId, dto.valor);
    }


    @GetMapping("/tributo/{id}")
    public double tributo(@PathVariable Long id){
        return service.calcularTributo(id);
    }
}
