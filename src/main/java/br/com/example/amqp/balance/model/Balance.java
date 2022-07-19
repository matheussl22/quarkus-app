package br.com.example.amqp.balance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Entity
public class Balance extends PanacheEntityBase {

    @Id
    private Integer id;
    private String name;
    private BigDecimal value;

    @Transient
    private BigDecimal initialBalance;

    @Transient
    private String hostName;

    public Balance() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.value = initialBalance;
    }

    public String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "balance{" +
                "id='" + id + '\'' +
                "product='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
