package com.travelgo.backend.global.exception.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    OK(HttpStatus.OK, "정상 처리 되었습니다."),

    DO_NOT_LOGIN(HttpStatus.NOT_FOUND, "현재 로그인중이 아닙니다."),

    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."),
    NOT_FOUND_AREA(HttpStatus.NOT_FOUND, "지역를 찾을 수 없습니다."),
    NOT_FOUND_ORDER(HttpStatus.NOT_FOUND, "주문을 찾을 수 없습니다."),
    NOT_FOUND_ATTRACTION(HttpStatus.NOT_FOUND, "명소를 찾을 수 없습니다."),
    NOT_FOUND_WEATHER(HttpStatus.NOT_FOUND, "날씨를 찾을 수 없습니다."),
    NOT_COMMON_ATTRACTION(HttpStatus.NOT_FOUND, "등록한 명소가 아닙니다."),
    NOT_CUSTOM_ATTRACTION(HttpStatus.NOT_FOUND, "커스텀 명소가 아닙니다."),
    NOT_FOUND_REVIEW(HttpStatus.NOT_FOUND, "리뷰를 찾을 수 없습니다."),
    NOT_FOUND_ITEM(HttpStatus.NOT_FOUND, "아이템을 찾을 수 없습니다."),
    NOT_FOUND_ACHIEVEMENT(HttpStatus.NOT_FOUND, "이력을 찾을 수 없습니다."),
    NOT_FOUND_GEO(HttpStatus.NOT_FOUND, "위경도로 지역을 찾을 수 없습니다."),
    NOT_FOUND_KAKAO(HttpStatus.NOT_FOUND, "카카오 API에서 올바른 응답을 가져오지 못했습니다."),
    NOT_REWARD_ATTRACTION(HttpStatus.BAD_REQUEST, "현재 보상 받을 수 있는 지역이 아닙니다."),
    ALREADY_EXIST_USER(HttpStatus.NOT_FOUND, "이미 사용 중인 닉네임입니다."),



    DUPLICATED_USER(HttpStatus.CREATED, "이미 존재하는 회원입니다."),
    DUPLICATED_ITEM(HttpStatus.CREATED, "이미 존재하는 아이템입니다."),
    DUPLICATED_VISIT(HttpStatus.CREATED, "이미 존재하는 방문 기록입니다."),
    DUPLICATED_ATTRACTION(HttpStatus.CREATED, "이미 존재하는 명소입니다."),

    EMPTY_VALUE(HttpStatus.NOT_FOUND, "데이터가 비어있습니다."),
    INCLUDE_SLANG(HttpStatus.BAD_REQUEST, "닉네임에 비속어가 포함되어 있습니다."),
    S3_BUCKET_ERROR(HttpStatus.BAD_REQUEST, "S3 업로드 과정중 오류가 발생했습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "정상적인 요청이 아닙니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증이 필요합니다."),
    UNAUTHORIZED_KAKAO(HttpStatus.UNAUTHORIZED, "카카오 API 호출 중 오류 발생"),
    UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR, "알수없는 에러 발생.");

    private final HttpStatus code;
    private final String message;
}

