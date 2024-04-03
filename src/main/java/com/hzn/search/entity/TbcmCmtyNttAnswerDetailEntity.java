package com.hzn.search.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.TermVector;
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
@Table (name = "TBCM_CMTY_NTT_ANSWER_DETAIL")
@Indexed
public class TbcmCmtyNttAnswerDetailEntity {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column (name = "CMTY_NTT_ANSWER_SN")
	@GenericField (sortable = Sortable.YES)
	private int cmtyNttAnswerSn;

	@Column (name = "CMTY_NTT_SN")
	private int cmtyNttSn;

	@Column (name = "NTT_PARNTS_ANSWER_SN")
	private Integer nttParntsAnswerSn;

	@Column (name = "ACNT_TY_CODE")
	private String acntTyCode;

	@Column (name = "USER_SN")
	private Integer userSn;

	@Column (name = "MNGR_SN")
	private Integer mngrSn;

	@Column (name = "NTT_STTUS_CODE")
	private String nttSttusCode;

	@Column (name = "NTT_ANSWER_LEVEL")
	private Integer nttAnswerLevel;

	@Column (name = "NTT_ANSWER_CN")
	@FullTextField (termVector = TermVector.YES, analyzer = "htmlStrippingAnalyzer")
	private String nttAnswerCn;

	@Column (name = "MENTN_USER_AT")
	private String mentnUserAt;

	@Column (name = "MENTN_USER_SN")
	private Integer mentnUserSn;

	@Column (name = "NTT_ANSWER_REGIST_DT")
	private LocalDateTime nttAnswerRegistDt;

	@Column (name = "NTT_ANSWER_OTHBC_AT")
	private String nttAnswerOthbcAt;

	@Column (name = "RPT_AT")
	private String rptAt;

	@Column (name = "SANCTNS_INAPT_RPT_SN")
	private Integer sanctnsInaptRptSn;

	@Column (name = "RPT_DT")
	private LocalDateTime rptDt;

	@Column (name = "SANCTNS_AT")
	private String sanctnsAt;

	@Column (name = "SANCTNS_PROCESS_SN")
	private Integer sanctnsProcessSn;

	@Column (name = "SANCTNS_DT")
	private LocalDateTime sanctnsDt;

	@Column (name = "SANCTNS_RELIS_DT")
	private LocalDateTime sanctnsRelisDt;

	@Column (name = "MNGR_MEMO")
	private String mngrMemo;

	@Column (name = "EXPSR_ORDR")
	private Integer expsrOrdr;

	@Column (name = "DELETE_AT")
	private String deleteAt;

	@Column (name = "SYS_REGIST_DT")
	private LocalDateTime sysRegistDt;

	@Column (name = "SYS_REGISTER_SN")
	private Integer sysRegisterSn;

	@Column (name = "SYS_UPDT_DT")
	private LocalDateTime sysUpdtDt;

	@Column (name = "SYS_UPDUSR_SN")
	private Integer sysUpdusrSn;

	@Column (name = "DAO_SBSCRB_AT")
	private String daoSbscrbAt;

	@Column (name = "DAO_PARTCPN_SN")
	private Integer daoPartcpnSn;

	@Column (name = "RPT_CO")
	private int rptCo;

	@Column (name = "EXPSR_AT")
	private String expsrAt;
}
