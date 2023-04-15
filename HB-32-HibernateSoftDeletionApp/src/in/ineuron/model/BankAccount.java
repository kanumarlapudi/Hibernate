package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "bankaccount")
@SQLDelete(sql = "UPDATE bankaccount set status = 'closed' WHERE accno=?")
@Where(clause = "status not in ('closed','blocked')")

public class BankAccount {

	@Id
	private Integer accno;
	private String holderName;
	private Integer balance;
	private String status;

	static {
		System.out.println("BankAccount.class file is loading...");
	}

	public BankAccount() {
		System.out.println("BankAccount object is used by Hibernate...");
	}

	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}

}
