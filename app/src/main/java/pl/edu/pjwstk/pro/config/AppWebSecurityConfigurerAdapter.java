package pl.edu.pjwstk.pro;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class AppWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/getMovies").permitAll()
                .antMatchers("/getMovie/{movieId}").permitAll()
                .antMatchers("/getSeatsInAuditoriums").permitAll()
                .antMatchers("/setTaken/{seatId}").permitAll()
                .antMatchers("/setAvailable/{seatId}").permitAll()
                .antMatchers("/auth0/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
