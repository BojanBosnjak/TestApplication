package com.bojan.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Farm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer farmId;
	@NotNull
	@Column(unique = true)
	private String name;
	
/*Farma je vezana za jedan acc
 */
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "account_id", insertable = false, updatable = false)
	private Account account;

	/*Ako brisem User, da ne obrisem farmu
	 *Jedan user ima pristup vise farmi
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	public Integer getFarmId() {
		return farmId;
	}

	public void setFarmId(Integer farmId) {
		this.farmId = farmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
