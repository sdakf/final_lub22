package pl.sda.finalapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.sda.finalapp.beans.TextProvider;
import pl.sda.finalapp.beans.WelcomeTextService;

@Configuration
public class AppConfig {

    @Bean
    public TextProvider goodbyeService(){
        return new WelcomeTextService("goodbye");
    }

    @Bean
    public TextProvider somethingService(){
        return new WelcomeTextService("something");
    }

    @Profile("dev")
    @Bean(name = "welcomeTextService")
    public TextProvider welcomeTextService1(){
        return new WelcomeTextService("1");
    }

    @Profile("default")
    @Bean(name = "welcomeTextService")
    public TextProvider welcomeTextService2(){
        return new WelcomeTextService("2");
    }
}
