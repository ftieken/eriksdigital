package nl.fredtieken.eriksdigital.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="orders")
@SequenceGenerator(name="orderseq", initialValue=10, allocationSize=100000)
@Data

public class OrderDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
    private long id;

    private String status;
    private double price;
    private Date date;
}
