package com.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	/** セキュリティの対象外を設定 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティを適用しない
		web
		.ignoring()
		.antMatchers("/webjars/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**");
	}

	/** セキュリティの各種設定 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// ログイン不要ページの設定
		http
		.authorizeRequests()
		.antMatchers("/login").permitAll() //直リンクOK
		.anyRequest().authenticated(); // それ以外は直リンクNG

		// ログイン処理
		http
		.formLogin()
		.loginProcessingUrl("/login") // ログイン処理のパス
		.loginPage("/login") // ログインページの指定
		.failureUrl("/login?error") // ログイン失敗時の遷移先
		.usernameParameter("userId") // ログインページのユーザーID
		.passwordParameter("password") // ログインページのパスワード
		.defaultSuccessUrl("/top", true); // 成功後の遷移先


		http.csrf().disable();
	}



	/** インメモリ認証の設定 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = passwordEncoder();

		// インメモリ認証
		auth
		.inMemoryAuthentication()
		.withUser("aki") // userを追加
		.password(encoder.encode("pass"))
		.roles("GENERAL");
	}
}
