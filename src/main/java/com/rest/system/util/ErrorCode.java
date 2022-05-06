package com.rest.system.util;

public enum ErrorCode {

	CODE40001("40001", "요청 파라미터에 문제가 있습니다. - API"),
	CODE40002("40002", "헤더 값이 존재하지 않습니다. - API"),
	CODE40101("40101", "접근토큰 값이 유효하지 않습니다. - API"),
	CODE40102("40102", "허용되지 않은 원격지 IP 입니다. - API"),
	CODE40103("40103", "접근토큰이 폐기된 상태 입니다. - API"),
	CODE40104("40104", "API 사용 권한이 없습니다. - API"),
	CODE40105("40105", "정보 조회 권한이 없습니다. - API"),
	CODE40301("40301", "올바르지 않은 API 호출 입니다. - API"),
	CODE40302("40302", "일시적으로 해당 클라이언트의 요청이 제한 되었습니다. - API"),
	CODE40303("40303", "기관 코드 확인이 불가합니다. - API"),
	CODE40304("40304", "최대 보존기간을 초과한 데이타 요청 입니다. - API"),
	CODE40305("40305", "자산이 유효한 상태가 아닙니다. - API"),
	CODE40401("40401", "요청한 주소가 존재하지 않습니다. - API"),
	CODE40402("40402", "요청한 정보가 존재하지 않습니다. - API"),
	CODE40403("40403", "정보주체(고객)이 존재하지 않습니다. - API"),
	CODE40404("40404", "해지된 자산 입니다. - API"),
	CODE42901("42901", "정보제공 요청한도가 초과 되었습니다. - API"),
	CODE42902("42902", "일시적으로 해당 클라이언트의 요청이 제한 되었습니다. - API"),
	CODE50001("50001", "시스템에 장애가 발생 되었습니다. - API"),
	CODE50002("50002", "API 요청 처리에 실패 하였습니다. - API"),
	CODE50003("50003", "처리시간이 초과 되었습니다. - API"),
	CODE50004("50004", "알 수 없는 에러가 발생 되었습니다. - API");

	private final String errorCode;

	private final String errorMessage;

	ErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String errorCode() {
		return this.errorCode;
	}

	public String errorMessage() {
		return this.errorMessage;
	}

	@Override
	public String toString() {
		return this.errorCode + " " + this.errorMessage;
	}

}
