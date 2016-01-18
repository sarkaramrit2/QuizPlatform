package com.quiz.web.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.indexer.questions.IQuizIndexerService;
import com.quiz.utils.SystemResponse;

@Controller
@RequestMapping("/indexer")
public class QuesReviewerIndexerController {

    private static final Logger                  LOGGER                  = LoggerFactory.getLogger(QuesMakerIndexerController.class);
    
    @Autowired
    private IQuizIndexerService	quizIndexerService;
    
    @RequestMapping("/questionPanel")
    public String tagAdmin(ModelMap map) {
        return "indexer/questionPanel"; //jsp of this name
    }

    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping("/questionPanel/getAllUnReviewQues")
    @GET
    @ResponseBody
    public SystemResponse getAllUnReviewQues() {
        SystemResponse response = new SystemResponse();
        response.setStatus(SystemResponse.ResponseStatus.FAIL.responseType());
        try {
            response.addItem("questions", quizIndexerService.getAllUnReviewQues());
            response.setStatus(SystemResponse.ResponseStatus.SUCCESS.responseType());
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Could not retrieve questions from database due to exception " + e.getMessage());
        }
        LOGGER.info("Response:: "+response);
        return response;
    }
    
    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping("/questionPanel/getAllLiveQues")
    @GET
    @ResponseBody
    public SystemResponse getAllLiveQues() {
        SystemResponse response = new SystemResponse();
        response.setStatus(SystemResponse.ResponseStatus.FAIL.responseType());
        try {
            response.addItem("questions", quizIndexerService.getAllLiveQues());
            response.setStatus(SystemResponse.ResponseStatus.SUCCESS.responseType());
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Could not retrieve questions from database due to exception " + e.getMessage());
        }
        LOGGER.info("Response:: "+response);
        return response;
    }
}