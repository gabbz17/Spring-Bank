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

        if (user1.getAmount().compareTo(mod.getValorTransfer()) > 0){
            user1.setAmount(user1.getAmount().subtract(mod.getValorTransfer()));
            user2.setAmount(user2.getAmount().add(mod.getValorTransfer()));
        } else {
            throw new RuntimeException("Limite excedido");
        }
        return repo.save(mod);
    }

    public List<Transfer> findAll(){
        return repo.findAll();
    }
}
