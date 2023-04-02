package com.example.lesson15.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //1 вариант: аунтефикация через базу данных(юзеры там лежат)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    //2 вариант: настройка и добавление юзеров вручную (обычно используется для проверки и тестирования)
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(users.username("user1").password("pass1").roles("USER", "ADMIN"))
//                .withUser(users.username("user2").password("pass2").roles("USER"));
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .anyRequest().permitAll() //разрешить доступ всем куда угодно
                .antMatchers("/products/show_product/**").hasAnyRole("ADMIN") //делаем так что в раздел могут зайти только пользователи с ролью ADMIN
//                .antMatchers("/products/edit/**").hasAnyRole("ADMIN", "MANAGER") //аналогично для манагера
                .and()
//                .httpBasic() //базовая форма аунтефикации
                .formLogin() //стандартная форма для логина в спринге
//                    .loginPage("/login")
//                    .loginProcessingUrl("/authenticateTheUser")
                .permitAll();
    }
}
