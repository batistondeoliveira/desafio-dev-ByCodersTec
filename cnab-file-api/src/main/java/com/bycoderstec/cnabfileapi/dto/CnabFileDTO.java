package com.bycoderstec.cnabfileapi.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.enums.StatusCnabFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CnabFileDTO {

	private Long id;

	private LocalDateTime datahora;

	@NotEmpty(message="Preenchimento obrigatório")
	private String filename;

	@NotEmpty(message="Preenchimento obrigatório")
	private MultipartFile conteudo;

	@Length(min=3, max=100, message="O tamanho deve ser entre 3 e 120 caracteres")
	@NotEmpty(message="Preenchimento obrigatório")
	private String user;

	private Integer status;

	public CnabFileDTO(				
		String fileName, 
		MultipartFile conteudo, 
		String user		
	) {
		super();		
		this.datahora = LocalDateTime.now();
		this.filename = fileName;
		this.conteudo = conteudo;
		this.user = user;
		this.status = StatusCnabFile.PENDING.getCod();
	}

	public StatusCnabFile getStatus() {
		return StatusCnabFile.toEnum(status);
	}

	public void setStatus(StatusCnabFile status) {
		this.status = (status == null) ? null : status.getCod(); 
	}
} 