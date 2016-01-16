package com.quiz.web.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.core.dto.QuestionDTO;
import com.quiz.indexer.questions.IQuizIndexerService;
import com.quiz.utils.SystemResponse;

@Controller
@RequestMapping("/indexer")
public class QuesMakerIndexerController {

    private static final Logger                  LOGGER                  = LoggerFactory.getLogger(QuesMakerIndexerController.class);
    
    @Autowired
    private IQuizIndexerService	quizIndexerService;
    
    @RequestMapping("/questionPanel")
    public String tagAdmin(ModelMap map) {
        //return "indexer/questionPanel";
    	return "Hello";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping("/questionPanel/getQuesByUserId")
    @GET
    @ResponseBody
    public SystemResponse getQuesByUserId(@RequestParam("userId") String userId) {
        SystemResponse response = new SystemResponse();
        response.setStatus(SystemResponse.ResponseStatus.FAIL.responseType());
        try {
            response.addItem("quesByUserId", quizIndexerService.getQuesByUserId(userId));
            response.setStatus(SystemResponse.ResponseStatus.SUCCESS.responseType());
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Could not retrieve questions from database due to exception " + e.getMessage());
        }
        LOGGER.info("Response:: "+response);
        return response;
    }
    
    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping("/questionPanel/saveQuesByUserId")
    @POST
    @ResponseBody
    public SystemResponse saveQuesByUserId(@RequestBody QuestionDTO quesDTO) {
        SystemResponse response = new SystemResponse();
        response.setStatus(SystemResponse.ResponseStatus.FAIL.responseType());
        try {
        	quizIndexerService.saveQuesByUserId(quesDTO);
            response.addItem("quesByUserId", quizIndexerService.getQuesByUserId(quesDTO.getSubmittedBy()));
            response.setStatus(SystemResponse.ResponseStatus.SUCCESS.responseType());
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Could not save question to database due to exception " + e.getMessage());
        }
        LOGGER.info("Response:: "+response);
        return response;
    }
    
    

}