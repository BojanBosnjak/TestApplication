package com.bojan.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Account {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer accountId;
	
	@Column(unique = true)
	@NotNull
	private String accountName;


/*Ako brisem User, da ne obrisem account
 * Jedan User ima pristup vise account-ova
 */
	@ManyToOne(cascade= {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH	})
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
}
