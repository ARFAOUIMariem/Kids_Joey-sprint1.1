/* package com.onegateafrica.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity*/ /* (jsr250Enabled = true)
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/home").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/newuser").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/updateuser/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/deleteuser/**").permitAll()

                .antMatchers(HttpMethod.GET,"/api/homeAct").permitAll()
                .antMatchers(HttpMethod.GET, "/api/activities").permitAll()
                .antMatchers(HttpMethod.GET, "/api/activity/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/newactivity").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/updateactivity/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/deleteactivity/**").permitAll()

                .antMatchers(HttpMethod.GET,"/api_repas/home").permitAll()
                .antMatchers(HttpMethod.GET, "/api_repas/repass").permitAll()
                .antMatchers(HttpMethod.GET, "/api_repas/repas/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api_repas/newrepas").permitAll()
                .antMatchers(HttpMethod.PUT,"/api_repas/repass/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api_repas/deleterepas/**").permitAll()

                .antMatchers(HttpMethod.GET,"/api_enf/home").permitAll()
                .antMatchers(HttpMethod.GET, "/api_enf/enfants").permitAll()
                .antMatchers(HttpMethod.GET, "/api_enf/enfant/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api_enf/newenfant/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/api_enf/updateenfant/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api_enf/deleteenfant/**").permitAll()


                .antMatchers(HttpMethod.GET,"/api_visite/homevisite").permitAll()
                .antMatchers(HttpMethod.GET, "/api_visite/visites").permitAll()
                .antMatchers(HttpMethod.GET, "/api_visite/visite/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api_visite/newvisite").permitAll()
                .antMatchers(HttpMethod.PUT,"/api_visite/updatevisite/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api_visite/deletevisite/**").permitAll()

                .antMatchers(HttpMethod.GET,"/apic/homec").permitAll()
                .antMatchers(HttpMethod.GET, "/apic/comments").permitAll()
                .antMatchers(HttpMethod.GET, "/apic/comment/**").permitAll()
                .antMatchers(HttpMethod.POST,"/apic/newcomment").permitAll()

                .antMatchers(HttpMethod.GET,"/apim/homem").permitAll()
                .antMatchers(HttpMethod.GET, "/apim/medias").permitAll()
                .antMatchers(HttpMethod.GET, "/apim/media/**").permitAll()
                .antMatchers(HttpMethod.POST,"/apim/newmedia").permitAll()
                .antMatchers(HttpMethod.PUT,"/apim/updatemedia/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/apim/deletemedia/**").permitAll()

                .antMatchers(HttpMethod.GET,"/apifp/homefp").permitAll()
                .antMatchers(HttpMethod.GET, "/apifp/factures").permitAll()
                .antMatchers(HttpMethod.GET, "/apifp/facture/**").permitAll()
                .antMatchers(HttpMethod.POST,"/apifp/newfactpaie").permitAll()
                .antMatchers(HttpMethod.PUT,"/apifp/updatefactpaie/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/apifp/deletefactpaie/**").permitAll()

                .antMatchers(HttpMethod.GET,"/apip/homep").permitAll()
                .antMatchers(HttpMethod.GET, "/apip/plannings").permitAll()
                .antMatchers(HttpMethod.GET, "/apip/planning/**").permitAll()
                .antMatchers(HttpMethod.POST,"/apip/newplanning").permitAll()
                .antMatchers(HttpMethod.PUT,"/apip/updateplanning/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/apip/deleteplanning/**").permitAll()

                .antMatchers("/al/Alfresco-down").permitAll()
                .antMatchers("/al/Alfresco-docs").permitAll()
                .antMatchers("/al/Alfresco-fold").permitAll()
                .antMatchers("/test/anonymous").permitAll()
                .antMatchers("/test/user").hasAnyRole("user")
                .antMatchers("/test/admin").hasAnyRole("admin")
                .antMatchers("/test/manager").hasAnyRole("manager")
                .antMatchers("/test/all-user").hasAnyRole("user","admin","manager")
                .antMatchers("/user/create").permitAll()
                .antMatchers("/user/login").permitAll()


                .anyRequest()
                .permitAll();
        http.csrf().disable();
    }   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }    @Bean
    public KeycloakConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

} */