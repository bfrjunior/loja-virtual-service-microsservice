package com.bfrjunior.loja_virtual_bff.business;

import com.bfrjunior.loja_virtual_bff.api.request.CartaoRequestDTO;
import com.bfrjunior.loja_virtual_bff.infrastructure.clients.pagamentoclient.PagamentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoClient pagamentoClient;

    public Boolean verificaPagamento(CartaoRequestDTO cartaoRequestDTO){
        return pagamentoClient.verificaPagamento(cartaoRequestDTO);
    }
}
