package constApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/registrarse").permitAll()
                .antMatchers("/css/**", "/js/**", "/registration").permitAll()
                .antMatchers("/oc").hasAnyAuthority("Admin","Socio","Contable","BAC","Otros")
                .antMatchers("/home").hasAnyAuthority("Admin","Socio","Contable","BAC","Otros")
                .antMatchers("/dashboard").hasAnyAuthority("Admin","Socio")
                .antMatchers("/proveedor").hasAnyAuthority("Admin","Socio","Contable")
                .antMatchers("/ingresos").hasAnyAuthority("Admin","Socio")
                .antMatchers("/gastos").hasAnyAuthority("Admin","Socio","Contable")
                .antMatchers("/balance").hasAnyAuthority("Admin","Socio")
                .antMatchers("/clientes").hasAnyAuthority("Admin","Socio","Contable")
                .antMatchers("/cuentas").hasAnyAuthority("Admin","Socio","Contable")
                .antMatchers("/rubros").hasAnyAuthority("Admin","Socio","Contable")
                .antMatchers("/proyectos").hasAnyAuthority("Admin","Socio")
                .antMatchers("/cambioDivisas").hasAnyAuthority("Admin","Socio")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessdenied")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}






//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/addUsuario").permitAll()
//                .antMatchers("/saveUsuario").permitAll()
//                .antMatchers("/oc/**").hasAnyAuthority("Admin","Socio","Contable","BAC","Otros")
//                .antMatchers("/home").hasAnyAuthority("Admin","Socio","Contable","BAC","Otros")
//                .antMatchers("/proveedores/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/ingresos/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/gastos/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/balance/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/clientes/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/cuentas/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/roles/**").hasAnyAuthority("Admin","Socio","Contable")
//                .antMatchers("/proyectos/**").hasAnyAuthority("Admin","Socio","Contable")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl("/j_spring_security_check") // Submit URL
//                .loginPage("/login").failureUrl("/login?error=true")
//                .defaultSuccessUrl("/home")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//    }
//
//
//}
