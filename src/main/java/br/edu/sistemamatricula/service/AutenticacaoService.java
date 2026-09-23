package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.UsuarioDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AutenticacaoService {
    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    /** TODO sprint 3: Spring Security, hash seguro, bloqueio e expiração da sessão. */
    @Transactional
    public UsuarioDto.Resposta autenticar(UsuarioDto.Credenciais credenciais) {
        throw new FuncionalidadeNaoImplementadaException("Autenticar usuário");
    }

    @Transactional
    public void alterarSenha(Long usuarioId, UsuarioDto.NovaSenha novaSenha) {
        throw new FuncionalidadeNaoImplementadaException("Alterar senha");
    }
}
