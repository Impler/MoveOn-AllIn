package cn.impler.wechat.debt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.impler.wechat.debt.dto.DebtChannel;
import cn.impler.wechat.debt.dto.DebtType;

public class Debt {

	// serial number
	private int id;

	// debt type
	private DebtType type;

	// debtor
	private String debtor;

	// debt channel
	private DebtChannel channel;

	// debtor account number
	private String account;

	// debt amount
	private double amount;

	// debt date
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date debtDate;

	// predict settlement date
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date preSettlementDate;

	// real settlement date
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date realSettlementDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DebtType getType() {
		return type;
	}

	public void setType(DebtType type) {
		this.type = type;
	}

	public String getDebtor() {
		return debtor;
	}

	public void setDebtor(String debtor) {
		this.debtor = debtor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDebtDate() {
		return debtDate;
	}

	public void setDebtDate(Date debtDate) {
		this.debtDate = debtDate;
	}

	public Date getPreSettlementDate() {
		return preSettlementDate;
	}

	public void setPreSettlementDate(Date preSettlementDate) {
		this.preSettlementDate = preSettlementDate;
	}

	public Date getRealSettlementDate() {
		return realSettlementDate;
	}

	public void setRealSettlementDate(Date realSettlementDate) {
		this.realSettlementDate = realSettlementDate;
	}

	public DebtChannel getChannel() {
		return channel;
	}

	public void setChannel(DebtChannel channel) {
		this.channel = channel;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
