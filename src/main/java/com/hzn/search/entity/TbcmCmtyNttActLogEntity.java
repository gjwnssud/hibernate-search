package com.hzn.search.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

/**
 * <p></p>
 *
 * @author hzn
 * @date 4/2/24
 */
@Setter
@Getter
@Entity
@Table (name = "TBCM_CMTY_NTT_ACT_LOG")
@Indexed
public class TbcmCmtyNttActLogEntity {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column (name = "NTT_ACT_LOG_SN")
	@GenericField (sortable = Sortable.YES)
	private int nttActLogSn;

	@Column (name = "PREV_NTT_ACT_LOG_SN")
	private Integer prevNttActLogSn;

	@Column (name = "ACNT_TY_CODE")
	private String acntTyCode;

	@Column (name = "USER_SN")
	private Integer userSn;

	@Column (name = "MNGR_SN")
	private Integer mngrSn;

	@Column (name = "NTT_TY_CODE")
	private String nttTyCode;

	@Column (name = "CMTY_NTT_SN")
	private Integer cmtyNttSn;

	@Column (name = "CMTY_NTT_ANSWER_SN")
	private Integer cmtyNttAnswerSn;

	@Column (name = "PRMBRSH_CNTNTS_AT")
	private String prmbrshCntntsAt;

	@Column (name = "PRMBRSH_PGM_SN")
	private Integer prmbrshPgmSn;

	@Column (name = "SVC_ACT_CODE")
	@FullTextField (analyzer = "standard")
	private String svcActCode;

	@Column (name = "SVC_ACT_REGIST_DT")
	private LocalDateTime svcActRegistDt;

	@Column (name = "SVC_ACT_CO")
	private int svcActCo;

	@Column (name = "SVC_ACT_SCORE")
	private BigDecimal svcActScore;

	@Column (name = "SANCTNS_PROCESS_SN")
	private Integer sanctnsProcessSn;

	@Column (name = "SANCTNS_INAPT_RPT_SN")
	private Integer sanctnsInaptRptSn;

	@Column (name = "SESION_ID")
	private String sesionId;

	@Column (name = "LM_BLC_TRNSMIS_AT")
	private String lmBlcTrnsmisAt;

	@Column (name = "TXHASH_SN")
	private Integer txhashSn;

	@Column (name = "SIGN_TXHASH")
	private String signTxhash;

	@Column (name = "LM_BLC_TRNSMIS_DT")
	private LocalDateTime lmBlcTrnsmisDt;

	@Column (name = "LM_BLC_TRNSMIS_RESULT_CODE")
	private String lmBlcTrnsmisResultCode;

	@Column (name = "SYS_REGIST_DT")
	private LocalDateTime sysRegistDt;

	@Column (name = "SYS_REGISTER_SN")
	private Integer sysRegisterSn;

	@Column (name = "SYS_UPDT_DT")
	private LocalDateTime sysUpdtDt;

	@Column (name = "SYS_UPDUSR_SN")
	private Integer sysUpdusrSn;

	@Column (name = "NTT_ACT_SM_SN")
	private Integer nttActSmSn;
}
