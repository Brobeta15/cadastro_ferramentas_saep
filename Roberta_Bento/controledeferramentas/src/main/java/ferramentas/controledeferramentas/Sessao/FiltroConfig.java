package ferramentas.controledeferramentas.Sessao;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltroConfig {
    @Bean
    public FilterRegistrationBean<FiltroAutenticacao> filtroAutenticacao() {
        FilterRegistrationBean<FiltroAutenticacao> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FiltroAutenticacao());
        registration.addUrlPatterns("/listaproduto", "/listaestoque/*", "/alterarproduto/*",
                "/cadastroproduto", "/estoque/*", "/home/*", "/historicoestoque/*", "/home");
        registration.setOrder(1); // prioridade de execução, se houver outros filtros
        return registration;
    }
}
