package com.test.tests_b.service;

import com.test.tests_b.dto.QuestionDTO;
import com.test.tests_b.mapper.QuesstionMapper;
import com.test.tests_b.mapper.UserMapper;
import com.test.tests_b.model.Quesstion;
import com.test.tests_b.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuesstionMapper quesstionMapper;

    public List<QuestionDTO> list(){
        List<Quesstion> quesstions=this.quesstionMapper.list();
        List<QuestionDTO> questionDTOList= new ArrayList<>();
        for(Quesstion quesstion : quesstions){
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO =new QuestionDTO();
            BeanUtils.copyProperties(quesstion,questionDTO);//可以将quesstion里的属性copy到questionDTO里
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
