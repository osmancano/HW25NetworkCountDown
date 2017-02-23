package com.ironyard.controllers.rest;

import com.ironyard.data.TIYResponse;
import com.ironyard.util.ApiCaller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by osmanidris on 2/23/17.
 */
@RestController
public class RestNetworkController {
    String[] nodes = {"192.1","sd","","","",""};
    @RequestMapping(path = "/rest/call/{number}", method = RequestMethod.GET)
    public TIYResponse drawCard(@PathVariable(required = false) Integer number) throws Exception{
        if(number == null){
            number = 25;
        }
        number = sayNumber(number);
        if(number >= 0) {
            Thread.sleep(2000);
            (new ApiCaller(number)).start();
        }
        return new TIYResponse(true,number);
    }

    private Integer sayNumber(Integer number) throws Exception{
        ProcessBuilder pb;
        String wordsToSay = "Lift off";
        if(number > 0){
            wordsToSay = Integer.toString(number);
        }
        pb = new ProcessBuilder("say", wordsToSay);
        Process p = pb.start();
        return number-1;
    }
}
