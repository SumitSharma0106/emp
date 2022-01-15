package com.cl.emp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.net.HttpURLConnection;
import java.util.Collection;

@Getter
@Setter
public class ResponseDto {

    private int httpStatus;
    private Object data;
    private String message;
    private boolean readOnly=false;

    public ResponseDto(int httpStatus, Object data, String message) {
        this.httpStatus = httpStatus;
        this.data = data;
        this.message = message;
    }

    public ResponseDto(int httpStatus, Object data, String message, boolean readOnly) {
        this.httpStatus = httpStatus;
        this.data = data;
        this.message = message;
        this.readOnly = readOnly;
    }

    public ResponseDto(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ResponseDto() {
    }

    public static ResponseDto ok(Object body){
        return new ResponseDto(HttpURLConnection.HTTP_OK,body,null);
    }

    public static ResponseDto ok(Object body,String message){
        return new ResponseDto(HttpURLConnection.HTTP_OK,body,message);
    }

    public static ResponseDto ok(Object body,String message,boolean readOnly){
        return new ResponseDto(HttpURLConnection.HTTP_OK,body,message,readOnly);
    }

    public static ResponseDto create(Object body, String message){
        return new ResponseDto(HttpURLConnection.HTTP_CREATED,body,message);
    }

    public static ResponseDto not_found(Object objectId, String message) {
        return new ResponseDto (HttpURLConnection.HTTP_NOT_FOUND, objectId, message);
    }

    public static ResponseDto not_found(String message) {
        return new ResponseDto(HttpURLConnection.HTTP_NOT_FOUND, message);
    }

    public static ResponseDto validation_errors(Collection<ObjectError> errors) {
        return new ResponseDto(HttpURLConnection.HTTP_BAD_REQUEST, errors, "Your submission was invalid, fix the following");
    }

    public static ResponseDto bad_request(String message) {
        return new ResponseDto(HttpURLConnection.HTTP_BAD_REQUEST, null, message);
    }

    public static ResponseDto server_error(Exception e) {
        return new ResponseDto(HttpURLConnection.HTTP_INTERNAL_ERROR, e.getStackTrace(), "Server blew up");
    }

    public static ResponseDto server_error(Object e, String message) {
        return new ResponseDto(HttpURLConnection.HTTP_INTERNAL_ERROR, e, message );
    }

    public static ResponseDto forbidden(Object objectId, String message) {
        return new ResponseDto(HttpURLConnection.HTTP_FORBIDDEN, objectId, message);
    }

    public static ResponseDto unsupported(String message) {
        return new ResponseDto(HttpURLConnection.HTTP_NOT_ACCEPTABLE, null, message);
    }

    public static ResponseDto no_content(String message) {
        return new ResponseDto(HttpURLConnection.HTTP_NO_CONTENT, message);
    }


}
