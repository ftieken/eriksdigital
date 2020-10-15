package nl.fredtieken.eriksdigital.repository;

import nl.fredtieken.eriksdigital.entity.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDTO, Long> {
}
