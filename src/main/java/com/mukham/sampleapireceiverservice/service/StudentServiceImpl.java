package com.mukham.sampleapireceiverservice.service;

import com.mukham.sampleapireceiverservice.model.entity.AccountHistory;
import com.mukham.sampleapireceiverservice.model.entity.Student;
import com.mukham.sampleapireceiverservice.model.response.ResponseObject;
import com.mukham.sampleapireceiverservice.model.response.ResponseObjectList;
import com.mukham.sampleapireceiverservice.model.response.StatusObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j // for logging by using lombok
@Service // create bean class
public class StudentServiceImpl implements StudentService {
    @Override
    public Student requestPathVariableAndResponseObjectDemo(String action) {
        // here, you can find from database as per this requested data (id) or do your logic depend on your application business logic.
        // here, you can get this response data from database or can get data from others method depend on your application business logic.
        // here, I show as demo and don't do any other logic and return hard code values.

        return new Student(1L, "Mu Kham Aw", "Yangon", "+959123456789", "Room A");
    }

    @Override
    public List<Student> requestParamStringAndResponseObjectListDemo(String name, String phoneNo) {
        // here, you can find from database as per this requested data (name, phoneNo) or do your logic depend on your application business logic.
        // here, you can get this response data from database or can get data from others method depend on your application business logic.
        // here, I show as demo and don't do any other logic and return hard code values.

        return Arrays.asList(new Student(1L, "Mu Kham Aw", "Yangon", "+959123456789", "Room A"),
                new Student(2L, "Mg Mg", "Mandalay", "+959123456789", "Room B"),
                new Student(3L, "Aung Aung", "NayPyiTaw", "+959123456789", "Room C"));
    }

    // this method is like validate token and if valid, save data
    @Override
    public ResponseObject requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo(Map<String, String> allHeadersMap, Student student) {
        // here, you can save into database as per this requested data (student) or do your logic depend on your application business logic.
        // here, you can get this response data from database or can get data from others method depend on your application business logic.
        // here, I show as demo and don't do any other logic and return hard code values.

        // get header value, example field and field name is depend on your application logic.
        String accessToken = allHeadersMap.get("authorization");
        log.info("accessToken: {}", accessToken);

        // you can do other things that header value depend on you logic.
        // eg. check accessToken is valid or not.
        // eg. if valid accessToken, do your logic like insert requested data into db
        // eg. if invalid accessToken, return error with status fail.
        // you can get other header values as depend on your application business logic.

        String timestamp = Instant.now().toString(); // current time
        StatusObject status = new StatusObject("SUCCESS", "No Error");

        ResponseObject response = new ResponseObject(timestamp, status); // set data by using constructor
        return response; // you can directly return above new ResponseObject
    }

    @Override
    public ResponseObjectList requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo(Map<String, String> allHeadersMap, String name, String phoneNo) {
        // here, you can find from database as per this requested data (name, phoneNo) or do your logic depend on your application business logic.
        // here, you can get this response data from database or can get data from others method depend on your application business logic.
        // here, I show as demo and don't do any other logic and return hard code values.

        // get header value, example field and field name is depend on your application logic.
        String accessToken = allHeadersMap.get("authorization");
        log.info("accessToken: {}", accessToken);

        // you can do other things that header value depend on you logic.
        // eg. check accessToken is valid or not.
        // eg. if valid accessToken, do your logic like insert requested data into db
        // eg. if invalid accessToken, return error with status fail.
        // you can get other header values as depend on your application business logic.

        String timestamp = Instant.now().toString(); // current time
        StatusObject status = new StatusObject("SUCCESS", "No Error");

        List<Student> stuList = Arrays.asList(new Student(1L, "Mu Kham Aw", "Yangon", "+959123456789", "Room A"),
                new Student(2L, "Mg Mg", "Mandalay", "+959123456789", "Room B"),
                new Student(3L, "Aung Aung", "NayPyiTaw", "+959123456789", "Room C"));

        ResponseObjectList response = new ResponseObjectList(timestamp, status, stuList);
        return response; // you can directly return above new ResponseObjectList

    }

    @Override
    public ResponseObjectList requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo(Map<String, String> allHeadersMap, String accountName, String cardType, Integer pageNo, Integer pageSize, String sortBy, String actionType) {
        // here, you can find from database as per this requested data (name, phoneNo) or do your logic depend on your application business logic.
        // here, you can get this response data from database or can get data from others method depend on your application business logic.
        // here, I show as demo and don't do any other logic and return hard code values.

        // get header value, example field and field name is depend on your application logic.
        String accessToken = allHeadersMap.get("authorization");
        log.info("accessToken: {}", accessToken);

        // you can do other things that header value depend on you logic.
        // eg. check accessToken is valid or not.
        // eg. if valid accessToken, do your logic like insert requested data into db
        // eg. if invalid accessToken, return error with status fail.
        // you can get other header values as depend on your application business logic.

        String timestamp = Instant.now().toString(); // current time
        StatusObject status = new StatusObject("SUCCESS", "No Error");

        // below values may get from database or somewhere like api response by calling others or others method response.
        // but, this is demo project and so, I return hard coded values.
        List<AccountHistory> accountHistoriesList = Arrays.asList(new AccountHistory(1L, "Mu Kham Aw", "VISA", "Bill", "+959123456789", "Yangon", "02/09/2022 10:03:23", "1000"),
                new AccountHistory(2L, "Mu Kham Aw", "VISA", "Bill", "+959123456789", "Yangon", "10/09/2022 15:30:09", "5000"),
                new AccountHistory(3L, "Mu Kham Aw", "VISA", "Bill", "+959123456789", "Yangon", "19/09/2022 13:20:56", "2000"));

        ResponseObjectList response = new ResponseObjectList(timestamp, status, accountHistoriesList);
        return response; // you can directly return above new ResponseObjectList
    }

    @Override
    public ResponseObjectList errorBadRequestResponseDemo(String name, String phone) {
        // here, you can do your logic
        // if your validation wasn't right as you expected, you can return error.

        // do you logic eg. checking input, retrieving from db, comparing data, etc...
        // here, I show as demo and don't do any other logic and will return error only.

        String timestamp = Instant.now().toString(); // current time
        StatusObject status = new StatusObject("FAIL", "Input is something wrong");
        return new ResponseObjectList(timestamp, status, null);
    }

    @Override
    public ResponseObjectList errorNotFoundResponseDemo(Integer id) {
        // here, you can do your logic
        // if your validation wasn't right as you expected, you can return error.

        // do you logic eg. checking input, retrieving from db, comparing data, etc...
        // here, I show as demo and don't do any other logic and will return error only.

        String timestamp = Instant.now().toString(); // current time
        StatusObject status = new StatusObject("FAIL", "Input is something wrong");
        return new ResponseObjectList(timestamp, status, null);
    }

    @Override
    public ResponseObjectList errorInternalServerErrorResponseDemo(Student student) {
        // here, you can do your logic
        // if your validation wasn't right as you expected, you can return error.

        // do you logic eg. checking input, retrieving from db, comparing data, etc...
        // here, I show as demo and don't do any other logic and will return error only.

        // internal server error is mostly return when system error from catch block like null pointer, etc..

        String timestamp = Instant.now().toString(); // current time
        StatusObject status = new StatusObject("FAIL", "Input is something wrong");
        return new ResponseObjectList(timestamp, status, null);
    }

}
