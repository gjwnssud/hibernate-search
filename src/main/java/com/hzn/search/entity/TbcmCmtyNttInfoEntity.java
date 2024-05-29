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
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/8/23
 */
@Entity
@Table (name = "TBCM_CMTY_NTT_INFO")
@Getter
@Setter
@Indexed
public class TbcmCmtyNttInfoEntity {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column (name = "CMTY_NTT_SN")
	@GenericField (sortable = Sortable.YES)
	private Integer cmtyNttSn;

	@Column (name = "SYS_ID")
	private String sysId;

	@Column (name = "TKN_NFT_SN")
	private Integer tknNftSn;

	@Column (name = "CMTY_NTT_CTGRY_SN")
	private Integer cmtyNttCtgrySn;

	@Column (name = "ACNT_TY_CODE")
	private String acntTyCode;

	@Column (name = "USER_SN")
	private Integer userSn;

	@Column (name = "MNGR_SN")
	private Integer mngrSn;

	@Column (name = "NTT_STTUS_CODE")
	private String nttSttusCode;

	@Column (name = "NTT_LEVEL")
	private Integer nttLevel;

	@Column (name = "NTT_TY_CODE")
	private String nttTyCode;

	@Column (name = "NTT_SNDBRD_LIVE_AT")
	private String nttSndbrdLiveAt;

	@Column (name = "PRMBRSH_CNTNTS_AT")
	private String prmbrshCntntsAt;

	@Column (name = "PRMBRSH_PGM_SN")
	private Integer prmbrshPgmSn;

	@Column (name = "NTT_SJ")
	@FullTextField (analyzer = "standard")
	private String nttSj;

	@Column (name = "NTT_CN")
	@FullTextField (analyzer = "standard")
	private String nttCn;

	@Column (name = "NTT_REGIST_DT")
	private LocalDateTime nttRegistDt;

	@Column (name = "NTCE_BEGIN_DT")
	private LocalDateTime ntceBeginDt;

	@Column (name = "NTCE_END_DT")
	private LocalDateTime ntceEndDt;

	@Column (name = "NTT_ATCHMNFL_AT")
	private String nttAtchmnflAt;

	@Column (name = "CARD_VIDEO_FILEID")
	private String cardVideoFileid;

	@Column (name = "BLUR_FILE_ID")
	private String blurFileId;

	@Column (name = "NTT_NOTICE_AT")
	private String nttNoticeAt;

	@Column (name = "NTT_NOTICE_BEGIN_DT")
	private LocalDateTime nttNoticeBeginDt;

	@Column (name = "NTT_NOTICE_END_DT")
	private LocalDateTime nttNoticeEndDt;

	@Column (name = "NTT_OTHBC_SCOPE_CODE")
	private String nttOthbcScopeCode;

	@Column (name = "NTT_PASSWORD_AT")
	private String nttPasswordAt;

	@Column (name = "NTT_PASSWORD")
	private String nttPassword;

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

	@Column (name = "NTT_RDCNT")
	private Integer nttRdcnt;

	@Column (name = "NTT_SHARE_CO")
	private int nttShareCo;

	@Column (name = "NTT_CHANGE_CO")
	private int nttChangeCo;

	@Column (name = "DAO_SBSCRB_AT")
	private String daoSbscrbAt;

	@Column (name = "DAO_PARTCPN_SN")
	private Integer daoPartcpnSn;

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

	@Column (name = "BK_NTT_CTGRY_NM_KO")
	private String bkNttCtgryNmKo;
}
