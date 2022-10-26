package com.mukham.sampleapireceiverservice.service;

import com.mukham.sampleapireceiverservice.model.entity.Student;
import com.mukham.sampleapireceiverservice.model.response.ResponseObject;
import com.mukham.sampleapireceiverservice.model.response.ResponseObjectList;

import java.util.List;
import java.util.Map;

public interface StudentService {
    /** for both request and response **/
    Student requestPathVariableAndResponseObjectDemo(String action);
    List<Student> requestParamStringAndResponseObjectListDemo(String name, String phoneNo);
    ResponseObject requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo(Map<String, String> allHeadersMap, Student student);
    ResponseObjectList requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo(Map<String, String> allHeadersMap, String name, String phoneNo);
    ResponseObjectList requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo(Map<String, String> allHeadersMap, String accountName, String cardType, Integer pageNo, Integer pageSize, String sortBy, String actionType);


    /** for error response sample **/
    ResponseObjectList errorBadRequestResponseDemo(String name, String phone);
    ResponseObjectList errorNotFoundResponseDemo(Integer id);
    ResponseObjectList errorInternalServerErrorResponseDemo(Student student);
}
