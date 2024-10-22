package com.example.Bank.service;

import com.example.Bank.entity.Transfer;
import com.example.Bank.entity.User;
import com.example.Bank.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    TransferRepository repo;

    @Autowired
    UserService trans;

    public Transfer create(Transfer mod){
        User user1 = trans.findByEmail(mod.getRemetente());
        User user2 = trans.findByEmail(mod.getDestinatario());

        if (user1.getAmount() < mod.getValorTransfer()){
            throw new RuntimeException("Limite excedido");
        } else {
            user1.setAmount(user1.getAmount() - mod.getValorTransfer());
            user2.setAmount(user2.getAmount() + mod.getValorTransfer());
        }
        return repo.save(mod);
    }

    public List<Transfer> findAll(){
        return repo.findAll();
    }
}
