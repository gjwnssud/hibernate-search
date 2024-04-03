package com.hzn.search.api.v1.repository;

import com.hzn.search.entity.TbcmCmtyNttAnswerDetailEntity;
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
@Repository
public interface SearchAnswerRepository extends JpaRepository<TbcmCmtyNttAnswerDetailEntity, Integer> {
	List<TbcmCmtyNttAnswerDetailEntity> findAllByNttAnswerCnContainingIgnoreCase (String answerCn, Pageable pageable);

	long countByNttAnswerCnContainingIgnoreCase (String answerCn);
}
