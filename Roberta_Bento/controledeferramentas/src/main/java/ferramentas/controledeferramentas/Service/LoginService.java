package ferramentas.controledeferramentas.Service;

import ferramentas.controledeferramentas.Dtos.LoginDto;
import ferramentas.controledeferramentas.Dtos.LoginSessaoDto;
import ferramentas.controledeferramentas.Dtos.UsuarioDto;
import ferramentas.controledeferramentas.Models.UsuarioModel;
import ferramentas.controledeferramentas.Repositorys.LoginRepository;
import ferramentas.controledeferramentas.Sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public Boolean validarLogin(LoginDto dto){

        Optional<UsuarioModel> usuarioOP = repository.findByEmail(dto.getEmail());

        if (usuarioOP.isPresent()){

            if (usuarioOP.get().getSenha().equals(dto.getSenha())){

                return true;
            }
        }
        return false;
    }

    public boolean cadastrarUsuario(UsuarioDto dto){

        Optional<UsuarioModel> op = repository.findByEmail(dto.getEmail());

        if (op.isPresent()){

            return false;
        }
        UsuarioModel model = new UsuarioModel();
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setSenha(dto.getSenha());

        repository.save(model);
        return true;
    }

    public LoginSessaoDto retornarLoginSessao(HttpServletRequest request, LoginDto dto){

        Optional<UsuarioModel> usuarioOP = repository.findByEmailAndSenha(dto.getEmail(), dto.getSenha());
        LoginSessaoDto sessao = new LoginSessaoDto();

        if (usuarioOP.isPresent()){
            sessao.setId(usuarioOP.get().getId());
            sessao.setNome(usuarioOP.get().getNome());

            return sessao;
        }
        return sessao;
    }

    public UsuarioModel retornarUsuarioLogado(LoginSessaoDto sessao){

        Optional<UsuarioModel> usuarioOp = repository.findById(sessao.getId());

        UsuarioModel dto = new UsuarioModel();
        if (usuarioOp.isPresent()){

            dto.setNome(usuarioOp.get().getNome());
            dto.setId(usuarioOp.get().getId());
            dto.setEmail(usuarioOp.get().getEmail());
            dto.setSenha(usuarioOp.get().getSenha());

            return dto;
        }
        return dto;
    }
}
