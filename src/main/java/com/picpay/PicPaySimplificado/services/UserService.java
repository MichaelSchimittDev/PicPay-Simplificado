package com.picpay.PicPaySimplificado.services;

import com.picpay.PicPaySimplificado.domain.user.User;
import com.picpay.PicPaySimplificado.domain.user.UserType;
import com.picpay.PicPaySimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() ==  UserType.MERCHANT){
            throw new Exception("Usuario do tipo lojista nao sera autorizado a realizar transacoes");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Usuario nao tem saldo suficiente no momento");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }
}
