package com.bfrjunior.loja_virtual_bff.api.response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoResponseDTO {

    private String rua;

    private Long numero;

    private String bairro;

    private String complemento;

    private String cidade;

    private String cep;
}
