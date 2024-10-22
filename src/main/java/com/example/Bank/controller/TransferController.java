package com.example.Bank.controller;

import com.example.Bank.entity.Transfer;
import com.example.Bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    TransferService service;

    @PostMapping
    public ResponseEntity<Transfer> create(@RequestBody Transfer transfer){
        Transfer user = service.create(transfer);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping
    public ResponseEntity<List<Transfer>> findAll(){
        List<Transfer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
