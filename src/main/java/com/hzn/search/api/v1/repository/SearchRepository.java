package com.hzn.search.api.v1.repository;

import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@Repository ("SearchRepository-v1")
public interface SearchRepository extends JpaRepository<TbcmCmtyNttInfoEntity, Integer> {
	List<TbcmCmtyNttInfoEntity> findTbcmCmtyNttInfoEntitiesByNttCnContainingIgnoreCaseOrNttSjContainingIgnoreCaseOrderByCmtyNttSnDesc (String nttCn, String nttSj, Pageable pageable);
}
