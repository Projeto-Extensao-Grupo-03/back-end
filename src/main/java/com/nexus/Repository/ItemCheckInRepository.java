package com.nexus.Repository;

import com.nexus.Entity.ItemCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCheckInRepository extends JpaRepository<ItemCheckIn, Integer> {
    List<ItemCheckIn> findByCheckIn_IdOrderByNumeroItemAsc(Integer checkInId);
}
