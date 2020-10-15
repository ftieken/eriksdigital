package nl.fredtieken.eriksdigital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseDTO implements Serializable {

    private long id;
}
