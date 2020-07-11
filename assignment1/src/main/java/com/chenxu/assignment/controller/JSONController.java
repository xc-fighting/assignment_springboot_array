package com.chenxu.assignment.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class JSONController {

     @ResponseBody
     @RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
     public String getByRequest(HttpServletRequest request) {
          JSONObject jsonParam = this.getJSONParam(request);

          JSONObject result = new JSONObject();
          result.put("msg", "ok");
          result.put("method", "request");
          result.put("data", jsonParam);

          return result.toJSONString();
     }

     public JSONObject getJSONParam(HttpServletRequest request){
          JSONObject jsonParam = null;
          try {
               // obtain the input
               BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

               // write into stringbuilder
               StringBuilder sb = new StringBuilder();
               String line = null;
               while ((line = streamReader.readLine()) != null) {
                    sb.append(line);
               }
               jsonParam = JSONObject.parseObject(sb.toString());
               // print out json
               System.out.println(jsonParam.toJSONString());
          } catch (Exception e) {
               e.printStackTrace();
          }
          return jsonParam;
     }

}
