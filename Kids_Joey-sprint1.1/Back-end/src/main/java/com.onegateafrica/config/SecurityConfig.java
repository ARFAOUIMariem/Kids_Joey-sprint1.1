/*package com.onegateafrica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/al/Alfresco-down").permitAll()
                .antMatchers("/al/Alfresco-docs").permitAll()
                .antMatchers("/al/Alfresco-fold").permitAll()

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
                .antMatchers(HttpMethod.PUT,"/apic/updatecomment/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/apic/deletecomment/**").permitAll()

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
                .anyRequest().authenticated();
    }
    @Bean

    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }






}*/