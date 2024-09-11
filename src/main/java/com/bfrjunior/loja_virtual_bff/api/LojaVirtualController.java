package com.bfrjunior.loja_virtual_bff.api;

import com.bfrjunior.loja_virtual_bff.api.response.ProductsDTO;
import com.bfrjunior.loja_virtual_bff.business.LojaVirtualService;
import com.bfrjunior.loja_virtual_bff.business.ProdutosService;
import com.bfrjunior.loja_virtual_bff.business.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/loja-virtual")
@RequiredArgsConstructor
@Tag(name = "loja-virtual-api")
public class LojaVirtualController {

    private final ProdutosService produtosService;
    private final UsuarioService usuarioService;
    private final LojaVirtualService lojaVirtualService;

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/produtos")
    public ResponseEntity<List<ProductsDTO>> buscaTodosProdutos() {
        return ResponseEntity.ok(produtosService.buscaTodosProdutos());
    }

    @Operation(summary = "Busca produtos por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/produtos/{nome}")
    public ResponseEntity<ProductsDTO> buscaProdutosPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(produtosService.buscaProdutosPorNome(nome));
    }


}
