package com.mukham.sampleapireceiverservice.controller;

import com.mukham.sampleapireceiverservice.model.entity.Student;
import com.mukham.sampleapireceiverservice.model.response.ResponseObject;
import com.mukham.sampleapireceiverservice.model.response.ResponseObjectList;
import com.mukham.sampleapireceiverservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // for rest endpoint
@Slf4j // for logging by using lombok
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/requestPathVariableAndResponseObjectDemo/{action}")
    public ResponseEntity requestPathVariableAndResponseObjectDemo(@PathVariable String action){

        try{
            log.info("Enter requestPathVariableAndResponseObjectDemo method");
            log.info("request path variable value, action type: {}", action);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            Student dbStudent = studentService.requestPathVariableAndResponseObjectDemo(action);
            log.info("Response data: {}", dbStudent);

            log.info("Exit requestPathVariableAndResponseObjectDemo method");
            return ResponseEntity.ok().body(dbStudent);
            // here you can return like that ->
            // return new ResponseEntity(dbStudent, HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/requestParamStringAndResponseObjectListDemo")
    public ResponseEntity requestParamStringAndResponseObjectListDemo(@RequestParam String name, @RequestParam String phone){

        try{
            log.info("Enter requestParamStringAndResponseObjectListDemo method");
            log.info("request param value, name: {}, phone: {}", name, phone);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            List<Student> dbStudentList = studentService.requestParamStringAndResponseObjectListDemo(name, phone);
            log.info("Response data: {}", dbStudentList);

            log.info("Exit requestParamStringAndResponseObjectListDemo method");
            return ResponseEntity.ok().body(dbStudentList);
            // here you can return like that ->
            // return new ResponseEntity(dbStudentList, HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo")
    public ResponseEntity requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo(@RequestHeader Map<String, String> allHeadersMap,
                                                                                     @RequestBody Student student){

        try{
            log.info("Enter requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo method");
            log.info("request headers value, headers: {}", allHeadersMap);
            log.info("request body value, student: {}", student);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            ResponseObject responseObject = studentService.requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo(allHeadersMap, student);
            log.info("Response data: {}", responseObject);

            log.info("Exit requestFromHeaderAndRequestBodyAndResponseNestedObjectDemo method");
            return ResponseEntity.ok().body(responseObject);
            // here you can return like that ->
            // return new ResponseEntity(responseObject, HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo")
    public ResponseEntity requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo(@RequestHeader Map<String, String> allHeadersMap,
                                                                                                @RequestParam String name, @RequestParam String phone){

        try{
            log.info("Enter requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo method");
            log.info("request headers value, headers: {}", allHeadersMap);
            log.info("request param value, name: {}, phone: {}", name, phone);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            ResponseObjectList responseObjectList = studentService.requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo(allHeadersMap, name, phone);
            log.info("Response data: {}", responseObjectList);

            log.info("Exit requestFromHeaderAndRequestParamStringAndResponseNestedObjectListDemo method");
            return ResponseEntity.ok().body(responseObjectList);
            // here you can return like that ->
            // return new ResponseEntity(responseObjectList, HttpStatus.OK);

        }catch(Exception e) {
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo/accountName/{accountName}/cardType/{cardType}")
    public ResponseEntity requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo(@RequestHeader Map<String, String> allHeadersMap,
                                                                                              @PathVariable String accountName,
                                                                                              @PathVariable String cardType,
                                                                                              @RequestParam(defaultValue = "0") Integer pageNo, // set default value
                                                                                              @RequestParam(defaultValue = "10") Integer pageSize, // set default value
                                                                                              @RequestParam(defaultValue = "id") String sortBy, // set default value
                                                                                              @RequestParam String actionType){

        try{
            log.info("Enter requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo method");
            log.info("request headers value, headers: {}", allHeadersMap);
            log.info("request path variable value, accountName: {}, cardType: {}", accountName, cardType);
            log.info("request param values, pageNo: {}, pageSize: {}, sortBy: {}, actionType: {}", pageNo, pageSize, sortBy, actionType);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            ResponseObjectList responseObjectList =  studentService.requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo(allHeadersMap, accountName, cardType, pageNo, pageSize, sortBy, actionType);
            log.info("Response data: {}", responseObjectList);

            log.info("Exit requestFromHeaderAndPathVarAndParamsAndResponseNestedObjectListDemo method");
            return ResponseEntity.ok().body(responseObjectList);
            // here you can return like that ->
            // return new ResponseEntity(responseObjectList, HttpStatus.OK);


        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/errorBadRequestResponseDemo")
    public ResponseEntity errorBadRequestResponseDemo(@RequestParam String name, @RequestParam String phone){

        try{
            log.info("Enter errorBadRequestResponseDemo method");
            log.info("request param value, name: {}, phone: {}", name, phone);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            ResponseObjectList responseObjectList = studentService.errorBadRequestResponseDemo(name, phone);
            log.info("Response data: {}", responseObjectList);


            // you can check with status like below code in your real application
            /*if(responseObjectList.getStatus().getStatus().equals("FAIL")){ // you can declare fail as constant variable

            }*/

            log.info("Exit errorBadRequestResponseDemo method");
            return ResponseEntity.badRequest().body(responseObjectList);
            // here you can return like that ->
//             return new ResponseEntity(responseObjectList, HttpStatus.BAD_REQUEST);

        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/errorNotFoundResponseDemo/{id}")
    public ResponseEntity errorNotFoundResponseDemo(@PathVariable Integer id){

        try{
            log.info("Enter errorNotFoundResponseDemo method");
            log.info("request param value, id: {}", id);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            ResponseObjectList responseObjectList = studentService.errorNotFoundResponseDemo(id);
            log.info("Response data: {}", responseObjectList);


            // you can check with status like below code in your real application
            /*if(responseObjectList.getStatus().getStatus().equals("FAIL")){ // you can declare fail as constant variable

            }*/

            log.info("Exit errorNotFoundResponseDemo method");
//            return ResponseEntity.notFound().build();
            // above notFount().build() can't add response body data and so, I return like below.
            return new ResponseEntity(responseObjectList, HttpStatus.NOT_FOUND);

        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/errorInternalServerErrorResponseDemo")
    public ResponseEntity errorInternalServerErrorResponseDemo(@RequestBody Student student){

        try{
            log.info("Enter errorInternalServerErrorResponseDemo method");
            log.info("request param value, student: {}", student);

            // here you can do some validation logic like checking input data is null or etc.. and return bad request error.
            // this is demo project and so, I don't do any logic here.

            ResponseObjectList responseObjectList = studentService.errorInternalServerErrorResponseDemo(student);
            log.info("Response data: {}", responseObjectList);


            // you can check with status like below code in your real application
            /*if(responseObjectList.getStatus().getStatus().equals("FAIL")){ // you can declare fail as constant variable

            }*/

            log.info("Exit errorInternalServerErrorResponseDemo method");
            return ResponseEntity.internalServerError().build();
            // here you can return like that ->
//             return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }catch(Exception e){
            e.printStackTrace();
            log.error("error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


}
