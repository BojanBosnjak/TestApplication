package com.bojan.app;


/*Pocetak Cetvrtak 18.06. u 10:00 casova
 * 10:00-14:00 napravio sve sem rest controllera
 * 
 * 16:00-18:15 napravio rest controllere, istestirao ih i pogledao kako da uradim deploy na azure
 * 
 * 19.06. napraviti oba preostala upita, security i testove
 * Poceo u 10 ujutro
 * 
 * 20. 06. poceo u 11 pauza za rucak trajala sat vremena od 15 do 16, radio do 19
 * 
 * 21. 06. poceo oko 9, oko 15 je aplikacija bila gotova do 19 radio kozmetiku
 * 
 * 22. napravititekstualno sta traze da uradim i pokusati da je okacim na azure
 * 09:30
 */

//18:15
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bojan.app.repository.UsersRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class CyrillicsFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyrillicsFarmApplication.class, args);
	}
	
	

}
